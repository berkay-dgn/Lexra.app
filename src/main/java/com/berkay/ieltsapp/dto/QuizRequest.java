package com.berkay.ieltsapp.dto;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;

public class QuizRequest {
    @JsonProperty("quizLimit")
    @Positive
    @Min(1)
    @Max(10)
    private int quizLimit;
    @JsonProperty("userId")
    @Positive
    private Long userId;
    public QuizRequest(int quizLimit, Long userId){
        this.quizLimit = quizLimit;
        this.userId=userId;
    }
    public void setUserId(Long userId){this.userId=userId;}
    public void setQuizLimit(int quizLimit){this.quizLimit = quizLimit;}

    public Long getUserId(){return userId;}
    public int getQuizLimit(){return quizLimit;}
}
