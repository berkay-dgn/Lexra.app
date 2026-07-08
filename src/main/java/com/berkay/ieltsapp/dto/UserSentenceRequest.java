package com.berkay.ieltsapp.dto;

// dto nun içinde entity olmamalı
public class UserSentenceRequest {
    private String sentence;
    private Long dailyWordId;
    // bu üst kısım postmanden nasıl alacağımı göstemek için yazıldı o yüzden hiç
    // bir entity ya repo service kullanılmadı
    public UserSentenceRequest(  Long dailyWordId,String sentence){
        this.sentence=sentence;
        this.dailyWordId=dailyWordId;
    }
     public void setDailyWordId(Long dailyWordId){this.dailyWordId=dailyWordId;}
    public void setSentence(String sentence ){this.sentence=sentence;}

    public Long getDailyWordId(){return dailyWordId;}
    public String getSentence(){return sentence;}
}
