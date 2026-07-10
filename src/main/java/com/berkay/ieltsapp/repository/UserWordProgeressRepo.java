package com.berkay.ieltsapp.repository;
import com.berkay.ieltsapp.entity.*;

import java.time.LocalDate;
import java.util.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.hibernate.annotations.Generated;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserWordProgeressRepo extends JpaRepository<UserWordProgeress,Long> {
    List<UserWordProgeress>findByUser(AppUser user);
    List<UserWordProgeress>findByWord(WordList word);
    List<UserWordProgeress>findByUserAndLearned(AppUser user,boolean learned);
    List<UserWordProgeress>findByUserAndReviewLater(AppUser user,boolean reviewLater);
    List<UserWordProgeress>findByUserAndWord(AppUser user,WordList word);
    @Query("Select u From UserWordProgeress u Where u.nextReviewAt <: today And u.user=user" )
    List<WordList>findByUserAndNextReviewAt(@Param("nextReviewAt") LocalDate nextReviewAt
            ,@Param("user") AppUser user);
    Long countByUser(AppUser user);
    Long countByUserAndLearned(AppUser user,boolean learned);// satırları sayacak
    Long countByUserAndReviewLater(AppUser user,boolean reviewLater);
}
