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
//        String name = req.getParameter("name");
//        String login = req.getParameter("login");
//        String password = req.getParameter("password");
//        InMemoryUserStorage inMemoryUserStorage = new InMemoryUserStorage();
//        Validation validation = new Validation();
//        if (!validation.isNull(name,password,login) & !validation.isEmptyString(name, password, login)) {
//            inMemoryUserStorage.addUser(new User(name, login, password));
//            resp.getWriter().println("User created");
//        } else {
//            resp.getWriter().println("User not created");
//        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        InMemoryUserStorage inMemoryUserStorage = new InMemoryUserStorage();
        UserService userService = new UserService();

        // DB
        User user = new User(name, login, password);
        if (userService.getUserDB(login) == null){
            userService.addUser(user);
            resp.sendRedirect(Constants.HOME_LINK);
        }else {
            resp.sendRedirect(Constants.REGISTRATION_JSP);
        }
        //

        inMemoryUserStorage.addUser(new User(name, login, password));
        //resp.sendRedirect(Constants.HOME_LINK);
    }
}
