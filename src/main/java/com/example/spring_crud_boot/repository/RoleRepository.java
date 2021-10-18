package com.example.spring_crud_boot.repository;

import com.example.spring_crud_boot.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository <Role, Long> {

    Role getRoleByName(String name);
}
