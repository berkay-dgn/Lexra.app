package com.berkay.ieltsapp.entity;
import java.time.LocalDate;
import java.util.*;
import com.berkay.ieltsapp.entity.DailyWord;
import jakarta.persistence.*;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import java.time.LocalTime.*;
import java.time.LocalDateTime.*;
import java.time.format.DateTimeFormatter;
import org.hibernate.annotations.Generated;
@Entity
public class UserSentence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @ManyToOne
    private AppUser user;
    @ManyToOne // kullanıcı yanlış cümle yazarsa düzeltme imkanın verebilmek için ManyToOne kullandım
    private DailyWord dailyWord;
    private boolean correct;
    private LocalDate createdAt;
    @Column(length=1000)
    private String sentence;
    @Column(length = 1000)
    private String feedback;
    @Column(length=1000)
    private String correctedSentence;
    public UserSentence(){

    }
    public UserSentence(AppUser user,DailyWord dailyWord,String sentence
            ,boolean correct,LocalDate createdAt ){
        this.user=user;
        this.dailyWord=dailyWord;
        this.correct=correct;
        this.createdAt=createdAt;
        this.sentence=sentence;
    }
    public void setUser(AppUser user){this.user=user;}
    public void setId(Long Id){this.Id=Id;}
    public void setDailyWord(DailyWord dailyWord){this.dailyWord=dailyWord;}
    public void setCorrect(boolean isCorrect){this.correct=correct;}
    public void setCreatedAt(LocalDate createdAt){this.createdAt=createdAt;}
    public void setSentence(String sentence){this.sentence=sentence;}
    public void setFeedback(String feedback){this.feedback=feedback;}
    public void setCorrectedSentence(String correctedSentence){
        this.correctedSentence=correctedSentence;
    }

    public AppUser getUser(){return user; }
    public Long getId(){return Id;}
    public DailyWord getDailyWord(){return dailyWord;}
    public boolean getCorrect(){return correct;}
    public LocalDate getCreatedAt(){return createdAt;}
    public String getSentence(){return sentence;}
    public String getFeedback(){return feedback;}
    public String getCorrectedSentence(){return correctedSentence;}
}
