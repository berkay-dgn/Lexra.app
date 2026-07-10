package com.berkay.ieltsapp.service;
import com.berkay.ieltsapp.entity.*;
import com.berkay.ieltsapp.repository.*;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Service
public class
DailyWordService {
    private final DailyWordRepository dailyWordRepository;
    private final UserRepo userRepo;
    private final WordRepository wordRepository;
    public DailyWordService(DailyWordRepository dailyWordRepository,
                            UserRepo userRepo,
                            WordRepository wordRepository) {
        this.dailyWordRepository = dailyWordRepository;
        this.userRepo = userRepo;
        this.wordRepository = wordRepository;
    }
    public List<DailyWord> getTodayWordsForUser(Long userId) {
        AppUser user = userRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        LocalDate today = LocalDate.now();

        List<DailyWord> todayWords = dailyWordRepository.findByUserAndDate(user, today);

        if (!todayWords.isEmpty()) {
            return todayWords;
        }

        List<WordList> allWords = wordRepository.findAll();

        int limit = user.getDailyLimit();

        List<DailyWord> newDailyWords = new ArrayList<>();

        for (int i = 0; i < limit && i < allWords.size(); i++) {
            DailyWord dailyWord = new DailyWord( user,today,allWords.get(i),false);
            newDailyWords.add(dailyWord);
        }

        return dailyWordRepository.saveAll(newDailyWords);
    }

    public DailyWord markAsCompleted(Long dailyWordId) {
        DailyWord dailyWord = dailyWordRepository.findById(dailyWordId)
                .orElseThrow(() -> new RuntimeException("Daily word not found"));

        dailyWord.setCompleted(true);

        return dailyWordRepository.save(dailyWord);
    }
    public List<DailyWord >getCompletedWord(Long userId){
        AppUser user=userRepo.findById(userId)
                .orElseThrow(()->new RuntimeException("User not found"));
        return  dailyWordRepository.findByUserAndCompleted(user,true);

    }
    public List<DailyWord>getUnCompletedWord(Long userId){
        AppUser user = userRepo.findById(userId)
                .orElseThrow(()->new RuntimeException(" User not found"));
        return dailyWordRepository.findByUserAndCompleted(user,false);
    }
}
