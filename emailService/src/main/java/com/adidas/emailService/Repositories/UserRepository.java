package com.adidas.emailService.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adidas.emailService.Entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

	Optional<UserEntity> findById(long idClient);
}