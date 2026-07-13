package com.berkay.ieltsapp.dto;
import java.time.LocalDate;
import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
public class ProgeressResponse {
    @JsonProperty("correctCount")
    private Long correctCount;
    @JsonProperty("wrongCount")
    private Long wrongCount;
    @JsonProperty("lastReviewAt")
    private LocalDate lastReviewAt;
    @JsonProperty("nextReviewAt")
    private LocalDate nextReviewAt;
    @JsonProperty("sentence")
    private String sentence;
    public ProgeressResponse(){}
    public ProgeressResponse(Long correctCount,Long wrongCount,LocalDate lastReviewAt
            ,LocalDate nextReviewAt,String sentence){
        this.correctCount=correctCount;
        this.wrongCount=wrongCount;
        this.lastReviewAt=lastReviewAt;
        this.nextReviewAt=nextReviewAt;
        this.sentence=sentence;
    }
    public Long getCorrectCount(){return correctCount;}
    public Long getWrongCount(){return wrongCount;}
    public LocalDate getLastReviewAt(){return lastReviewAt;}
    public LocalDate getNextReviewAt(){return nextReviewAt;}
    public String getSentence(){return sentence;}

    public void setSentence(String sentence){this.sentence=sentence;}
    public void setWrongCount(Long wrongCount){this.wrongCount=wrongCount;}
    public void setNextReviewAt(LocalDate nextReviewAt){this.nextReviewAt=nextReviewAt;}
    public void setLastReviewAt(LocalDate lastReviewAt){this.lastReviewAt=lastReviewAt;}
    public void setCorrectCount(Long correctCount){this.correctCount=correctCount;}

}
