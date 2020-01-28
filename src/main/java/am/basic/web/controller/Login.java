package am.basic.web.controller;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;

import am.basic.web.model.User;
import am.basic.web.repository.UserRepository;
import am.basic.web.repository.UserRepositoryImplJdbc;

public class Login extends HttpServlet {

    private UserRepository userRepository = new UserRepositoryImplJdbc();

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();


        String username = request.getParameter("username");
        String password = request.getParameter("pass");
        User user = null;
        try {
            user = userRepository.getByUsernameAndPassword(username, password);
            if (user == null) {
                   request.setAttribute("abcd","WRONG USERNAME OR PASSWORD");
                   request.getRequestDispatcher("/index.jsp").forward(request,response);
               /// response.getWriter().println("Wrong username or password");
            } else {
                session.setAttribute("ttghg", user);
                Cookie cookie = new Cookie("ghjklf", user.getUsername());
                cookie.setMaxAge(3600*24);
                response.addCookie(cookie);
                response.sendRedirect("/secure/home.html");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
