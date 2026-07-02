package com.berkay.ieltsapp.ServiceTest;
import com.berkay.ieltsapp.entity.WordList;
import com.berkay.ieltsapp.repository.WordRepository;
import com.berkay.ieltsapp.service.WordService;
import org.antlr.v4.runtime.atn.SemanticContext;
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

public class WordServiceTest {
    @Mock
    private WordRepository repository;// servicenin bağlı olduğu sınıvı taklit eder
    @InjectMocks// repo ve service arasındaki bağlantıların taklit edilmesini sağlar
    private WordService service;
    @Test
    void shouldReturnWordWhenIdExist(){
        WordList list =new WordList(1l,"kırmızı",
                "A1"," ı like red","red");
        when(repository.findById(1l)).thenReturn(Optional.of(list));
        WordList result=service.getWordById(1l);
        assertThat(result.getWord()).isEqualTo("red");
        /* assert ksımında kelimeinin beklenen ile aynı olup olmadığını test edecek eğer
         beklenen ile aynı değilse AssertionError atacak */
    }
    @Test//test yaparken bunu eklememk zorundayım
    void shouldThrowExceptionWhenIdNotExist(){
        when(repository.findById(99l)).thenReturn(Optional.empty());
        assertThrows(RuntimeException.class,()-> service.getWordById(99l));
    }
    @Test
    void shouldAddNewWord(){
        WordList word=new WordList(62l,"acı","A2","","pain");
        when(repository.save(word)).thenReturn(word);
        WordList result=service.addWord(word);
        assertThat(result.getWord()).isEqualTo("pain");
        assertThat(result.getMeaning()).isEqualTo("acı");
    }
    @Test
    void shouldDeleteWordWhenIdExist(){
        WordList word=new WordList(23l,"uçak","A2","","plane");
        when(repository.findById(23L)).thenReturn(Optional.of(word));
        service.deleteWord(23l);
        verify(repository).delete(word);

    }

}
