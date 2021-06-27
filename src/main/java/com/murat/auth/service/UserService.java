package com.murat.auth.service;

import com.murat.auth.model.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
