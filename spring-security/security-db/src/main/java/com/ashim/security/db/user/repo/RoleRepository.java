package com.ashim.security.db.user.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ashim.security.db.user.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

}
