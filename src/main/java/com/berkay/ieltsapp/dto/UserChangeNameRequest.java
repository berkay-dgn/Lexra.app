package com.berkay.ieltsapp.dto;
import com.berkay.ieltsapp.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
public class UserChangeNameRequest {
    @Positive
    private Long userId;
    @NotBlank(message="Mail can not be empty")
    @Pattern(regexp = "^[a-zA-ZÇçĞğİıÖöŞşÜü\\s]+$"
            ,message="User name only consist of letter")
    private String userName;
    public UserChangeNameRequest(Long userId,String userName){
        this.userId=userId;
        this.userName=userName;
    }
    public void setUserId(Long userId){this.userId=userId;}
    public void setUserName(String userName){this.userName=userName;}
    public Long getUserId(){return userId;}
    public String getUserName(){return userName;}

}
