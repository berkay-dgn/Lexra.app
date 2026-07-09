package com.berkay.ieltsapp.repository;
import com.berkay.ieltsapp.entity.*;
import java.util.*;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
public interface UserSentenceRepo extends JpaRepository<UserSentence,Long> {
    List<UserSentence>findByUser(AppUser user);
    List<UserSentence>findByUserAndCorrect(AppUser user,boolean correct);
    List<UserSentence>findByDailyWord(DailyWord word);
    long countByUser(AppUser user);
    long countByUserAndCorrect(AppUser user,boolean correct);
    List<UserSentence>findByDailyWordAndCorrect(DailyWord word,boolean correct);

}
