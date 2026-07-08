package com.berkay.ieltsapp.ServiceTest;
import com.berkay.ieltsapp.entity.AppUser;
import com.berkay.ieltsapp.entity.WordList;
import com.berkay.ieltsapp.repository.UserRepo;
import com.berkay.ieltsapp.service.UserService;
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
public class UserServiceTest {
    @Mock
    private UserRepo repo;
    @InjectMocks
    private UserService service;
    @Test
    void shouldFindUserWhenIdExist(){
        AppUser user=new AppUser(34L,"dogan1","can",4,"A1","123");
        when(repo.findById(34L)).thenReturn(Optional.of(user));
        AppUser currentUser =service.findUser(34L);
        assertThat(currentUser.getUserName()).isEqualTo("can");
    }
    @Test
    void shouldAddNewUser(){
        AppUser user =new AppUser(35L,"berk@","berk",3,"B1","1234");
        when(repo.save(user)).thenReturn(user);
        service.newUser(user);
        assertThat(user.getPassword()).isEqualTo("1234");
        assertThat(user.getMail()).isEqualTo("berk@");
    }
    @Test
    void shouldDeleteUserWhenIdExist(){
        AppUser user=new AppUser(36L,"barış@","barış",5,"C1","3456");
        when(repo.findById(36L)).thenReturn(Optional.of(user));
        service.deleteUser(36L);
        verify(repo).delete(user);

    }
    @Test
    void shouldUpdateLimitWhenIDExist(){
        AppUser user=new AppUser(37L,"mail@1","kaan",3,"B1","12345");
        when(repo.findById(37L)).thenReturn(Optional.of(user));
        when(repo.save(user)).thenReturn(user);
        service.updateLimit(37L,5);
        assertThat(user.getDailyLimit()).isEqualTo(5);
        assertThat(user.getId()).isEqualTo(37L);
    }
    @Test
    void shouldChangeUserName(){
        AppUser user=new AppUser(38L,"MAİL@2","serdar",5,"A2","3434");
        when(repo.findById(38L)).thenReturn(Optional.of(user));
        when(repo.save(user)).thenReturn(user);
        service.changeUserName(38L,"mert");
        assertThat(user.getUserName()).isEqualTo("mert");
        assertThat(user.getId()).isEqualTo(38L);
    }
}
