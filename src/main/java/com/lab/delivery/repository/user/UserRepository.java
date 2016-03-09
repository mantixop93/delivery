package com.lab.delivery.repository.user;

import com.lab.delivery.domain.user.Role;
import com.lab.delivery.domain.user.User;

import java.util.List;

/**
 * Created by Mantixop on 3/2/16.
 */
public interface UserRepository {
    User save(User user);
    User findByEmail(String email);
    Role findRoleByName(String name);
    List<User> findAll();
}
