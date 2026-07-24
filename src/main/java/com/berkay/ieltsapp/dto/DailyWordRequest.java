package com.berkay.ieltsapp.dto;
import java.util.*;
import jakarta.validation.constraints.*;
import com.fasterxml.jackson.annotation.JsonProperty;
public class DailyWordRequest {
    @JsonProperty("userId")
    @NotNull(message="userId not be empty ")
    @Positive
    private Long userId;
    @JsonProperty("wordId")
    @NotNull(message="wordId not be empty")
    @Positive
    private Long wordId;
    public DailyWordRequest(){}
    public DailyWordRequest(Long userId,Long wordId){
        this.userId=userId;
        this.wordId=wordId;
    }
    public Long getUserId(){return userId;}
    public Long getDailyWordId(){return wordId;}

    public void setUserId(Long userId){this.userId=userId;}
    public void setDailyWordId(Long wordId){this.wordId=wordId;}
}
