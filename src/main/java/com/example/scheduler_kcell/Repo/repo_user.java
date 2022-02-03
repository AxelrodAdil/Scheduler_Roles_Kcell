package com.example.scheduler_kcell.Repo;

import com.example.scheduler_kcell.Model.model_roles;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface repo_user extends JpaRepository<model_roles, Long> {
    Optional<model_roles> findByEmail(String email);
}