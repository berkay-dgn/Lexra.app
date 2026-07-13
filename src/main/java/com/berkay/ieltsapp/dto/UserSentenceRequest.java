package com.berkay.ieltsapp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate.*;

// dto nun içinde entity olmamalı
public class UserSentenceRequest {
    @JsonProperty("sentence")
    private String sentence;
    @JsonProperty("dailyWordId")
    private Long dailyWordId;
    @JsonProperty("userId")
    private Long userId;
    @JsonProperty("isCorrect")
    private boolean isCorrect;
    @JsonProperty("date")// bu ve isCorrect kısmı gereksiz bunları silemek lazım
    private String date;

    // bu üst kısım postmanden nasıl alacağımı göstemek için yazıldı o yüzden hiç
    // bir entity ya repo service kullanılmadı
    // bu sentence request kullanıcı bize ne gönderdiğini kullanan kısım
    public UserSentenceRequest() {
    }

    public UserSentenceRequest(Long dailyWordId, String sentence) {
        this.sentence = sentence;
        this.dailyWordId = dailyWordId;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setCorrect(boolean isCorrect) {
        this.isCorrect = isCorrect;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setDailyWordId(Long dailyWordId) {
        this.dailyWordId = dailyWordId;
    }

    public void setSentence(String sentence) {
        this.sentence = sentence;
    }

    public String getDate() {
        return date;
    }

    public boolean getCorrect() {
        return isCorrect;
    }

    public Long getUserId() {
        return userId;
    }

    public Long getDailyWordId() {
        return dailyWordId;
    }

    public String getSentence() {
        return sentence;
    }
}
