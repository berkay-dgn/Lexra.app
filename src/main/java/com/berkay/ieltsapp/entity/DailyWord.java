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
    private Long ID;
    @ManyToOne
    private AppUser user;
    private LocalDate date;
    @ManyToOne
    private WordList word;
    private boolean completed;

    public DailyWord(){

    }
    public DailyWord(AppUser user,LocalDate date,WordList word,boolean completed){
        this.completed=completed;
        this.date=date;
        this.word=word;
        this.user=user;

    }

    public void setDate(LocalDate date) {this.date = date;}
    public void setID(Long ID){this.ID=ID;}
    public void setWord(WordList word){this.word=word;}
    public void setCompleted(Boolean completed){this.completed=completed;}
    public void setUser(AppUser user){this.user=user;}

    public LocalDate getDate() {return date ;}
    public boolean isCompleted() {return completed;}
    public Long getID() {return ID;}
    public WordList getWord() {return word;}
    public AppUser getUser(){return user;}
}
