package com.adidas.subscriptionService.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adidas.subscriptionService.Entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

	Optional<UserEntity> findById(Long valueOf);

}