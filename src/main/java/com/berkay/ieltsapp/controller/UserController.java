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
    public AppUser findCustomer(@PathVariable Long ID){
        return userService.findUser(ID);
    }
    @DeleteMapping("/{Id}")
    public void deleteUser(@PathVariable Long Id){
        System.out.println(" the user with ID : "+Id + " has been deleted");
        userService.deleteUser(Id);
    }
    @PutMapping("/{Id}/limit/{limit}")
    public void updateLimit(@PathVariable Long Id,@PathVariable int limit){
        userService.updateLimit(Id,limit);

    }
    @PostMapping
    public AppUser newUser(@RequestBody AppUser user){
         return userService.newUser(user);
    }
    @PutMapping("/{Id}/username/{Name}")
    public void changeName(@PathVariable Long Id,@PathVariable String Name ){
        userService.changeUserName(Id,Name);
    }
    @PutMapping("/{Id}/mail/{mail}")
    public void changeMail(@PathVariable Long Id ,@ PathVariable String mail){
        userService.changeMail(Id,mail);
    }
}
