package com.berkay.ieltsapp.dataLoader;
import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import com.berkay.ieltsapp.repository.*;
import com.berkay.ieltsapp.entity.*;

import java.lang.reflect.Type;
import java.util.List;
//kelime kaydedeceği için data base repositorye ihtiyacı var
@Component /* Bu annotation springe bu sınıfı onun yöneteceğini
ve uygulama başlar başlamaz bunu başlatması
gerektiğini söyler bu olmazsa spring  classı görmez */
public class WordDataLoader implements CommandLineRunner {
    //CommandLineRunner springe uygulama çalışmaya başladıktan sonra bu methodun run ının çalıştırır
    private WordRepository wordRepo;
    private ObjectMapper objectMapper;//Json ı javaya çevirir
    public WordDataLoader(WordRepository wordRepo
            ,ObjectMapper objectMapper){
        this.wordRepo=wordRepo;
        this.objectMapper=objectMapper;
    }
    @Override
    public void run(String...args) throws Exception{
        if(wordRepo.count()>0){
            return;
        //Eğer database doluysa database i okumakla uğraşmaz
        }
        ClassPathResource resource=new ClassPathResource("data/words.json");
        List<WordList> words=objectMapper.readValue(resource.getInputStream()
                ,new TypeReference<List<WordList>>(){});
        wordRepo.saveAll(words);
        System.out.println("Loaded word count is : "+wordRepo.count());

    }
}
