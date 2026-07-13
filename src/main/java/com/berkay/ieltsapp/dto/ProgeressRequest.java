package com.berkay.ieltsapp.dto;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.*;
public class ProgeressRequest {
    @JsonProperty("reviewLater")
    private boolean reviewLater;
    @JsonProperty("learned")
    private boolean learned;
    @JsonProperty("userId")
    private Long userId;
    @JsonProperty("dailyWordId")
    private Long dailyWordId;
    public ProgeressRequest(){}
    /* alltaki progeress request kullanıcıdan https üzerinden alacağım bilgileri gösteriyor
    raw kodu da buradaki variablera göre yazılıyor */
    public ProgeressRequest(boolean reviewLater,boolean learned,Long userId
    ,Long dailyWordId){
        this.reviewLater=reviewLater;
        this.dailyWordId=dailyWordId;
        this.learned=learned;
        this.userId=userId;
    }
    public boolean getReviewLater(){return reviewLater;}
    public boolean getLearned(){return learned;}
    public Long getUserId(){return userId;}
    public Long getDailyWordId(){return dailyWordId;}

    public void setReviewLater(boolean reviewLater){this.reviewLater=reviewLater;}
    public void setLearned(boolean learned){this.learned=learned;}
    public void setUserId(Long userId){this.userId=userId;}
    public void setDailyWordId(Long dailyWordId){this.dailyWordId=dailyWordId;}

}
