package com.adidas.subscriptionService.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data
@AllArgsConstructor
public class NewsletterEntity {

	public NewsletterEntity() {

	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false)
	private String idNewsletter;

	@Column(nullable = false)
	private String newsletterTitle;

	@Column(nullable = false)
	@Lob
	private String newsletterContent;

}
