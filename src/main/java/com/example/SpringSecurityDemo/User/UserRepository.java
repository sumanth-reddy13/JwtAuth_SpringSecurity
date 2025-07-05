package com.example.SpringSecurityDemo.User;


import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    /*
        1. Optional is a container class introduced in Java 8 to avoid NullPointerException.
        2. In this case, we are finding user based on the user email.
        3. In case, if the user is not present in the database, it returns a null. Using an Optional class will force the user to handle this case.
     */
    Optional<User> findByEmail(String username);
}