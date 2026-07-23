package com.berkay.ieltsapp.service;
import com.berkay.ieltsapp.dto.UserStatsResponse;
import com.berkay.ieltsapp.repository.*;
import com.berkay.ieltsapp.entity.*;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
public class UserStatsService {
    //Constructor injection
    private UserStatsResponse response;
    private UserRepo userRepo;
    private DailyWordRepository dailyRepository;
    private UserSentenceRepo sentenceRepo;
    public UserStatsService(DailyWordRepository dailyRepository
            ,UserSentenceRepo sentenceRepo,UserRepo userRepo){
        this.dailyRepository=dailyRepository;
        this.sentenceRepo=sentenceRepo;
        this.userRepo=userRepo;
    }
    public UserStatsResponse getUserStatics(Long userId){
        AppUser user=userRepo.findById(userId)
                .orElseThrow(()->new RuntimeException("User not found"));
        Long totalCorrect=sentenceRepo.countByUserAndCorrect(user,true);
        Long todayAssignedWord=dailyRepository.countByUserAndDate(user, LocalDate.now());//
        Long completedWord=dailyRepository.countByUserAndCompleted(user,true);
        Long todayCompletedWord=dailyRepository
                .countByUserAndDateAndCompleted(user,LocalDate.now(),true);
        Long accuracyRate=(totalCorrect*100)/todayAssignedWord;
        Long todayRemainingWord=todayAssignedWord-todayCompletedWord;
        List<LocalDate> userHistory=sentenceRepo.findDistinctCreatedAtByUser(user);
        Long currentStreak=null;
        LocalDate exceptedDate=userHistory.get(0);
        if(userHistory.isEmpty()){
            response.setCurrentStreak(0L);
        }else{
            for(int i=0;i<=userHistory.size();i++){
                LocalDate currentDate=userHistory.get(i);
                if(currentDate.isEqual(exceptedDate)){
                    currentStreak++;
                    exceptedDate=exceptedDate.minusDays(1);
                }else{
                    break;
                }
            }
        }
        UserStatsResponse saved=new UserStatsResponse(totalCorrect,todayAssignedWord
                ,completedWord,todayRemainingWord,todayCompletedWord,accuracyRate,currentStreak);
        return saved;

    }
}
