package com.berkay.ieltsapp.entity;
import jakarta.persistence.*;
import jakarta.persistence.Id;
import jakarta.persistence.GenerationType;
import jakarta.persistence.GeneratedValue;
import org.hibernate.annotations.Generated;
import com.berkay.ieltsapp.entity.*;


import java.time.LocalDate;
import java.time.LocalDateTime.*;
@Entity
public class UserWordProgeress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long progressId;
    @ManyToOne
    private AppUser user;
    @ManyToOne
    private WordList word;
    private Long correctCount;
    private Long wrongCount;
    private LocalDate lastReviewAt;
    private LocalDate nextReviewAt;
    private boolean learned;
    private boolean reviewLater;
    public UserWordProgeress(){

    }
    public UserWordProgeress(Long progressId,AppUser user,WordList word,boolean learned
                             ,Long correctCount,LocalDate lastReviewAt,LocalDate nextReviewAt
            ,boolean reviewLater){
        this.progressId=progressId;
        this.user=user;
        this.word=word;
        this.learned=learned;
        this.reviewLater=reviewLater;
        this.correctCount=correctCount;
        this.lastReviewAt=lastReviewAt;
        this.nextReviewAt=nextReviewAt;
    }

    public Long getProgressId(){return progressId;}
    public AppUser getUser(){return user;}
    public WordList getWord(){return word;}
    public boolean getLearned(){return learned;}
    public Long getCorrectCount(){return correctCount;}
    public LocalDate getLastReviewAt(){return lastReviewAt;}
    public LocalDate getNextReviewAt(){return nextReviewAt;}
    public boolean getReviewLater(){return reviewLater;}


    public void setProgressId(Long progressId){this.progressId=progressId;}
    public void setUser(AppUser user){this.user=user;}
    public void setWord(WordList word){this.word=word;}
    public void setLearned(boolean learned){this.learned=learned;}
    public void setCorrectCount(Long correctCount){this.correctCount=correctCount;}
    public void setWrongCount(Long wrongCount){this.wrongCount=wrongCount;}
    public void setReviewLater(boolean reviewLater){this.reviewLater=reviewLater;}
    public void setLastReviewAt(LocalDate lastReviewAt) {this.lastReviewAt=lastReviewAt;}
    public void setNextReviewAt(LocalDate nextReviewAt){this.nextReviewAt=nextReviewAt;}
}
