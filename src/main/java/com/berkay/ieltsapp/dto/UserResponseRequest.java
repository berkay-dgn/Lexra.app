package com.berkay.ieltsapp.dto;
import com.berkay.ieltsapp.entity.*;

import java.time.LocalDate;
import java.time.LocalTime.*;
import java.time.LocalDateTime.*;
import com.fasterxml.jackson.annotation.JsonProperty;
public class UserResponseRequest {
    @JsonProperty("sentence")
    private String sentence;
    @JsonProperty("correct")
    private boolean correct;
    @JsonProperty("date")
    private LocalDate createdAt;
    @JsonProperty("dailyWord")
    private DailyWord dailyWord;
    // bu response request class ı ise bizim json na gönderdiğimizin kısmı
    public UserResponseRequest(){}
    public UserResponseRequest(String sentence,boolean correct
            ,LocalDate createdAt,DailyWord dailyWord){
        this.sentence=sentence;
        this.correct=correct;
        this.createdAt=createdAt;
        this.dailyWord=dailyWord;
    }
    public String getSentence(){return sentence;}
    public boolean getCorrect(){return correct;}
    public LocalDate getCreatedAt(){return createdAt;}
    public DailyWord getDailyWord(){return dailyWord;}

    public void setSentence(String sentence){this.sentence=sentence;}
    public void setCorrect(boolean isCorrect){this.correct=correct;}
    public void setDailyWord(DailyWord dailyWord){this.dailyWord=dailyWord;}
    public void setCreatedAt(LocalDate createdAt){this.createdAt=createdAt;}
}
