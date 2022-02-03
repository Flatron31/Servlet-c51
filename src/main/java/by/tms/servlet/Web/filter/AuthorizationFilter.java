package by.tms.servlet.Web.filter;

import by.tms.servlet.Web.Constants;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(servletNames = "AuthorizationServlet")
public class AuthorizationFilter extends HttpFilter {
    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        if (req.getMethod().equalsIgnoreCase("POST")) {
            String login = req.getParameter("login");
            String password = req.getParameter("password");
            if (login == null || password == null) {
                req.setAttribute("error", "Invalid parameters");
                req.getServletContext().getRequestDispatcher(Constants.AUTHORIZATION_JSP).forward(req, res);
            } else if (login.equals("") || password.equals("")) {
                req.setAttribute("error", "Invalid parameters");
                req.getServletContext().getRequestDispatcher(Constants.AUTHORIZATION_JSP).forward(req, res);
            } else {
                chain.doFilter(req, res);
            }
        } else {
            chain.doFilter(req, res);
        }
    }
}
