package com.berkay.ieltsapp.repository;
import com.berkay.ieltsapp.entity.WordList;
import org.springframework.data.jpa.repository.JpaRepository;
public interface WordRepository extends JpaRepository<WordList,Long> {

}
