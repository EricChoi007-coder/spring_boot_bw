package net.demoproject.venetian.controller;

import net.demoproject.venetian.domain.User;
import net.demoproject.venetian.service.UserService;
import net.demoproject.venetian.utils.JWTUtils;
import io.jsonwebtoken.Claims;
import net.demoproject.venetian.utils.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/pub/user")
@PropertySource({"classpath:test.properties"})
public class UserController {


//    @PostMapping("login")
//    public JsonData login(String pwd, String username){
//
//        System.out.println("username=" + username + " pwd="+pwd);
//
//        return JsonData.buildSuccess("");
//    }

    @Value("test.best")
 private String testData;

    @Autowired
    public UserService userService;


    /**
     * Login
     * @param user
     * @return
     */
    @PostMapping("login")
    //@RequestBody is a must for JSON Format
    public JsonData login(@RequestBody User user){

        System.out.println("user=" + user.toString());

        String token = userService.login(user.getUsername(), user.getPwd());

        return token !=null ? JsonData.buildSuccess(token) : JsonData.buildError("Password_Account_Error");
    }


    /**
     * List all users
     * @return
     */
    @GetMapping("list")
    public JsonData listUser(){

        return  JsonData.buildSuccess(userService.listUser());

    }

    @GetMapping("test2")
    public JsonData test2(){
        return  JsonData.buildSuccess(testData);
    }

    @GetMapping("find_by_token")
    public JsonData findUserInfoByToken(String token){

        Claims claims = JWTUtils.checkJWT(token);
        String userName = (String) claims.get("name");
        User user =  userService.findByUserId(userName);

        return JsonData.buildSuccess(user);

    }









}
