package com.fundoo.notes.service;

import com.fundoo.notes.dto.RegisterRequest;
import com.fundoo.notes.entity.User;
import com.fundoo.notes.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    @Override
    public String register(RegisterRequest request) {

        // check if email already exists
        repository.findByEmail(request.getEmail())
                .ifPresent(user -> {
                    throw new RuntimeException("Email already registered");
                });

        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword()); // plain for now (BCrypt in UC5)

        repository.save(user);

        return "User Registered Successfully";
    }
}