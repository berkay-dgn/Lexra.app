package com.berkay.ieltsapp.repository;
import com.berkay.ieltsapp.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
public interface UserRepo extends JpaRepository<AppUser,Long> {

}
