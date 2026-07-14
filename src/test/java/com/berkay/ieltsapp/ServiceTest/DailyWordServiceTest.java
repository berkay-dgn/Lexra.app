package com.berkay.ieltsapp.ServiceTest;
import com.berkay.ieltsapp.repository.DailyWordRepository;
import com.berkay.ieltsapp.service.DailyWordService;
import com.berkay.ieltsapp.entity.*;
import org.antlr.v4.runtime.atn.SemanticContext;
import com.berkay.ieltsapp.repository.*;
import com.berkay.ieltsapp.entity.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.berkay.ieltsapp.repository.WordRepository;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;
@ExtendWith(MockitoExtension.class)

public class DailyWordServiceTest {
    @Mock
    private DailyWordRepository dailyRepo ;
    @Mock
    private UserRepo userRepo;
    @Mock
    private WordRepository wordRepository;
    @InjectMocks
    private DailyWordService dailyWordService;
    @Test
   void shouldReturnExistingWords_WhenTodayWordsExist(){
        AppUser user=new AppUser(40L,"ber@","berk"
                ,4,"B1","kdskfl");
        LocalDate date=LocalDate.now();
        DailyWord existingWord = new DailyWord(user, date, new WordList(), false);
        List<DailyWord> existingList = List.of(existingWord);
        when(userRepo.findById(40L)).thenReturn(Optional.of(user));
        when(dailyRepo.findByUserAndDate(user, date)).thenReturn(existingList);
        List<DailyWord> result = dailyWordService.getTodayWordsForUser(40L);
        assertThat(result).isEqualTo(existingList);
        verify(dailyRepo,never()).saveAll(any());

    }
    @Test
    void shouldCreateNewWord_WhenTodayWordNotExist(){
        AppUser user=new AppUser(42L,"b@","c"
                ,5,"A2","123");
        LocalDate date=LocalDate.now();
        WordList word1=new WordList();
        WordList word2=new WordList();
        List<WordList> allWords=List.of(word1,word2);
        when(userRepo.findById(42L)).thenReturn(Optional.of(user));
        when(dailyRepo.findByUserAndDate(user,date)).thenReturn(List.of());
        when(wordRepository.findAll()).thenReturn(allWords);
        when(dailyRepo.saveAll(anyList()))
                .thenAnswer(invocation ->invocation.getArgument(0) );

        List<DailyWord>result=dailyWordService.getTodayWordsForUser(42L);

        assertThat(result).hasSize(2);
        verify(dailyRepo).saveAll(anyList());
    }
}
