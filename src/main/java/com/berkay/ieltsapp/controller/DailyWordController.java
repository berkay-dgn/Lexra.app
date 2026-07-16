package com.berkay.ieltsapp.controller;
import com.berkay.ieltsapp.entity.DailyWord;
import com.berkay.ieltsapp.service.DailyWordService;
import com.berkay.ieltsapp.service.UserService;
import com.berkay.ieltsapp.entity.AppUser;
import com.berkay.ieltsapp.repository.UserRepo;
import jakarta.validation.constraints.Positive;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.*;
@RestController
@RequestMapping("/API/DailyWord")
@Validated
public class DailyWordController {
    private final DailyWordService service;
    public DailyWordController(DailyWordService service){
        this.service=service;
    }
    @GetMapping("/{ID}")
    public List<DailyWord>getTodayWordsForUser(@PathVariable("ID") @Positive Long ID){
        return service.getTodayWordsForUser(ID);
    }

    @PutMapping("/{ID}/completed")
    public DailyWord markAsCompleted(@PathVariable("ID") @Positive Long Id){
        return service.markAsCompleted(Id);
    }
    @GetMapping("/{ID}/completed")
    public List<DailyWord> getCompletedWord(@PathVariable("ID") @Positive Long Id){
        return service.getCompletedWord(Id);
    }
    @GetMapping("/{ID}/uncompleted") // methodaların endpointleri faklı olmak zorunda
    // eğer endpointler aynı olursa mappingte sıkıntı çıkıyor
    public List<DailyWord> getUncompletedWord(@PathVariable("ID") @Positive Long ID){
        return service.getUnCompletedWord(ID);
    }


}
