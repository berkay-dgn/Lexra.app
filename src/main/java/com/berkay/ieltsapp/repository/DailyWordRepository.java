package com.berkay.ieltsapp.repository;
import java.util.*;
import com.berkay.ieltsapp.entity.AppUser;
import java.time.LocalDate;
import com.berkay.ieltsapp.entity.DailyWord;
import org.springframework.data.jpa.repository.JpaRepository;
public interface DailyWordRepository extends JpaRepository<DailyWord,Long> {
    List<DailyWord> findByUserAndDate(AppUser user, LocalDate date);
}
