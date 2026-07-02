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
    private Long Id;
    private String word;
    private String exampleSentence;
    private String meaning;
    private String level;
    public WordList(){

    }
    public WordList(Long Id,String meaning,String level,String exampleSentence,String word){
        this.Id=Id;
        this.meaning=meaning;
        this.level=level;
        this.exampleSentence=exampleSentence;
        this.word=word;
    }
    public String getWord(){return word; }
    public Long getId() {return Id;}
    public String getExampleSentence() {return exampleSentence;}
    public String meaning() {return meaning;}
    public String Level() {return level;}

    public void setExampleSentence(String exampleSentence){this.exampleSentence=exampleSentence;}
    public void setMeaning(String mean){this.meaning=mean;}
    public void setLevel(String diff){this.level=diff;}
    public void setWord(String word){this.word=word;}
    public void setId(Long Id){this.Id=Id;}




}
