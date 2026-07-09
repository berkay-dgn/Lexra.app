package com.berkay.ieltsapp.controller;
import com.berkay.ieltsapp.service.*;
import org.springframework.web.bind.annotation.*;
import com.berkay.ieltsapp.entity.*;
import com.berkay.ieltsapp.repository.*;
import com.berkay.ieltsapp.dto.*;
import java.util.*;
@RestController
@RequestMapping("/API/sentence")
public class UserSentenceController {
    private final UserSentenceService service;
    private final UserRepo userRepo;
    private final UserSentenceRepo sentenceRepo;
    public UserSentenceController(UserSentenceService service,UserRepo userRepo
            ,UserSentenceRepo sentenceRepo){
        this.service=service;
        this.userRepo=userRepo;
        this.sentenceRepo=sentenceRepo;
    }
    @PostMapping("/submitSentence")
    public UserSentence submitSentence(@RequestBody UserSentenceRequest request){
        System.out.println(request.getDailyWordId());
        System.out.println(request.getSentence());
        return(service.submitSentence(request.getDailyWordId(), request.getSentence()));
    }

    @PostMapping("/showFalseSentence")
    public List<UserSentence> showFalseSentence(@RequestBody UserSentenceRequest request){
        AppUser user =userRepo.findById(request.getDailyWordId()).orElseThrow(()->
                new RuntimeException("user not found"));
        System.out.println(request.getDailyWordId());
        System.out.println(request.getSentence());
        return (service.showFalseSentence(user, request.getCorrect()));
    }
    @PostMapping("/correctWordCount")
    public long correctWordCount(@RequestBody UserSentenceRequest request){
        AppUser user=userRepo.findById(request.getUserId()).orElseThrow(()->
                new RuntimeException("user not found"));
        System.out.println(request.getUserId());
        System.out.println(request.getCorrect());
        return (service.correctWordCount(user,request.getCorrect()));
    }
    @PostMapping("/evaluateSuccessRate")
    public double evaluateSuccessRate(@RequestBody UserSentenceRequest request){
       AppUser user =userRepo.findById(request.getUserId()).orElseThrow(()->
               new RuntimeException("user not found"));
       return (service.evaluateSuccessRate(user));
    }
    @DeleteMapping("/{sentenceId}")
    public void deleteSentence(@PathVariable("sentenceId") Long sentenceId){
        sentenceRepo.findById(sentenceId).orElseThrow(()->
                new RuntimeException(" sentence not found"));
        sentenceRepo.deleteById(sentenceId);
        System.out.println("Sentence has been deleted");
    }
}
