package com.example.spring_crud_boot;

import com.example.spring_crud_boot.model.Role;
import com.example.spring_crud_boot.model.User;
import com.example.spring_crud_boot.service.RoleService;
import com.example.spring_crud_boot.service.UserService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;

@Component
public class DataInitilizer {

    private final UserService userService;
    private final RoleService roleService;

    public DataInitilizer(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @PostConstruct
    public void getUserTest() {
        Set<Role> roleSet = new HashSet<>();
        roleService.addRole(new Role("ROLE_USER"));
        roleSet.add(roleService.getRole("ROLE_USER"));
        userService.add(new User("user", "userSurname", "userPhoneNumber", "user@email.ru", "user", roleSet));
    }

    @PostConstruct
    public void getAdminTest() {
        Set<Role> roleSet = new HashSet<>();
        roleService.addRole(new Role("ROLE_ADMIN"));
        roleSet.add(roleService.getRole("ROLE_ADMIN"));
        userService.add(new User("admin", "adminSurname", "adminPhoneNumber", "admin@email.ru", "admin", roleSet));
    }
}
