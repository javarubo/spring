package am.basic.web.service;

import am.basic.web.model.User;
import am.basic.web.repository.UserRepository;

public interface Userservice {
    UserRepository getUserrepositoryImpl();

    User getByUsername(String username);
}
