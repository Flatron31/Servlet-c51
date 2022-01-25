package by.tms.servlet;

import entity.User;
import history.InMemoryUserStorage;
import validation.Validation;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/registration")
public class RegistrationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        InMemoryUserStorage inMemoryUserStorage = new InMemoryUserStorage();
        Validation validation = new Validation();

        if (name != null & login != null & password != null & !validation.isEmptyString(name, password, login)) {
            inMemoryUserStorage.addUser(new User(name, login, password));
            resp.getWriter().println("User created");
        } else {
            resp.getWriter().println("User not created");
        }
    }
}
