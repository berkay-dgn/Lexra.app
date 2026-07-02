package com.berkay.ieltsapp.ServiceTest;
import com.berkay.ieltsapp.repository.DailyWordRepository;
import com.berkay.ieltsapp.service.DailyWordService;
import com.berkay.ieltsapp.entity.DailyWord;
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
import java.util.Optional;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;
@ExtendWith(MockitoExtension.class)

public class DailyWordServiceTest {
    @Mock
    private DailyWordRepository dailyRepo ;
    private UserRepo userRepo;
    private WordRepository wordRepository;
    @InjectMocks
    private DailyWordService dailyWordServiceService;
    @Test
    void shouldGetTodayWordsWhenIdExist(){
        AppUser user = new AppUser(43L,"Mail@","berk",5,"B1","A12.3");
        when(userRepo.save(user)).thenReturn(user);
        when(userRepo.findById(43L)).thenReturn(Optional.of(user));
    }
}
