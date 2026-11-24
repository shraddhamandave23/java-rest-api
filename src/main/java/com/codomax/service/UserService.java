
package com.codomax.service;

import com.codomax.entity.User;
import com.codomax.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public User updateUser(Long id, User user) {
        User existing = userRepository.findById(id)
                .orElseThrow(() ->
                    new RuntimeException("User not found"));

        existing.setName(user.getName());
        existing.setEmail(user.getEmail());
        existing.setPhone(user.getPhone());

        return userRepository.save(existing);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
