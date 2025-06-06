package com.reringuy.support.repositories;

import com.reringuy.support.models.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
  Optional<UserDetails> findByEmail(String email);
}