package com.example.spring_crud_boot.service;

import com.example.spring_crud_boot.model.Role;

import java.util.List;

public interface RoleService {

    List<Role> getAllRoles();

    Role getRole(String role);
}
