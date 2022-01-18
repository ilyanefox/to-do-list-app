package com.todolist.data;

import com.todolist.model.Category;
import com.todolist.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RegistrationRepository extends JpaRepository<User, Integer> {
    public User findByEmail(String email);
    public User findByEmailAndPwHash(String email, String pwHash);

}
