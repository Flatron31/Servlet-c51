package by.tms.servlet.web.filter;

import by.tms.servlet.web.Constants;
import by.tms.servlet.web.ParametrValidator;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(servletNames ="RegistrationServlet")
public class RegistrationFilter extends HttpFilter {
    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        if (req.getMethod().equalsIgnoreCase("POST")){
            String name = req.getParameter("name");
            String login = req.getParameter("login");
            String password = req.getParameter("password");
            ParametrValidator validation = new ParametrValidator();
            if (!validation.isNull(name, password, login) && !validation.isEmptyString(name, password, login)) {
                chain.doFilter(req, res);
            } else {
                req.setAttribute("messageErrorRegistration", "User not created");
                req.getServletContext().getRequestDispatcher(Constants.REGISTRATION_JSP).forward(req, res);
            }
        } else {
            chain.doFilter(req, res);
        }
    }
}
