package com.adidas.subscriptionService.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adidas.subscriptionService.Entity.NewsletterEntity;

public interface NewsletterRepository extends JpaRepository<NewsletterEntity, Long> {
}