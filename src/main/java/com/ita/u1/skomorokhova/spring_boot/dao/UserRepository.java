package com.ita.u1.skomorokhova.spring_boot.dao;

import com.ita.u1.skomorokhova.spring_boot.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findByEmail(String email);
}
