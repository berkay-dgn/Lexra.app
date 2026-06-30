package com.berkay.ieltsapp.entity;
import java.util.*;
import java.time.LocalTime;
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
    private Date date;
    @ManyToOne
    private WordList word;
    private boolean compleated;
    public DailyWord(){

    }
    public DailyWord(long ID ,AppUser user,Date date,WordList word,boolean compleated){
        this.compleated=compleated;
        this.ID=ID;
        this.compleated=compleated;
        this.date=date;
        this.word=word;

    }
}
