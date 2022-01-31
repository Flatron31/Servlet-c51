package by.tms.servlet;

import entity.Constants;

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
        HttpSession session = req.getSession();
        if (session.getAttribute("login") != null) {
            session.invalidate();
            req.setAttribute("messageLogout", "Logout successful");
            req.getServletContext().getRequestDispatcher(Constants.LOGOUT_JSP).forward(req, resp);
        } else {
            req.setAttribute("messageUserError", "User is not authorized");
            req.getServletContext().getRequestDispatcher(Constants.INFOERROR_JSP).forward(req, resp);
        }
    }
}
