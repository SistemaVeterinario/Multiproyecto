package com.poli.serviceuser.repository;

import com.poli.serviceuser.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {
}
