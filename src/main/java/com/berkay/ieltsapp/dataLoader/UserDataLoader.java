package com.berkay.ieltsapp.dataLoader;
import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import com.berkay.ieltsapp.repository.*;
import com.berkay.ieltsapp.entity.*;

import java.util.List;

@Component
public class UserDataLoader implements CommandLineRunner {
    private UserRepo userRepo;
    private ObjectMapper objectMapper;
    public UserDataLoader(UserRepo userRepo,ObjectMapper objectMapper){
        this.userRepo=userRepo;
        this.objectMapper=objectMapper;
    }
    public void run(String...args) throws Exception{
        if(userRepo.count()>0){/* e mail ile kontrol eklemem lazım
        bu şekilde olan kotrol yüzünden 1 kelime bile ekledikten
        sonta yeni kelime ekliyemiyor */
            return;
        }
        ClassPathResource resource=new ClassPathResource("data/user.json");
        List<AppUser> user=objectMapper.readValue(resource.getInputStream()
                ,new TypeReference<List<AppUser>>(){});
        userRepo.saveAll(user);
        System.out.println("Loaded user count is : "+userRepo.count());

    }

}
