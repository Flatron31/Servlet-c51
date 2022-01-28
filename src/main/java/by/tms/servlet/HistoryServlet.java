package by.tms.servlet;

import history.CalculatorHistory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/history_calculator")
public class HistoryServlet extends HttpServlet {
    private CalculatorHistory calculatorHistory = new CalculatorHistory();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        session.setAttribute("history", calculatorHistory.printHistory());
        req.getServletContext().getRequestDispatcher("/pages/history.jsp").forward(req, resp);
    }
}
