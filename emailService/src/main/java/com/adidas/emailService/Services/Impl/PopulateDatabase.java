package com.adidas.emailService.Services.Impl;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.adidas.emailService.Entity.NewsletterEntity;
import com.adidas.emailService.Entity.UserEntity;
import com.adidas.emailService.Repositories.NewsletterRepository;
import com.adidas.emailService.Repositories.SubscriptionRepository;
import com.adidas.emailService.Repositories.UserRepository;

@Service
public class PopulateDatabase {

	@Autowired
	UserRepository userRepository;

	@Autowired
	NewsletterRepository newsletterRepository;

	@Autowired
	SubscriptionRepository subscriptionRepository;

	public PopulateDatabase() {

	}

	@PostConstruct
	@Transactional
	public void fillData() {

		UserEntity user1 = new UserEntity(1L,"user1@email.com", "Esteban", "M", "16/10/1995");
		UserEntity user2 = new UserEntity(2L,"user2@email.com", "Sanchez", "F", "16/10/2000");

		userRepository.save(user1);
		userRepository.save(user2);

		NewsletterEntity newsletterEntity1 = new NewsletterEntity(1L,"Winter campaing", "50% discount in sport wear","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.");
		NewsletterEntity newsletterEntity2 = new NewsletterEntity(2L,"Summer campaing", "40% discount in shirts", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.");
		NewsletterEntity newsletterEntity3 = new NewsletterEntity(3L,"Summer campaing", "New Summer Collection", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.");

		newsletterRepository.save(newsletterEntity1);
		newsletterRepository.save(newsletterEntity2);
		newsletterRepository.save(newsletterEntity3);

	}
}
