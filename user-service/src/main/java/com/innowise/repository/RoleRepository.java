package com.innowise.repository;

import com.innowise.model.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Long> {  // ← RoleEntity вместо RoleRepository
    Optional<RoleEntity> findByName(String name);  // ← RoleEntity вместо RoleRepository
}