package com.adidas.subscriptionService.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adidas.subscriptionService.Entity.SubscriptionEntity;

public interface SubscriptionRepository extends JpaRepository<SubscriptionEntity, Long> {

	Optional<SubscriptionEntity> findByIdClientAndIdNewsletter(Long idClient, String idNewsletter);

	void deleteByIdClientAndIdNewsletter(Long idClient, String idNewsletter);

	boolean existsByIdClientAndIdNewsletter(Long idClient, String idNewsletter);
}