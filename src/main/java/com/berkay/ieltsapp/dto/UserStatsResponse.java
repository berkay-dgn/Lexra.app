package com.berkay.ieltsapp.dto;
import com.fasterxml.jackson.annotation.JsonProperty;
public class UserStatsResponse {
    @JsonProperty("totalAssignedWord")
    private Long totalAssignedWord;//
    @JsonProperty("totalCorrect")
    private Long totalCorrect;//
    @JsonProperty("completedWord")
    private Long completedWord;//
    @JsonProperty("remainingWord")
    private Long remainingWord;//
    @JsonProperty("accuracyRate")
    private Long accuracyRate;//
    @JsonProperty("currentStreak")
    private Long currentStreak;
    @JsonProperty("todayCompletedWord")
    private Long todayCompletedWord;//
    public UserStatsResponse(Long totalAssignedWord,Long totalCorrect
            ,Long completedWord,Long remainingWord,Long accuracyRate
            ,Long currentStreak,Long todayCompletedWord){
        this.totalAssignedWord=totalAssignedWord;
        this.accuracyRate=accuracyRate;
        this.totalCorrect=totalCorrect;
        this.completedWord=completedWord;
        this.remainingWord=remainingWord;
        this.currentStreak=currentStreak;
        this.todayCompletedWord=todayCompletedWord;
    }
    public Long getTotalAssignedWord(){return totalAssignedWord;}
    public Long getTotalCorrect(){return totalCorrect;}
    public Long getCompletedWord(){return completedWord;}
    public Long getRemainingWord(){return remainingWord;}
    public Long getAccuracyRate(){return accuracyRate;}
    public Long getCurrentStreak(){return currentStreak;}
    public Long getTodayCompletedWord(){return todayCompletedWord;}

    public void setTotalAssignedWord(Long totalAssignedWord){
        this.totalAssignedWord=totalAssignedWord;
    }
    public void setTotalCorrect(Long totalCorrect){
        this.totalCorrect=totalCorrect;
    }
    public void setCompletedWord(Long completedWord){
        this.completedWord=completedWord;
    }
    public void setRemainingWord(Long remainingWord){
        this.remainingWord=remainingWord;
    }
    public void setAccuracyRate(Long accuracyRate){
        this.accuracyRate=accuracyRate;
    }
    public void setCurrentStreak(Long currentStreak){
        this.currentStreak=currentStreak;
    }
    public void setTodayCompletedWord(Long todayCompletedWord){
        this.todayCompletedWord=todayCompletedWord;
    }

}
