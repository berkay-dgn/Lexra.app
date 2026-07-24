package com.berkay.ieltsapp.dto;
import java.util.*;
public class WordListResponse {
    private String word;
    private String exampleSentence;
    private String meaning;
    private String level;
    public WordListResponse(){}
    public WordListResponse(String word,String exampleSentence
            ,String meaning,String level){
        this.word=word;
        this.exampleSentence=exampleSentence;
        this.meaning=meaning;
        this.level=level;
    }
    public String getWord(){return word;}
    public String getExampleSentence(){return exampleSentence;}
    public String getMeaning(){return meaning;}
    public String getLevel(){return level;}

    public void setWord(String word){this.word=word;}
    public void setExampleSentence(String exampleSentence){this.exampleSentence=exampleSentence;}
    public void setMeaning(String meaning){this.meaning=meaning;}
    public void setLevel(String level){this.level=level;}
}
