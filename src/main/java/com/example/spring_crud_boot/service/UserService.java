package com.example.spring_crud_boot.service;



import com.example.spring_crud_boot.model.User;

import java.util.List;

public interface UserService {
    List<User> allUser();

    void add(User user);

    void remove(long id);

    void edit(User user);

    User getById(long id);

    User getUserByUsername(String name);
}
