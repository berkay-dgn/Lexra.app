package com.berkay.ieltsapp.controller;
import com.berkay.ieltsapp.dto.UserStatsResponse;
import com.berkay.ieltsapp.service.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/API/userStats")
public class UserStatsController {
    private final UserStatsService statsService;
    public UserStatsController(UserStatsService statsService){
        this.statsService=statsService;
    }
    @PostMapping("/{userId}")
    public UserStatsResponse getUserStatics(@PathVariable Long userId){
        return statsService.getUserStatics(userId);
    }
}
