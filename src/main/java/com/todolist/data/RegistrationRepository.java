package com.todolist.data;

import com.todolist.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistrationRepository extends JpaRepository<User, Integer> {
    public User findByEmail(String email);
    public User findByEmailAndPwHash(String email, String pwHash);
}
