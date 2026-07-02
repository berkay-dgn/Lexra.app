package com.berkay.ieltsapp.RepositoryTest;
import com.berkay.ieltsapp.entity.WordList;
import com.berkay.ieltsapp.repository.WordRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
@DataJpaTest

class WordRepoTest {
    @Autowired
    private WordRepository wordRepo;
    @Test
    void shouldSaveAndFindWordById(){
        WordList word=new WordList(54L,"zor","A1","","hard");
        WordList savedWord=wordRepo.save(word);
        Optional<WordList>result=wordRepo.findById(savedWord.getId(word));
        assertThat(result).isPresent();
        assertThat(result.get().getWord()).isEqualTo("hard");
    }
}
