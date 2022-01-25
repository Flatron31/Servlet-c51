package by.tms.servlet;

import entity.User;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet(urlPatterns = "/authorization", name = "AuthorizationServlet")
public class AuthorizationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        UserService userService = new UserService();
        User user = userService.getUser(login);
        HttpSession session = req.getSession();

        if (user != null) {
            if (password.equals(user.getPassword())){
                session.setAttribute("login", login);
            } else {
                System.out.println("пароля нету");
            }
        } else {
            System.out.println("нету челика");
        }

    }
}

