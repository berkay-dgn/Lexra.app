package com.berkay.ieltsapp.repository;
import com.berkay.ieltsapp.entity.DailyWord;
import org.springframework.data.jpa.repository.JpaRepository;
public interface DailyWordRepository extends JpaRepository<DailyWord,Long> {
}
