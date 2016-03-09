package com.lab.delivery.service.user;

import com.lab.delivery.domain.user.User;
import com.lab.delivery.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Mantixop on 1/28/16.
 */

@Service
public class SimpleUserService implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    @Override
    public User registerNewUserAccount(User user) {
        if (emailExist(user.getEmail())) {
            return null;
        }
        user.addRole(userRepository.findRoleByName("ROLE_USER"));
        return userRepository.save(user);
    }

    private boolean emailExist(String email) {
        User user = userRepository.findByEmail(email);
        if (user != null) {
            return true;
        }
        return false;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Transactional
    @Override
    public User updateUser(User user) {
        return userRepository.save(user);
    }
}
