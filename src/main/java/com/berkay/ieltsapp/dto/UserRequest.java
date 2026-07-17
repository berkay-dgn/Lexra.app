package com.berkay.ieltsapp.dto;
import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
public class UserRequest {
    @JsonProperty("mail")
    @NotBlank(message="You have to enter your email ")
    @Email(message="Please enter a valid mail ")
    private String mail;
    @JsonProperty("userName")
    @NotBlank(message="User name not be empty")
    @Pattern(regexp = "^[a-zA-ZÇçĞğİıÖöŞşÜü\\s]+$"
            ,message="User can contains only letter")
    private String userName;
    @JsonProperty("dailyLimit")
    @Positive
    @Min(2)
    @Max(10)
    private int dailyLimit;
    @JsonProperty("currentLevel")
    @Pattern(regexp = " A1|A2|B1|B2|C1|C2",
    message="The level must be A1,A2,B1,B2,C1 or C2 " +
            "for that reason please enter valid level")
    @NotBlank(message="Level can not be empty ")
    @Size(min=2,max=2)
    private String currentLevel;
    @JsonProperty("password")
    @NotBlank(message="Password can not be empty ")
    @Pattern(
            regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&._#-])[A-Za-z\\d@$!%*?&._#-]{8,}$",
            message = "Password must be at least 8 char and it consists of Upper case,Lower case" +
                    ",Special char and Number"
    )
    private String password;
    @Positive
    private Long userId;
    public UserRequest(){}
    public UserRequest(String mail,String userName,int dailyLimit
            ,String currentLevel,String password){
        this.mail=mail;
        this.userName=userName;
        this.dailyLimit=dailyLimit;
        this.currentLevel=currentLevel;
        this.password=password;
    }

    public int getDailyLimit() {
        return dailyLimit;
    }
    public String getMail(){
        return mail;
    }
    public String getUserName(){
        return userName;
    }
    public String getCurrentLevel(){
        return currentLevel;
    }
    public String getPassword(){return password;}
    public Long getUserId(){return userId;}

    public void setDailyLimit(int dailyLimit){this.dailyLimit=dailyLimit;}
    public void setCurrentLevel(String currentLevel){this.currentLevel=currentLevel;}
    public void setUserName(String userName){this.userName=userName;}
    public void setMail(String mail){this.mail=mail;}
    public void setPassword(String password){this.password=password;}
    public void setUserId(Long userId){this.userId=userId;}
}
