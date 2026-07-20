package com.berkay.ieltsapp.dto;
import com.fasterxml.jackson.annotation.JsonProperty;

public class AiSentenceResponse {
    @JsonProperty("correct")
    private Boolean correct;
    @JsonProperty("feedback")
    private String feedback;
    @JsonProperty("correctedSentence")
    private String correctedSentence;
    @JsonProperty("exampleSentence")
    private String exampleSentence;
    public AiSentenceResponse(){}
    public AiSentenceResponse(Boolean correct, String feedback
            , String correctedSentence,String exampleSentence){
        this.correct=correct;
        this.feedback=feedback;
        this.correctedSentence=correctedSentence;
        this.exampleSentence=exampleSentence;
    }
    public String getExampleSentence(){return exampleSentence;}
    public Boolean getCorrect(){return correct;}
    public String getFeedback(){return feedback;}
    public String getCorrectedSentence(){return correctedSentence;}

    public void setCorrect(Boolean correct){this.correct=correct;}
    public void setCorrectedSentence(String correctedSentence){
        this.correctedSentence=correctedSentence;
    }
    public void setFeedback(String feedback){this.feedback=feedback;}
    public void setExampleSentence(String exampleSentence){
        this.exampleSentence=exampleSentence;
    }

}
