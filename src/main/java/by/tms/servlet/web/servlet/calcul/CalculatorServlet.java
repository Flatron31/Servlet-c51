package by.tms.servlet.web.servlet.calcul;

import by.tms.servlet.web.Constants;
import service.CalculatorService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = Constants.CALCULATOR_LINK, name = "CalculatorServlet")
public class CalculatorServlet extends HttpServlet {
    private CalculatorService calculatorService = new CalculatorService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getServletContext().getRequestDispatcher(Constants.CALCULATOR_JSP).forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String value1 = req.getParameter("value1");
        String value2 = req.getParameter("value2");
        String operation = req.getParameter("operation");
        HttpSession session = req.getSession();
        String login = (String) session.getAttribute("login");
        String result = calculatorService.getResultAction(value1, value2, operation, login);
        req.setAttribute("result", result);
        req.getServletContext().getRequestDispatcher(Constants.CALCULATOR_JSP).forward(req, resp);
    }
}
