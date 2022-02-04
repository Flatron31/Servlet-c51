package by.tms.servlet.web.servlet.user;

import by.tms.servlet.web.Constants;
import service.CalculatorService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = Constants.LOGOUT_LINK)
public class LogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CalculatorService calculatorService = new CalculatorService();
        HttpSession session = req.getSession();
        String login = (String) session.getAttribute("login");
        if (session.getAttribute("login") != null) {
            calculatorService.deleteHistory(login);
            session.invalidate();
        }
        resp.sendRedirect(Constants.HOME_LINK);
    }
}
