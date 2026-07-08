package com.berkay.ieltsapp.controller;
import com.berkay.ieltsapp.service.*;
import org.springframework.web.bind.annotation.*;
import com.berkay.ieltsapp.entity.*;
import com.berkay.ieltsapp.repository.*;
import java.util.*;
@RestController
@RequestMapping("/API/sentence")
public class UserSentenceController {
    private final UserSentenceService service;
    private final UserRepo userRepo;
    public UserSentenceController(UserSentenceService service,UserRepo userRepo){
        this.service=service;
        this.userRepo=userRepo;
    }
    @PostMapping("{daily_Id}/sentence/{sentence}")
    public UserSentence submitSentence(@PathVariable Long daily_Id,@PathVariable String sentence){
        return service.submitSentence(daily_Id, sentence);
    }

    @GetMapping("{Id}/incorrect/{incorrect}")
    public List<UserSentence> showFalseSentence(@PathVariable AppUser user
            ,@PathVariable boolean incorrect){
        return service.showFalseSentence(user,false);
    }
    @GetMapping("{Id}/correct/{Correct}")
    public long correctWordCount(@PathVariable AppUser user
            ,@PathVariable boolean Correct){
        return service.correctWordCount(user,true);
    }
    @GetMapping("{user}")
    public double evaluateSuccessRate(@PathVariable AppUser user){
        return service.evaluateSuccessRate(user);
    }
    @DeleteMapping("{sentence}")
    public void deleteSentence(@PathVariable UserSentence sentence){
        service.deleteSentence(sentence);
    }
}
