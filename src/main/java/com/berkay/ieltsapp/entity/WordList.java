package com.berkay.ieltsapp.entity;
import jakarta.persistence.*;
import org.hibernate.annotations.Generated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class WordList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;

    private String exampleSentence;
    private String meaning;
    private String level;
    public WordList(){

    }
    public WordList(Long id,String meaning,String Level,String example){
        this.Id=id;
        this.meaning=meaning;
        this.level=level;
        this.exampleSentence=example;
    }

    public long getId() {return Id;}
    public String getExampleSentence() {return exampleSentence;}
    public String meaning() {return meaning;}
    public String Level() {return level;}

    public void setExampleSentence(String ex){this.exampleSentence=ex;}
    public void setMeaning(String mean){this.meaning=mean;}
    public void setLevel(String diff){this.level=diff;}





}
