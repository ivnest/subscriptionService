package com.adidas.emailService.Services.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adidas.emailService.Entity.NewsletterEntity;
import com.adidas.emailService.Entity.SubscriptionEntity;
import com.adidas.emailService.Repositories.NewsletterRepository;
import com.adidas.emailService.Repositories.SubscriptionRepository;
import com.adidas.emailService.Repositories.UserRepository;
import com.adidas.emailService.Services.EmailService;

@Service
public class EmailServiceImpl implements EmailService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	NewsletterRepository newsletterRepository;

	@Autowired
	SubscriptionRepository subscriptionRepository;

	@Override
	public void sendNewsletter(long newsletterId) {
		List<SubscriptionEntity> subscriptionsByNewsletterId = subscriptionRepository.findByIdNewsletter(newsletterId);
		List<String> recipients = new ArrayList<>();
		subscriptionsByNewsletterId.forEach(subscriptionEntity -> {
			recipients.add(userRepository.findById(subscriptionEntity.getIdClient()).get().getEmail());
		});
		NewsletterEntity newsletter = newsletterRepository.findById(newsletterId).get();

		// Now we have al necessary information to send email (I have stoped here
		// because it's just only a mock).
	}
}
