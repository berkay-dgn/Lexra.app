package com.berkay.ieltsapp.controller;
import com.berkay.ieltsapp.entity.DailyWord;
import com.berkay.ieltsapp.service.DailyWordService;
import com.berkay.ieltsapp.service.UserService;
import com.berkay.ieltsapp.entity.AppUser;
import com.berkay.ieltsapp.repository.UserRepo;
import org.springframework.web.bind.annotation.*;

import java.util.*;
@RestController
@RequestMapping("/API/DailyWord")
public class DailyWordController {
    private final DailyWordService service;
    public DailyWordController(DailyWordService service){
        this.service=service;
    }
    @GetMapping("/{ID}")
    public List<DailyWord>getTodayWordsForUser(@PathVariable("ID") Long ID){
        return service.getTodayWordsForUser(ID);
    }

    @PutMapping("/{ID}/completed")
    public DailyWord markAsCompleted(@PathVariable("ID") Long Id){
        return service.markAsCompleted(Id);
    }
    @GetMapping("/{ID}/completed")
    public List<DailyWord> getCompletedWord(@PathVariable("ID") Long Id){
        return service.getCompletedWord(Id);
    }
    @GetMapping("/{ID}/uncompleted") // methodaların endpointleri faklı olmak zorunda
    // eğer endpointler aynı olursa mappingte sıkıntı çıkıyor
    public List<DailyWord> getUncompletedWord(@PathVariable("ID")Long ID){
        return service.getUnCompletedWord(ID);
    }


}
