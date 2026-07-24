package com.berkay.ieltsapp.service;
import com.berkay.ieltsapp.dto.*;
import com.berkay.ieltsapp.entity.*;
import com.berkay.ieltsapp.repository.*;
import com.berkay.ieltsapp.service.*;
import org.springframework.stereotype.Service;
import java.util.*;
import java.util.List;

@Service
public class QuizService {
    private WordService wordService;
    private DailyWordRepository wordRepo;
    private UserRepo userRepo;
    private UserService userService;
    private UserSentenceService userSentence;
    public QuizService(UserService userService){
        this.userService=userService;
    }
    public List<QuizGenerateResponse> generateQuiz(long userId, int quizLimit){
        AppUser user=userService.findUser(userId);
        List<WordList> wordList=wordService.showList();
        Collections.shuffle(wordList);//reviewList içindeki kelimeleri karıştırdı
        List<DailyWord> dailyWord= wordRepo.findByUser(user);
        List<WordList>quizWords=new ArrayList<>();
        List<QuizGenerateResponse> responses=new ArrayList<>();
        if(quizLimit<= wordList.size()){
            for(int i=0;i<quizLimit;i++){
                QuizGenerateResponse response=new QuizGenerateResponse();
                WordList word=wordList.get(i);
                quizWords.add(word);
                response.setWord(word.getWord());
                response.setWordLevel(word.Level());
                responses.add(response);
            }
        }else{
            System.out.println("Please enter a valid quizLimit");
        }
        return responses;

    }
    //User sentence service de ki submiti çalıştırmak için dailyId  ve sentence lazım
    public List<QuizAnswerResponse> quizAnswer(List<QuizAnswerResponse> generateQuiz
            ,String sentence){
        Long dailyId=0L;
        for(int i=0;i< generateQuiz.size();i++){
            QuizAnswerResponse response=generateQuiz.get(i);
             dailyId= response.getDailyId();
        }
        List<QuizAnswerResponse> answer=new ArrayList<>();
        UserSentenceResponse variable=userSentence.submitSentence(dailyId,sentence);


    }

}
