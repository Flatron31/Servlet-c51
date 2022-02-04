package by.tms.servlet.web.servlet.calcul;

import by.tms.servlet.web.Constants;
import storage.InMemoryCalculatorHistory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = Constants.HISTORY_CALCULATOR_LINK, name = "HistoryServlet")
public class HistoryServlet extends HttpServlet {
    private InMemoryCalculatorHistory calculatorHistory = new InMemoryCalculatorHistory();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String login = (String) session.getAttribute("login");
        req.setAttribute("history", calculatorHistory.printHistory(login));
        req.getServletContext().getRequestDispatcher(Constants.HISTORY_JSP).forward(req, resp);
    }
}
