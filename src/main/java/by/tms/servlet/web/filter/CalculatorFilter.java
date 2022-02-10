package by.tms.servlet.web.filter;

import by.tms.servlet.web.Constants;
import by.tms.servlet.web.ParametrValidator;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(servletNames = "CalculatorServlet")
public class CalculatorFilter extends HttpFilter {
    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpSession session = req.getSession();
        String login = (String) session.getAttribute("login");
        if (req.getMethod().equalsIgnoreCase("GET")) {
             if (session.getAttribute("login") == null) {
                req.setAttribute("messageUserError", "User is not authorized");
                req.getServletContext().getRequestDispatcher(Constants.INFOERROR_JSP).forward(req, res);
            }
        }
        if (req.getMethod().equalsIgnoreCase("POST")) {
            ParametrValidator validation = new ParametrValidator();
            String value1 = req.getParameter("value1");
            String value2 = req.getParameter("value2");
            String action = req.getParameter("operation");

            if (validation.isNull(value1, value2, action)) {
                req.setAttribute("messageNull", "Value is null");
                req.getServletContext().getRequestDispatcher(Constants.INDEX_JSP).forward(req, res);
            }
            if (validation.isEmptyString(value1, value2, action)) {
                req.setAttribute("messageEmpty", "Value is empty");
                req.getServletContext().getRequestDispatcher(Constants.INDEX_JSP).forward(req, res);
            }
            if (!validation.isNumber(value1) || !validation.isNumber(value2)) {
                req.setAttribute("messageNaN", "NaN");
                req.getServletContext().getRequestDispatcher(Constants.INDEX_JSP).forward(req, res);
            }
        }
        chain.doFilter(req, res);
    }
}
