package net.demoproject.venetian.service;

import net.demoproject.venetian.domain.User;

import java.util.List;

public interface UserService {

    String login(String username, String pwd);


    List<User> listUser();

    User findByUserId(String name);

}
