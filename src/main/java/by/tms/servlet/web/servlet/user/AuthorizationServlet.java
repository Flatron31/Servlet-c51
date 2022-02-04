package by.tms.servlet.web.servlet.user;

import by.tms.servlet.web.Constants;
import entity.User;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet(urlPatterns = Constants.AUTHORIZATION_LINK, name = "AuthorizationServlet")
public class AuthorizationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getServletContext().getRequestDispatcher(Constants.AUTHORIZATION_JSP).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        UserService userService = new UserService();
        User user = userService.getUser(login);
        HttpSession session = req.getSession();
        if (userService.isCheckUser(user)) {
            if (password.equals(user.getPassword())) {
                session.setAttribute("login", login);
                user.setAuthorizationSessionID(session.getId());
                resp.sendRedirect(Constants.HOME_LINK);
            } else {
                req.setAttribute("message", "Wrong password");
                req.getServletContext().getRequestDispatcher(Constants.AUTHORIZATION_JSP).forward(req, resp);
            }
        } else {
            req.setAttribute("message1", "User is not found");
            req.getServletContext().getRequestDispatcher(Constants.AUTHORIZATION_JSP).forward(req, resp);
        }
    }
}
