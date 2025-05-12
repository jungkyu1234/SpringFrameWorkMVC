package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserId(Long id) {
        User user = userRepository.findById(id);
        return user;
    }

    @Override
    @Transactional //데이터 생성에 에러가 났을때 데이터베이스가 자동 롤백 해주는 역할
    public User createUser(User user) {

        //이메일 중복에 대한 유효성 검사
        boolean isExistedEmail = false;
        isExistedEmail = userRepository.existsEmail(user.getEmail());

        if (isExistedEmail) {
            throw new RuntimeException("이메일이 존재합니다");
        }

        User newUser = userRepository.save(user);
        return newUser;
    }

    @Override
    public User updateUser(User user) {

            //이메일 중복에 대한 유효성 검사
            boolean isExistedEmail = false;
            isExistedEmail = userRepository.existsEmail(user.getEmail());

            if (isExistedEmail) {
                throw new RuntimeException("이메일이 존재합니다");
            }

            User existedUser = userRepository.update(user);
            return existedUser;
        }


    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User getUserById(Long id) {
        return null;
    }
}
