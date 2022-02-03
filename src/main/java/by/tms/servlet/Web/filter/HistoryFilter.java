package by.tms.servlet.Web.filter;

import by.tms.servlet.Web.Constants;
import entity.User;
import service.UserService;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(servletNames = "HistoryServlet")
public class HistoryFilter extends HttpFilter {
    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpSession session = req.getSession();
        String login = (String) session.getAttribute("login");
        UserService userService = new UserService();
        User user = userService.getUser(login);

        if (req.getMethod().equalsIgnoreCase("GET")) {
            if (user.getAuthorizationSessionID() == null | !user.getAuthorizationSessionID().equals(session.getId())) {
                req.setAttribute("messageUserError", "User is not authorized");
                req.getServletContext().getRequestDispatcher(Constants.INFOERROR_JSP).forward(req, res);
            }
        }
        chain.doFilter(req, res);
    }
}
