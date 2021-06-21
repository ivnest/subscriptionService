package com.adidas.emailService.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data
@AllArgsConstructor
public class SubscriptionEntity {

	public SubscriptionEntity() {

	}

	public SubscriptionEntity(long idClient, String idNewsletter) {
		this.idClient = idClient;
		this.idNewsletter = idNewsletter;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false)
	private long idClient;

	@Column(nullable = false)
	private String idNewsletter;

}