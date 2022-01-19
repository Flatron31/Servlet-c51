package by.tms.servlet;

import service.CalculatorService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet (urlPatterns = "/calculator")
public class CalculatorServlet extends HttpServlet {

    CalculatorService calculatorService = new CalculatorService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String value1 = req.getParameter("value1");
        String value2 = req.getParameter("value2");
        String action = req.getParameter("action");
        resp.getWriter().println(value1 + " " + action + " " + value2 + " = " + calculatorService.getResultAction(value1, value2, action));
    }




}
