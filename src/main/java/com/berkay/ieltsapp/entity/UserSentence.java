package com.berkay.ieltsapp.entity;
import java.time.LocalDate;
import java.util.*;
import com.berkay.ieltsapp.entity.DailyWord;
import jakarta.persistence.*;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import org.hibernate.annotations.Generated;
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
    private boolean isCorrect;
    private LocalDate createdAt;
    private String sentence;
    public UserSentence(){

    }
    public UserSentence(AppUser user,DailyWord dailyWord,String sentence
            ,boolean isCorrect,LocalDate createdAt){
        this.user=user;
        this.dailyWord=dailyWord;
        this.isCorrect=isCorrect;
        this.createdAt=createdAt;
        this.sentence=sentence;
    }
    public void setUser(AppUser user){this.user=user;}
    public void setId(Long Id){this.Id=Id;}
    public void setDailyWord(DailyWord dailyWord){this.dailyWord=dailyWord;}
    public void setCorrect(boolean isCorrect){this.isCorrect=isCorrect;}
    public void setCreatedAt(LocalDate createdAt){this.createdAt=createdAt;}
    public void setSentence(String sentence){this.sentence=sentence;}

    public AppUser getUser(AppUser user){return user; }
    public Long getId(Long Id){return Id;}
    public DailyWord getDailyWord(DailyWord dailyWord){return dailyWord;}
    public boolean getCorrect(Boolean isCorrect){return isCorrect;}
    public LocalDate getCreatedAt(LocalDate createdAt){return createdAt;}
    public String getSentence(String sentence){return sentence;}
}
