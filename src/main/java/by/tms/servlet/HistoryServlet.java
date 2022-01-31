package by.tms.servlet;

import history.HistoryCalculatorInMemory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/history_calculator", name = "HistoryServlet")
public class HistoryServlet extends HttpServlet {
    private HistoryCalculatorInMemory calculatorHistory = new HistoryCalculatorInMemory();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("history", calculatorHistory.printHistory());
        req.getServletContext().getRequestDispatcher("/pages/history.jsp").forward(req, resp);
    }
}
