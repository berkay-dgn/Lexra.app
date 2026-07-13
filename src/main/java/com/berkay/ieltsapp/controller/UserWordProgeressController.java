package com.berkay.ieltsapp.controller;
import com.berkay.ieltsapp.dto.ProgeressRequest;
import com.berkay.ieltsapp.service.*;
import com.berkay.ieltsapp.repository.*;
import com.berkay.ieltsapp.entity.*;
import org.springframework.web.bind.annotation.*;
import java.util.*;
@RestController
@RequestMapping("/API/progeress")
public class UserWordProgeressController {
    private WordRepository wordRepo;
    private UserRepo userRepo;
    private  final UserWordProgeressService progeressService;
    private final UserWordProgeressRepo progeressRepo;
    public UserWordProgeressController(UserWordProgeressService progeressService
            ,UserWordProgeressRepo progeressRepo){
        this.progeressService=progeressService;
        this.progeressRepo=progeressRepo;
    }
    @PostMapping("/showLearnedWord")
    public List<UserWordProgeress> showLearnedWord(@RequestBody ProgeressRequest progeress){
        AppUser user= userRepo.findById(progeress.getUserId())
                .orElseThrow(()->new RuntimeException("User not found"));
        return(progeressService.showLearnedWord(user, progeress.getLearned()));


    }
    @PostMapping("/showUnLearnedWord")
    public List<UserWordProgeress> showUnLearnedWord(@RequestBody ProgeressRequest progeress){
        AppUser user=userRepo.findById(progeress.getUserId())
                .orElseThrow(()->new RuntimeException("User not found"));
        return(progeressService.showUnLearnedWord(user, progeress.getLearned()));

    }
    @PostMapping("/showReviewedWords")
    public List<UserWordProgeress> showReviewedWords(@RequestBody ProgeressRequest progeress){
        AppUser user=userRepo.findById(progeress.getUserId())
                .orElseThrow(()->new RuntimeException("User not found"));
        return(progeressService.showReviewedWords(user, progeress.getReviewLater()));
    }
    @PostMapping("/addReviewList")
    public void addReviewList(@RequestBody ProgeressRequest progeress){
        AppUser user=userRepo.findById(progeress.getUserId())
                .orElseThrow(()->new RuntimeException(" User not found"));
        WordList word=wordRepo.findById(progeress.getDailyWordId())
                .orElseThrow(()->new RuntimeException(" Word not found "));
        progeressService.addReviewList(user,word);
    }
    @PostMapping("/findOrCreateProgeress")
    public UserWordProgeress findOrCreateProgeress(@RequestBody ProgeressRequest progeress){
        AppUser user=userRepo.findById(progeress.getUserId())
                .orElseThrow(()->new RuntimeException("User not found "));
        WordList word=wordRepo.findById(progeress.getDailyWordId())
                .orElseThrow(()->new RuntimeException("Word not found "));
        return(progeressService.findOrCreateProgeress(user,word));

    }
    @PutMapping("/countLearnedWords")
    public void countLearnedWords(@RequestBody ProgeressRequest progeress){
        AppUser user=userRepo.findById(progeress.getUserId())
                .orElseThrow(()->new RuntimeException("User not found "));
        progeressService.countLearnedWords(user, progeress.getLearned());
    }
    @PutMapping("/countCorrectWords")
    public void countCorrectWords(@RequestBody ProgeressRequest progeress){
        AppUser user=userRepo.findById(progeress.getUserId())
                .orElseThrow(()->new RuntimeException("User not found"));
        UserWordProgeress pro=progeressRepo.findByUser(user)
                .orElseThrow(()->new RuntimeException("Progeress not found"));
        progeressService.countCorrectWords(pro);
    }
    @PutMapping("/countUnlearnedWords")
    public void countUnlearnedWords(@RequestBody ProgeressRequest progeress){
        AppUser user=userRepo.findById(progeress.getUserId())
                .orElseThrow(()->new RuntimeException("User not found "));
        progeressService.countUnlearnedWords(user, progeress.getLearned());

    }
    @PutMapping("/countWrongWords")
    public void countWrongWords(@RequestBody ProgeressRequest progeress){
        AppUser user=userRepo.findById(progeress.getUserId())
                .orElseThrow(()->new RuntimeException("User not found"));
        UserWordProgeress pro=progeressRepo.findByUser(user)
                .orElseThrow(()->new RuntimeException("Progeress not found "));
        progeressService.countWrongWords(pro);

    }
    @DeleteMapping("/removeWordFromReviewList")
    public void removeWordFromReviewList(@RequestBody ProgeressRequest progeress){
        AppUser user=userRepo.findById(progeress.getUserId())
                .orElseThrow(()->new RuntimeException("User not found "));
        WordList word=wordRepo.findById(progeress.getDailyWordId())
                .orElseThrow(()->new RuntimeException(" Progeress not found "));
        progeressService.removeWordFromReviewList(user,word);

    }

}
