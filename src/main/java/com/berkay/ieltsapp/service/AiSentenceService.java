package com.berkay.ieltsapp.service;
import java.util.*;
import com.berkay.ieltsapp.dto.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.genai.*;
import com.google.genai.types.GenerateContentResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
@Service
public class AiSentenceService {
    private final Client client;
    public AiSentenceService(@Value("${gemini.api.key}") String apiKey){
        this.client= Client.builder().apiKey(apiKey).build();
    }
    public AiSentenceResponse checkUserSentenceWithAi(String targetWord,String sentence
            ,String userLevel){
        String promth=String.format("""
                You are an experienced English teacher\
                for an IELTS learning application. \
                Your task is to evaluate student's sentence : \
                Student Level :%s\
                Target Word: %s\
                Student sentence :%s\
                Evaluate the sentence using the following criteria\
                1. Check whether the target word is used in the sentence.\
                2. Check whether the target word is used with the correct meaning.\
                3. Check the grammar.\
                4. Check whether the sentence sounds natural.\
                5. Give short and clear feedback suitable for the student's English level.\
                 6.If the sentence is incorrect, provide a corrected version.\
                 7. If the sentence is correct,\
                don't return any corrected sentence just declare null data type for corrected sentence.\
                8. Create ONE additional example sentence using the target word correctly.\
                And you have to return only valid JSON object in following format : \
                {
                  "correct": true,
                  "feedback": "...",
                  "correctedSentence": "...",
                  "exampleSentence": "..."
                } \
                Do not write markdown \
                Do not write explanations\
                Do not use ''json \
                Return only JSON object\s""",userLevel,targetWord,sentence);
        GenerateContentResponse response=client.models
                .generateContent("gemini-3.1-flash-lite",promth,null);
        String jsonText=response.text();
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(jsonText, AiSentenceResponse.class);
        } catch (Exception e) {
            throw new RuntimeException("Gemini can't parse : " + jsonText, e);
        }

    }


}
