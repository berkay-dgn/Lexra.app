package com.berkay.ieltsapp.service;
import com.berkay.ieltsapp.dto.AiSentenceResponse;
import com.berkay.ieltsapp.repository.*;
import com.berkay.ieltsapp.entity.*;
import com.berkay.ieltsapp.dto.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserSentenceService {
    private final AiSentenceService aiService;
    private final DailyWordService dailyService;
    private final DailyWordRepository wordRepository;
    private final UserService userService;
    private final WordService wordService;
    private final UserRepo userRepo;
    private final UserSentenceRepo userSentenceRepo;
    private final WordRepository wordRepo;
    private final UserWordProgeressService progeressService;
    private final UserWordProgeressRepo progeressRepo;

    public UserSentenceService(UserService userService,WordService wordService
            ,UserRepo userRepo,UserSentenceRepo userSentenceRepo
            ,WordRepository wordRepo,DailyWordService dailyService
            ,DailyWordRepository wordRepository,UserWordProgeressService progeressService
    ,UserWordProgeressRepo progeressRepo,AiSentenceService aiService){
        this.aiService=aiService;
        this.userRepo=userRepo;
        this.userService=userService;
        this.wordService=wordService;
        this.wordRepo=wordRepo;
        this.userSentenceRepo=userSentenceRepo;
        this.dailyService=dailyService;
        this.wordRepository=wordRepository;
        this.progeressService=progeressService;
        this.progeressRepo=progeressRepo;
    }
    // kullanıcının yazdığı örnek cümleyi database kaydeder
    public UserSentenceResponse submitSentence(Long daily_Id,String sentence){
        DailyWord dailyWord=wordRepository.findById(daily_Id).
                orElseThrow(()->new RuntimeException("this word does not exist"));
        AppUser user=dailyWord.getUser();
        WordList word=dailyWord.getWord();
        String targetWord=word.getWord();
        String userLevel=user.getCurrentLevel();
        checkWord(daily_Id, sentence);
        AiSentenceResponse response= aiService.checkUserSentenceWithAi(targetWord
                ,sentence,userLevel);
        String feedback=response.getFeedback();
        String correctedSentence=response.getCorrectedSentence();
        UserSentence sentence1=new UserSentence(user,dailyWord
                ,sentence, response.getCorrect());
        sentence1.setCorrectedSentence(correctedSentence);
        sentence1.setFeedback(feedback);
        progeressService.findOrCreateProgeress(user,word);
        UserSentence saved=userSentenceRepo.save(sentence1);
        UserSentenceResponse response1=new UserSentenceResponse(sentence, response.getCorrect(),
                saved.getCreatedAt(),saved.getFeedback(),saved.getCorrectedSentence() );

        return response1;

    }
    public List<UserSentence> showAllSentence(){
        return userSentenceRepo.findAll();
    }
    // kullanıcın doğru yaptığı örnek cümleleri gösterir
    public List<UserSentence> showCorrectSentence(AppUser user, Boolean correct){
        return userSentenceRepo.findByUserAndCorrect(user,true);
    }
    // kullanıcının yanlış yazdığı örnek cümleri gösterme
    public List<UserSentence> showFalseSentence(AppUser user, Boolean incorrect){
        return userSentenceRepo.findByUserAndCorrect(user,false);
    }
    // kullanıcının yazdığı doğru kelime sayısnın hesaplar
    public long correctWordCount(AppUser user,Boolean correct){
        return userSentenceRepo.countByUserAndCorrect(user,true);
    }
    /* kullanıcın doğru sentence sayısının ve toplam yazdığı sentence sayısnı kullanarak
       kullanıcının başarı yüzdesini hesaplayarak döndürüyor
     */
    public double evaluateSuccessRate(AppUser user){
        long sentence_Count=userSentenceRepo.countByUser(user);
        long correctSentence_count=correctWordCount(user,true);
        double successRate=(correctSentence_count)*100/sentence_Count;
        return successRate;
    }
    public void deleteSentence(UserSentence sentence){
        System.out.println("Are you sure ?  you want to delete this sentence : "
        +" "+sentence);
        userSentenceRepo.delete(sentence);
        System.out.println(" your sentence has been deleted ");
    }
    private boolean checkWord(Long daily_Id,String Sentence){
        DailyWord dailyWord=wordRepository.findById(daily_Id).orElseThrow(()
                ->new RuntimeException("Word does not exist"));
        AppUser user=dailyWord.getUser();
        WordList word=dailyWord.getWord();
        String targetWord=word.getWord();
        boolean isContain=Sentence.toLowerCase().contains(targetWord.toLowerCase());
        return isContain;
    }

}
