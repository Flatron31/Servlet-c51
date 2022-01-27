package Filter;

import validation.Validation;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(servletNames = "CalculatorServlet")
public class CalculatorFilter extends HttpFilter {
    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        Validation validation = new Validation();
        String value1 = req.getParameter("value1");
        String value2 = req.getParameter("value2");
        String action = req.getParameter("action");
        if (req.getMethod().equals("POST")){
           if (validation.isNull(value1, value2, action)) {
               req.setAttribute("messageNull","Value is null");
               req.getServletContext().getRequestDispatcher("/pages/calculator.jsp").forward(req, res);
           } else if (validation.isEmptyString(value1, value2, action)) {
               req.setAttribute("messageEmpty","Value is empty");
               req.getServletContext().getRequestDispatcher("/pages/calculator.jsp").forward(req, res);
           } else if (!validation.isNumber(value1) || !validation.isNumber(value2)){
               req.setAttribute("messageNaN","NaN");
               req.getServletContext().getRequestDispatcher("/pages/calculator.jsp").forward(req, res);
           }
       } else {
            chain.doFilter(req, res);
        }



//        HttpSession session = req.getSession();
//        String login = req.getParameter("login");
//        if (user != null)
//            if(session.getAttribute(login) != null){
//                chain.doFilter(req, res);
//        } else {
//            System.out.println(" челик не реганулся");
//        }
    }
}
