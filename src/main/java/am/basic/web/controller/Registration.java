package am.basic.web.controller;

import am.basic.web.model.User;
import am.basic.web.repository.UserRepository;
import am.basic.web.repository.UserRepositoryImplJdbc;
import am.basic.web.repository.UserrepositoryImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;


public class Registration extends HttpServlet {
    UserRepository userRepository = new UserrepositoryImpl();


    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();


        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String username = request.getParameter("username");
        String age = request.getParameter("age");
        String code = request.getParameter("code");
        String password = request.getParameter("password");


        User user = new User();

        user.setName(name);
        user.setSurname(surname);
        user.setUsername(username);
        user.setAge(age);
        user.setCode(code);
        user.setPassword(password);
        if (isValid(user)) {

            try {
                userRepository.add(user);
                session.setAttribute("ttghg", user);

            } catch (SQLException e) {
                e.printStackTrace();
            }
            response.sendRedirect("/secure/sad.html");

        } else {
           // response.getWriter().println("YOU HAVE MISTAKE");
            request.setAttribute("abcd","YOu have MIstake");
            request.getRequestDispatcher("/registr.jsp").forward(request, response);
        }


    }


    public boolean isValid(User user) {
        return !(user.getName() == null || user.getName().isEmpty()
                || user.getSurname() == null || user.getSurname().isEmpty()
                || user.getUsername() == null || user.getUsername().isEmpty()
                || user.getAge() == null || user.getAge().isEmpty()
                || user.getCode() == null || user.getCode().isEmpty()
                || user.getPassword() == null || user.getPassword().isEmpty());
    }


}

