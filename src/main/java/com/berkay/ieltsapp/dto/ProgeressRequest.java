package com.berkay.ieltsapp.dto;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.*;
public class ProgeressRequest {
    @JsonProperty("reviewLater")
    private Boolean reviewLater;// Boolean nın boolean ile farkı Boolean null kabul ediyor
    @JsonProperty("learned")
    private Boolean learned;
    @JsonProperty("userId")
    private Long userId;
    @JsonProperty("dailyWordId")
    private Long dailyWordId;
    /* alltaki progeress request kullanıcıdan https üzerinden alacağım bilgileri gösteriyor
    raw kodu da buradaki variablera göre yazılıyor */
    public ProgeressRequest(Long userId,Long dailyWordId,
                            Boolean learned ,Boolean reviewLater){
        this.dailyWordId=dailyWordId;
        this.userId=userId;
        this.learned=learned;
        this.reviewLater=reviewLater;
    }
    public Boolean getReviewLater(){return reviewLater;}
    public Boolean getLearned(){return learned;}
    public Long getUserId(){return userId;}
    public Long getDailyWordId(){return dailyWordId;}

    public void setReviewLater(Boolean reviewLater){this.reviewLater=reviewLater;}
    public void setLearned(Boolean learned){this.learned=learned;}
    public void setUserId(Long userId){this.userId=userId;}
    public void setDailyWordId(Long dailyWordId){this.dailyWordId=dailyWordId;}

}
