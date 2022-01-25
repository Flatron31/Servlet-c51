package by.tms.servlet;

import entity.User;
import history.InMemoryUserStorage;
import service.UserService;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(servletNames = "AuthorizationServlet")
public class AuthorizationFilter extends HttpFilter {
    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        if (login == null || password == null) {
            res.getWriter().println("неправльыне параметры");
        } else if (login.equals("") || password.equals("")) {
            res.getWriter().println("неправльыне параметры");
        } else {
            chain.doFilter(req, res);
        }

    }
}
