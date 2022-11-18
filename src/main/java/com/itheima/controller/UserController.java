package com.itheima.controller;

import com.itheima.domain.User;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/{username}/{password}")
    public Result login(@PathVariable String username, @PathVariable String password, HttpSession session){
      //  System.out.println(username+password);
        boolean flag = userService.login(username, password);
        if(flag){
        session.setAttribute("username", username);
        }
      //  System.out.println(flag);
        return new Result (Code.GET_OK,flag);
    }
//    @GetMapping("/{username}")
//    public Result show(@PathVariable String username){
//        System.out.println("show");
//        User user = userService.show(username);
//        System.out.println(user.getPhoneNumber());
//        String msg = user != null ? "" : "数据查询失败，请重试！";
//        return new Result (Code.GET_OK,user,msg);
//    }
    @PostMapping
    public Result register(@RequestBody User user){
     //   System.out.println("Register");
     //   System.out.println(user.getUsername()+user.getPassword()+user.getPhoneNumber());
        boolean flag = userService.register(user.getUsername(), user.getPassword(), user.getPhoneNumber());
        System.out.println(flag);
        return new Result (flag ? Code.SAVE_OK:Code.SAVE_ERR,flag);
    }

}
