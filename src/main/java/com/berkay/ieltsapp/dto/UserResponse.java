package com.berkay.ieltsapp.dto;
import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
public class UserResponse {
    private String mail;
    private String userName;
    private int dailyLimit;
    private String currentLevel;
    public UserResponse(){}
    public UserResponse(String mail,String userName
            ,int dailyLimit,String currentLevel){
        this.mail=mail;
        this.userName=userName;
        this.dailyLimit=dailyLimit;
        this.currentLevel=currentLevel;
    }
    public String getMail(){return mail;}
    public String getUserName(){return userName;}
    public int getDailyLimit(){return dailyLimit;}
    public String getCurrentLevel(){return currentLevel;}

    public void setMail(String mail){this.mail=mail;}
    public void setCurrentLevel(String currentLevel){this.currentLevel=currentLevel;}
    public void setUserName(String userName){this.userName=userName;}
    public void setDailyLimit(int dailyLimit){this.dailyLimit=dailyLimit;}
}
