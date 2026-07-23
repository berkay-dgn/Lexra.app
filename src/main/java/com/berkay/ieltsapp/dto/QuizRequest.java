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
    @JsonProperty("Level")
    @Pattern(regexp = "A1|A2|B1|B2|C1|C2"
            ,message="Level must be between A1,C2")
    private String level;
    public QuizRequest(int quizLimit, Long userId,String level){
        this.quizLimit = quizLimit;
        this.userId=userId;
        this.level=level;
    }
    public void setUserId(Long userId){this.userId=userId;}
    public void setQuizLimit(int quizLimit){this.quizLimit = quizLimit;}
    public void setLevel(String level){this.level=level;}

    public Long getUserId(){return userId;}
    public int getQuizLimit(){return quizLimit;}
    public String getLevel(){return level;}
}
