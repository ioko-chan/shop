package com.solomennikova.shop.users;

import com.solomennikova.shop.exception.UserExistsException;
import com.solomennikova.shop.rest.dto.User;

import java.util.List;

public interface UserService {
    void createUser(User user) throws UserExistsException;
    User getUser(Long id);
    List<User> getUsers();
}
