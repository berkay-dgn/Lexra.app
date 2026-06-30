package com.berkay.ieltsapp.controller;
import com.berkay.ieltsapp.service.UserService;
import com.berkay.ieltsapp.entity.AppUser;
import com.berkay.ieltsapp.repository.UserRepo;
import org.springframework.web.bind.annotation.*;

import java.util.*;
@RestController
@RequestMapping("/API/User")
public class UserController {
    private final UserService userService;
    public UserController(UserService userService){
        this.userService=userService;
    }
    @GetMapping
    public List<AppUser> showAllUser(){
        return userService.showList();
    }
    @GetMapping("/{ID}")
    public AppUser findCustomer(@PathVariable long ID){
        return userService.findUser(ID);
    }
    @GetMapping("/{ID}")
    public void deleteUser(@PathVariable long Id){
        userService.deleteUser(Id);
    }
    @GetMapping("/{Id},int")
    public void updateLimit(@PathVariable long Id, int limit){
        userService.updateLimit(Id,limit);
    }
    @GetMapping("/{AppUser}")
    public AppUser newUser(@PathVariable AppUser user){
         return userService.newUser(user);
    }
    @GetMapping("/{Id},String")
    public void changeName(@PathVariable long Id,String Name ){
        userService.changeUserName(Id,Name);
    }
    @GetMapping("/{Id},String")
    public void changeMail(@PathVariable long Id , String Name){
        userService.changeMail(Id,Name);
    }
}
