package com.berkay.ieltsapp.service;
import com.berkay.ieltsapp.repository.*;
import com.berkay.ieltsapp.entity.*;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
public class UserSentenceService {
    private final DailyWordService dailyService;
    private final DailyWordRepository wordRepository;
    private final UserService userService;
    private final WordService wordService;
    private final UserRepo userRepo;
    private final UserSentenceRepo userSentenceRepo;
    private final WordRepository wordRepo;
    public UserSentenceService(UserService userService,WordService wordService
            ,UserRepo userRepo,UserSentenceRepo userSentenceRepo
            ,WordRepository wordRepo,DailyWordService dailyService
            ,DailyWordRepository wordRepository){
        this.userRepo=userRepo;
        this.userService=userService;
        this.wordService=wordService;
        this.wordRepo=wordRepo;
        this.userSentenceRepo=userSentenceRepo;
        this.dailyService=dailyService;
        this.wordRepository=wordRepository;
    }
    // kullanıcının yazdığı örnek cümleyi database kaydeder
    public UserSentence submitSentence(Long daily_Id,String sentence){
        DailyWord dailyWord=wordRepository.findById(daily_Id).
                orElseThrow(()->new RuntimeException("this word does not exist"));
        AppUser user=dailyWord.getUser();
        WordList word=dailyWord.getWord();
        String target_Word=word.getWord();
        boolean is_contain=sentence.toLowerCase().contains(target_Word.toLowerCase());
        UserSentence sentence1=new UserSentence(user,dailyWord,sentence,true,LocalDate.now());
        return userSentenceRepo.save(sentence1);
    }
    public List<UserSentence> showAllSentence(){
        return userSentenceRepo.findAll();
    }
    // kullanıcın doğru yaptığı örnek cümleleri gösterir
    public List<UserSentence> showCorrectSentence(AppUser user, boolean correct){
        return userSentenceRepo.findByUserAndCorrect(user,true);
    }
    // kullanıcının yanlış yazdığı örnek cümleri gösterme
    public List<UserSentence> showFalseSentence(AppUser user, boolean incorrect){
        return userSentenceRepo.findByUserAndCorrect(user,false);
    }
    // kullanıcının yazdığı doğru kelime sayısnın hesaplar
    public long correctWordCount(AppUser user,boolean correct){
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

}
