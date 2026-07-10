package com.berkay.ieltsapp.service;
import com.berkay.ieltsapp.entity.*;
import com.berkay.ieltsapp.repository.*;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;
import java.util.Optional;
@Service
public class UserWordProgeressService {
    private final UserWordProgeressRepo progeressRepo;
    public UserWordProgeressService(UserWordProgeressRepo progeressRepo){
        this.progeressRepo=progeressRepo;
    }
    public List<UserWordProgeress> showAllProgeress(){
         return progeressRepo.findAll();
    }
    public List<UserWordProgeress> showUsersProgeress(AppUser user){
        return progeressRepo.findByUser(user);
    }
    public List<WordList> showUsersReviewedWords(AppUser user
            , LocalDate nextReviewAt){
        return progeressRepo.findByUserAndNextReviewAt(user,nextReviewAt);
    }

}
