package com.ita.u1.skomorokhova.spring_boot.service;

import com.ita.u1.skomorokhova.spring_boot.model.UserEntity;

import java.util.List;

public interface UserService {
    public List<UserEntity> findAll();

    public UserEntity findById(Long id);

    public void save(UserEntity userEntity);

    public void deleteById(int id);
}
