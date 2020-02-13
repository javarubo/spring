package am.basic.web.controller;

import am.basic.web.model.User;
import am.basic.web.repository.UserRepository;
import am.basic.web.service.Userservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.sql.SQLException;

@Controller
public class Testcontroller {


    @Autowired
    private UserRepository userRepository;


    @RequestMapping(method = RequestMethod.GET, path = "/")
    public String test() {
        return "index";
    }


    @RequestMapping(method = RequestMethod.POST, path = "/login")
    public ModelAndView login(@RequestParam String username, @RequestParam("pass") String password,
                              HttpSession session, @CookieValue(name = "username",value = "surname",required = false) String str)
                                throws SQLException {


        User user = userRepository.getByUsernameAndPassword(username, password);
        if (user != null) {
            session.setAttribute("ttghg", user);
            return new ModelAndView("profile");
        }

        return new ModelAndView("index", "abcd", "wrong username or password");

    }
    @RequestMapping(method = RequestMethod.POST, path = "/registration")

    public ModelAndView addUser(@RequestParam String name,
                                @RequestParam String surname,
                                @RequestParam String username,
                                @RequestParam String age,
                                @RequestParam String code,
                                @RequestParam String password, HttpSession session) throws SQLException {
        User user = new User();

        user.setName(name);
        user.setSurname(surname);
        user.setUsername(username);
        user.setAge(age);
        user.setCode(code);
        user.setPassword(password);
        userRepository.add(user);
        session.setAttribute("ttghg", user);

        return new ModelAndView("registr", "abcd", "THe user added");


    }


}
