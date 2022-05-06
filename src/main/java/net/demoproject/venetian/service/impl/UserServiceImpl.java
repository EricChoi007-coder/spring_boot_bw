package net.demoproject.venetian.service.impl;

import com.sun.org.apache.bcel.internal.generic.NEW;
import net.demoproject.venetian.service.UserService;
import net.demoproject.venetian.domain.User;
import net.demoproject.venetian.mapper.UserMapper;
import net.demoproject.venetian.utils.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    private static Map<String,User> sessionMap = new HashMap<>();

    @Autowired
    private UserMapper userMapper;

    @Override
    public String login(String username, String pwd) {

        User user = userMapper.login(username,pwd);

        if(user==null){
            return null;
        }else {

            //String token = UUID.randomUUID().toString();
            String token = JWTUtils.geneJsonWebToken(user);
            System.out.println(token);
            sessionMap.put(token,user);
            return token;
        }

    }

    @Override
    public List<User> listUser() {
        return userMapper.listUser();
    }

    @Override
    public User findByUserId(String name) {

        User user = userMapper.findByUserId(name);
        return user;
    }
}
