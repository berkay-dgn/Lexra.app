package com.berkay.ieltsapp.RepositoryTest;
import com.berkay.ieltsapp.entity.*;
import com.berkay.ieltsapp.repository.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.Optional;
@DataJpaTest
public class UserRepoTest {
    @Autowired
    private UserRepo repo;
    @Test
    void shouldFindUserById(){
        AppUser user = new AppUser(100L,"Mail@","ali",4
                ,"A1","1223");
        AppUser savedUser=repo.save(user);
        Optional<AppUser>result=repo.findById(100L);
        assertThat(result.get().getMail()).isEqualTo("Mail@");
    }
}
