package com.berkay.ieltsapp.entity;
import java.util.*;
import java.time.LocalTime;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import jakarta.persistence.*;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import org.hibernate.annotations.Generated;
@Entity
public class DailyWord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ID;
    @ManyToOne
    private AppUser user;
    private LocalDate date;
    @ManyToOne
    private WordList word;
    private boolean completed;

    public DailyWord(){

    }
    public DailyWord(AppUser user,LocalDate date,WordList word,boolean compleated){
        this.completed=compleated;
        this.date=date;
        this.word=word;
        this.user=user;

    }

    public void setWord(WordList word1){this.word=word1;}
    public void setCompleted(Boolean completed1){this.completed=completed1;}
    public void setUser(AppUser user1){this.user=user1;}

    public LocalDate getDate() {return date ;}
    public boolean isCompleted() {return completed;}
    public long getID() {return ID;}
    public WordList getWord() {return word;}
    public AppUser getUser(){return user;}
}
