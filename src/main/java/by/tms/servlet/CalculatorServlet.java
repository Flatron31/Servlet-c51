package by.tms.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet (urlPatterns = "/calculator")
public class CalculatorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String value1 = req.getParameter("value1");
        String value2 = req.getParameter("value2");
        String action = req.getParameter("action");
        double doubleValue1 = Double.parseDouble(value1);
        double doubleValue2 = Double.parseDouble(value2);
        double result = 0.0;
        

        if (action.equals("sum")){
            result = doubleValue1 + doubleValue2;
        }
        else if (action.equals("dif")){
            result = doubleValue1 - doubleValue2;
        }
        else if (action.equals("mult")){
            result = doubleValue1 * doubleValue2;
        }
        else if (action.equals("div")){
            result = doubleValue1 / doubleValue2;
        }
        resp.getWriter().println(value1 + " " + action + " " + value2 + " = " + result);

    }
}
