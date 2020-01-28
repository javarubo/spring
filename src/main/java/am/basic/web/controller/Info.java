package am.basic.web.controller;

import am.basic.web.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

public class Info extends HttpServlet {


    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            System.out.println("cookie" + " " + cookie.getName() + " " + cookie.getValue());

        }
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("ttghg");

         response.getWriter().println(" <html>"+ " <body>"+ " <h1>" +" <I>");
        response.getWriter().println(user.getName());
        response.getWriter().println(user.getSurname());
        response.getWriter().println(user.getUsername());
        response.getWriter().println(user.getAge());
        response.getWriter().println(user.getCode());
        response.getWriter().println(user.getPassword());
        response.getWriter().println(" /I" +"< /H1>"+" </body>"+"</html>");


    }
}
