package Filter;

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
        if (req.getMethod().equalsIgnoreCase("POST")) {
            String login = req.getParameter("login");
            String password = req.getParameter("password");
//            HttpSession session = req.getSession();
            if (login == null || password == null) {
                req.setAttribute("error", "invalid parameters");
                req.getServletContext().getRequestDispatcher("/pages/authorization.jsp").forward(req, res);
 //               session.setAttribute("error", "invalid parameters");
            }
            else if (login.equals("") || password.equals("")) {
                req.setAttribute("error", "invalid parameters");
//                session.setAttribute("error", "invalid parameters");
                req.getServletContext().getRequestDispatcher("/pages/authorization.jsp").forward(req, res);
            } else {
                chain.doFilter(req, res);
            }
        } else {
            chain.doFilter(req, res);
        }

    }
}
