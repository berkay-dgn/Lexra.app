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
    private long Id;
    private String Mail;
    private String userName;
    private int dailyLimit;
    private String currentLevel;
    private String password;
    public AppUser(){

    }
    public AppUser(long Id,String mail,String userName,int dailyLimit,String currentLevel,String pass){
        this.Id=Id;
        this.Mail=mail;
        this.userName=userName;
        this.dailyLimit=dailyLimit;
        this.currentLevel=currentLevel;
        this.password=pass;
    }

    public int getDailyLimit() {return dailyLimit;}
    public String getMail() {return Mail;}
    public long Id() {return Id;}
    public String userName() {return userName;}
    public String currentLevel() {return currentLevel;}
    public String  getPassword(){return password;}

    public void setCurrentLevel(String currentLevel) {this.currentLevel = currentLevel;}
    public void setDailyLimit(int dailyLimit){this.dailyLimit=dailyLimit;}
    public void setUserName(String user){this.userName=user;}
    public void setMail(String mail){this.Mail=mail;}

}
