package com.adidas.emailService.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adidas.emailService.Entity.NewsletterEntity;

public interface NewsletterRepository extends JpaRepository<NewsletterEntity, Long> {

	Optional<NewsletterEntity> findById(long newsletterId);
}