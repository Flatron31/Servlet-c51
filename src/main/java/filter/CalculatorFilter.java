package filter;

import entity.Constants;
import entity.User;
import service.UserService;
import validation.Validation;

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
        UserService userService = new UserService();
        User user = userService.getUser(login);
        if (req.getMethod().equalsIgnoreCase("GET")) {
             if (user.getAuthorizationSessionID() == null | !user.getAuthorizationSessionID().equals(session.getId()) ) {
                req.setAttribute("messageUserError", "User is not authorized");
                req.getServletContext().getRequestDispatcher(Constants.INFOERROR_JSP).forward(req, res);
            }
        }

        if (req.getMethod().equalsIgnoreCase("POST")) {
            Validation validation = new Validation();
            String value1 = req.getParameter("value1");
            String value2 = req.getParameter("value2");
            String action = req.getParameter("action");

            if (validation.isNull(value1, value2, action)) {
                req.setAttribute("messageNull", "Value is null");
                req.getServletContext().getRequestDispatcher(Constants.CALCULATOR_JSP).forward(req, res);
            }
            if (validation.isEmptyString(value1, value2, action)) {
                req.setAttribute("messageEmpty", "Value is empty");
                req.getServletContext().getRequestDispatcher(Constants.CALCULATOR_JSP).forward(req, res);
            }
            if (!validation.isNumber(value1) || !validation.isNumber(value2)) {
                req.setAttribute("messageNaN", "NaN");
                req.getServletContext().getRequestDispatcher(Constants.CALCULATOR_JSP).forward(req, res);
            }
        }
        chain.doFilter(req, res);
    }
}
