package com.berkay.ieltsapp.service;
import com.berkay.ieltsapp.entity.WordList;
import com.berkay.ieltsapp.repository.WordRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class WordService {
   private final WordRepository wordRepository;
   public WordService(WordRepository wordRepository){
       this.wordRepository=wordRepository;
   }
   public List<WordList> showList(){
       return wordRepository.findAll();
   }
   public WordList getWordById(long Id){
      return wordRepository.findById(Id).orElseThrow(()->new RuntimeException(" user can't find "));
   }
   public WordList addWord(WordList word){
       return wordRepository.save(word);
   }
   public void deleteWord(long Id){
       WordList word=getWordById(Id);
       wordRepository.delete(word);
       System.out.println(word + " has been deleted");
   }
}
