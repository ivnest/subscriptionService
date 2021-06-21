package com.adidas.emailService.Repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adidas.emailService.Entity.SubscriptionEntity;

public interface SubscriptionRepository extends JpaRepository<SubscriptionEntity, Long> {
	List<SubscriptionEntity> findByIdNewsletter(long newsletterId);
}