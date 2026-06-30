package com.berkay.ieltsapp.service;
import com.berkay.ieltsapp.entity.DailyWord;
import com.berkay.ieltsapp.entity.AppUser;
import com.berkay.ieltsapp.entity.WordList;
import com.berkay.ieltsapp.repository.DailyWordRepository;
import org.springframework.stereotype.Service;
import java.util.*;
@Service
public class DailyWordService {
   private final DailyWordRepository wordRepository;
   public DailyWordService(DailyWordRepository wordRepository){
       this.wordRepository=wordRepository;
   }

}
