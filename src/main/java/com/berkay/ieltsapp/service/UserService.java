package com.berkay.ieltsapp.service;
import com.berkay.ieltsapp.entity.AppUser;
import com.berkay.ieltsapp.repository.UserRepo;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service

public class UserService {
    private final UserRepo userRepo;
    public  UserService(UserRepo userRepo){
        this.userRepo=userRepo;
    }
    public List<AppUser> showList(){
        return userRepo.findAll();
    }
    public AppUser findUser(long ID){
        return userRepo.findById(ID).orElseThrow(()->
                new RuntimeException(" the user with "+ID +" does not exist"));
    }
    public void deleteUser(long ID){
        AppUser user=findUser(ID);
        userRepo.delete(user);
        System.out.println(user + " has been deleted !");
    }
    public AppUser newUser(AppUser user){
        return userRepo.save(user); // save in içinde entity olmalı
    }
    public void updateLimit(Long ID,int limit){
        AppUser user=findUser(ID);
        int oldLimit= user.getDailyLimit();
        user.setDailyLimit(limit);
        userRepo.save(user);
        System.out.println(" your last limit was :  " +oldLimit+" your limit has been changed "+
                " your new limit is : " + limit);

    }
    public void changeUserName(Long ID,String Name){
        AppUser user=findUser(ID);
        user.setUserName(Name);
        userRepo.save(user);
        System.out.println(" your username has been changed successfully");
    }
    public void changeMail(Long Id , String mail){
        AppUser user= findUser(Id);
        user.setMail(mail);
        userRepo.save(user);
        System.out.println(" your username has been changed successfully");
    }
}
