package am.basic.web.service.impl;

import am.basic.web.model.User;
import am.basic.web.repository.UserRepository;
import am.basic.web.service.Userservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
@Service
public class UserServiceimpl implements Userservice {
    public void init() {
        System.out.println("Userserviceimpl");
    }


    @Autowired
    private UserRepository userrepositoryImpl;

    @Override
    public UserRepository getUserrepositoryImpl() {
        return userrepositoryImpl;
    }

    @Override
    public User getByUsername(String username) {
        try {
            return userrepositoryImpl.getByUsername(username);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
