package com.poli.serviceuser.service;

import com.poli.serviceuser.entities.User;
import com.poli.serviceuser.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(User user) {
        userRepository.delete(user);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public List<User> findAll() {
        return  userRepository.findAll();

    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }
}
