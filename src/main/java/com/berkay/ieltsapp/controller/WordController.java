package com.berkay.ieltsapp.controller;
import com.berkay.ieltsapp.entity.WordList;
import com.berkay.ieltsapp.service.WordService;
import com.berkay.ieltsapp.repository.WordRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/API/word")
@RestController
public class WordController {
    private final WordService wordService;
    public WordController(WordService wordService1){
        this.wordService=wordService1;
    }
    @GetMapping
    public List<WordList> getAllWorld(){
        return wordService.showList();
    }
    @GetMapping("/{id}")
    public WordList getById( @PathVariable long id){
        return wordService.getWordById(id);
    }
    @GetMapping("/{word}")
    public WordList addWord(@PathVariable WordList word){
        return wordService.addWord(word);
    }
    @GetMapping("/{id}")
    public void deleteWordById(@PathVariable long id){
        wordService.deleteWord(id);
    }

}
