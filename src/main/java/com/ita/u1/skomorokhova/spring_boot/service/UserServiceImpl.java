package com.ita.u1.skomorokhova.spring_boot.service;

import com.ita.u1.skomorokhova.spring_boot.dao.UserRepository;
import com.ita.u1.skomorokhova.spring_boot.model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserEntity> findAll() {
        return userRepository.findAll();
    }

    @Override
    public UserEntity findById(Long id) {
        Optional<UserEntity> result = userRepository.findById(id);

        UserEntity userEntity = null;

        if (result.isPresent()) {
            userEntity = result.get();
        }
        else {
            throw new RuntimeException("Did not find employee id - " + id);
        }

        return userEntity;
    }

    @Override
    public void save(UserEntity userEntity) {

    }

    @Override
    public void deleteById(int id) {

    }
}
