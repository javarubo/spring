package am.basic.web.controller;

import am.basic.web.model.User;
import am.basic.web.repository.UserRepository;
import am.basic.web.repository.UserRepositoryImplJdbc;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;

public class Start extends HttpServlet {


    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if (request.getCookies() == null) {
            response.sendRedirect("/index.jsp");
            return;
        }
        HttpSession session=request.getSession();


        String username = null;
        for (Cookie cookie : request.getCookies()) {
            if (cookie.getName().equals("ghjklf")) {
                username = cookie.getValue();
            }
        }


        if (username == null) {
            response.sendRedirect("/index.jsp");
        } else {
            UserRepository userRepository = new UserRepositoryImplJdbc();

            try {
                User user = userRepository.getByUsername(username);
                request.getSession().setAttribute("ttghg", user);
                response.sendRedirect("/secure/home.html");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}


