package com.berkay.ieltsapp.entity;
import jakarta.persistence.*;
import org.hibernate.annotations.Generated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class AppUser {
    @Id // bunların çalışabilmesi için altalarında kesin bir değişken olması gerekir
    @GeneratedValue(strategy = GenerationType.IDENTITY)//long ıd gibi
    private Long Id;
    private String mail;
    private String userName;
    private int dailyLimit;
    private String currentLevel;
    private String password;
    public AppUser(){

    }
    public AppUser(Long Id,String mail,String userName,int dailyLimit,String currentLevel,String pass){
        this.Id=Id;
        this.mail=mail;
        this.userName=userName;
        this.dailyLimit=dailyLimit;
        this.currentLevel=currentLevel;
        this.password=pass;
    }

    public int getDailyLimit() {return dailyLimit;}
    public String getMail() {return mail;}
    public Long getId() {return Id;}
    public String getUserName() {return userName;}
    public String getCurrentLevel() {return currentLevel;}
    public String  getPassword(){return password;}

    public void setCurrentLevel(String currentLevel) {this.currentLevel = currentLevel;}
    public void setDailyLimit(int dailyLimit){this.dailyLimit=dailyLimit;}
    public void setUserName(String user){this.userName=user;}
    public void setMail(String mail){this.mail=mail;}
    public void setId(Long id){this.Id=id;}
    public void setPassword(String pass){this.password=pass;}
}
