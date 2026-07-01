package com.berkay.ieltsapp.controller;
import com.berkay.ieltsapp.entity.WordList;
import com.berkay.ieltsapp.service.WordService;
import com.berkay.ieltsapp.repository.WordRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/API/words")
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
    @PostMapping
    public WordList addWord(@RequestBody WordList word){
        return wordService.addWord(word);
    }
    @DeleteMapping("/{id}")
    public void deleteWord(@PathVariable  long id){
        wordService.deleteWord(id);
    }
}
