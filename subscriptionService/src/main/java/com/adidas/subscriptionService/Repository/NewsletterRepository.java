package com.adidas.subscriptionService.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adidas.subscriptionService.Entity.NewsletterEntity;

public interface NewsletterRepository extends JpaRepository<NewsletterEntity, Long> {

	Optional<NewsletterEntity> findById(Long valueOf);
}