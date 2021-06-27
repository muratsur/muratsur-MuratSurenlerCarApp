package com.murat.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.murat.auth.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{
}
