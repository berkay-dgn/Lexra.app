package com.berkay.ieltsapp.service;
import com.berkay.ieltsapp.entity.*;
import com.berkay.ieltsapp.repository.*;

import java.time.LocalDate;
import java.util.*;
import java.util.Optional;
import java.util.List;
import org.springframework.stereotype.Service;
@Service
public class UserWordProgeressService {
    private final UserWordProgeressRepo progeressRepo;
    private final UserWordProgeress wordProgeress;
    public UserWordProgeressService(UserWordProgeressRepo progeressRepo
            ,UserWordProgeress wordProgeress ){
        this.progeressRepo=progeressRepo;
        this.wordProgeress=wordProgeress;
    }
    public List<UserWordProgeress> showAllProgeress(){
        return progeressRepo.findAll();
    }
    public List<UserWordProgeress> showLearnedWord(AppUser user, boolean learned){
        return progeressRepo.findByUserAndLearned(user,true);
    }
    public List<UserWordProgeress> showUnLearnedWord(AppUser user,boolean learned){
        return progeressRepo.findByUserAndLearned(user,false);
    }
    public List<UserWordProgeress> showReviewedWords(AppUser user,boolean reviewLater ){
        return progeressRepo.findByUserAndReviewLater(user,true);
    }
    public void addReviewList(AppUser user,WordList word){
        UserWordProgeress progeress=
                progeressRepo.findByUserAndWord(user,word).orElseThrow(()->
                new RuntimeException("Progeress not found ! "));
        progeress.setReviewLater(true);
        progeressRepo.save(progeress);
        System.out.println(" Word has been added review list ");
    }
    public UserWordProgeress findOrCreateProgeress(AppUser user, WordList word){
        return progeressRepo.findByUserAndWord(user,word).orElseGet(()->{
            UserWordProgeress newProgeress=new UserWordProgeress(user,word,false,0,0,LocalDate.now(),
                    LocalDate.now(),false);
            return progeressRepo.save(newProgeress);
        });

    }
    public long countLearnedWords(AppUser user,boolean learned){
       return progeressRepo.countByUserAndLearned(user,learned);
    }
    public void countCorrectWords(UserWordProgeress progeress){
        long correct_Count=progeress.getCorrectCount();
        correct_Count+=1;
        progeress.setCorrectCount(correct_Count);
    }
    public long countUnlearnedWords(AppUser user,boolean learned){
        learned=false;
        return progeressRepo.countByUserAndLearned(user,learned);
    }
    public void countWrongWords(UserWordProgeress progeress){
        long wrongCount=progeress.getWrongCount();
        WordList word=progeress.getWord();
        AppUser user=progeress.getUser();
        wrongCount+=1;
        wordProgeress.setWrongCount(wrongCount);
        if(wrongCount>=3){
            wordProgeress.setReviewLater(true);
            addReviewList(user,word);
        }
    }


}
