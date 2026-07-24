package com.berkay.ieltsapp.dto;
import java.util.*;

import jakarta.persistence.Column;
import jakarta.validation.constraints.*;
import com.fasterxml.jackson.annotation.JsonProperty;
public class WordListRequest {
    @JsonProperty("word")
    @NotBlank(message="Word can not be empty")
    @Size(min=2,max=45,message="Word's length must be between 2 and 45")
    @Column(unique = true)
    private String word;
    @JsonProperty("exampleSentence")
    @NotBlank(message="ExampleSentence not be empty ")
    @Size(max=100,message="Example sentence must be max 100 ")
    private String exampleSentence;
    @JsonProperty("meaning")
    @NotBlank(message="Meaning not be empty")
    private String meaning;
    public WordListRequest(){}
    public WordListRequest(String word,String exampleSentence
            ,String meaning){
        this.word=word;
        this.exampleSentence=exampleSentence;
        this.meaning=meaning;
    }
    public String getWord(){return word;}
    public String getExampleSentence(){return exampleSentence;}
    public String getMeaning(){return meaning;}

    public void setWord(String word){this.word=word;}
    public void setExampleSentence(String exampleSentence){this.exampleSentence=exampleSentence;}
    public void setMeaning(String meaning){this.meaning=meaning;}

}
