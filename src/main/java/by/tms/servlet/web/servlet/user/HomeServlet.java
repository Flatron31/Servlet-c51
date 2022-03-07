package by.tms.servlet.web.servlet.user;

import by.tms.servlet.web.Constants;
//import org.apache.log4j.PropertyConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(Constants.HOME_LINK)
public class HomeServlet extends HttpServlet {
    // private Logger log = Logger.getLogger(this.getClass().getName());
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //PropertyConfigurator.configure("c:\\Users\\admin\\IdeaProjects\\servlet-c51\\src\\main\\resources\\log4j.properties");
        logger.info("Hello INFO");
        logger.warn("Hello warn");
        logger.error("Hello err");
        req.getServletContext().getRequestDispatcher(Constants.INDEX_JSP).forward(req,resp);
    }
}


//        logger.info("Hello INFO"); // высший уровень
//        logger.warn("Hello warn"); // обращение к несуществующим путям
//        logger.error("Hello err"); // ошибки эксепшенов
//        logger.debug("Hello deb"); // состояния нашего сервера
//        logger.trace("Hello trace");  // состояние алгоритма
//        log.log(Level.INFO,"Hello");