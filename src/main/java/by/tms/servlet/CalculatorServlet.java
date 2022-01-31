package by.tms.servlet;

import entity.Constants;
import service.CalculatorService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
        String action = req.getParameter("action");
        req.setAttribute("result", calculatorService.getResultAction(value1, value2, action));
        req.getServletContext().getRequestDispatcher(Constants.CALCULATOR_JSP).forward(req, resp);
    }
}
