package by.tms.servlet.web.servlet.user;

import by.tms.servlet.web.Constants;
import entity.User;
import service.UserService;
import storage.InMemoryUserStorage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = Constants.REGISTRATION_LINK, name = "RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getServletContext().getRequestDispatcher(Constants.REGISTRATION_JSP).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String login = req.getParameter("login");
        String password = req.getParameter("password");new InMemoryUserStorage();
        UserService userService = new UserService();
        User user = new User(name, login, password);
        if (userService.getUserDB(login) == null){
            userService.addUser(user);
            resp.sendRedirect(Constants.HOME_LINK);
        }else {
            //resp.sendRedirect(Constants.REGISTRATION_JSP);
            req.setAttribute("ErrorUserExist", "User exists");
            req.getServletContext().getRequestDispatcher(Constants.REGISTRATION_JSP).forward(req, resp);
        }
    }
}
