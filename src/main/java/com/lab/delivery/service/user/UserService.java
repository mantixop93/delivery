package com.lab.delivery.service.user;

import com.lab.delivery.domain.user.User;

import java.util.List;

/**
 * Created by Mantixop on 3/2/16.
 */
public interface UserService {

    User registerNewUserAccount(User user);
    List<User> findAll();
    User findByEmail(String email);
    User updateUser(User user);
}
