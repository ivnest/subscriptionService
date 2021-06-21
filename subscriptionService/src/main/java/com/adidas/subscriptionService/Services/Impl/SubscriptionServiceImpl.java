package com.adidas.subscriptionService.Services.Impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adidas.subscriptionService.Dto.NewsLetterInfoDto;
import com.adidas.subscriptionService.Dto.SubscriptionInfoDto;
import com.adidas.subscriptionService.Dto.UserDto;
import com.adidas.subscriptionService.Entity.NewsletterEntity;
import com.adidas.subscriptionService.Entity.SubscriptionEntity;
import com.adidas.subscriptionService.Mappers.SubscriptionMapper;
import com.adidas.subscriptionService.Repository.NewsletterRepository;
import com.adidas.subscriptionService.Repository.SubscriptionRepository;
import com.adidas.subscriptionService.Repository.UserRepository;
import com.adidas.subscriptionService.Services.SubscriptionService;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	NewsletterRepository newsletterRepository;

	@Autowired
	SubscriptionRepository subscriptionRepository;

	@Autowired
	SubscriptionMapper subscriptionMapper;

	/**
	 * return the list of all subscriptions of a client (and indicates if client is
	 * subscribed or not)
	 */
	public SubscriptionInfoDto listAllSubscription(String idClient) {
		// Get all newsletters
		List<NewsletterEntity> allNewsletter = newsletterRepository.findAll();
		
		// Filter by distinct idNewsletter (clients are subscribed to an idNewsletter)
		// which is like a group (for example only summer collection newsletters but not
		// winter collection newsletters). It could be a lot of newsletter with the same
		// idNewsletter
		Set<String> set = new HashSet<>();
		List<NewsletterEntity> newsletterWithDistinctIdNewsletter = allNewsletter.stream()
				.filter(e -> set.add(e.getIdNewsletter())).collect(Collectors.toList());

		// Create subscriptionInfoDto object
		List<NewsLetterInfoDto> newsLetterInfoDto = new ArrayList<>();
		newsletterWithDistinctIdNewsletter.forEach(newsletterEntity -> {
			Optional<SubscriptionEntity> optionalSubscription = subscriptionRepository
					.findByIdClientAndIdNewsletter(Long.valueOf(idClient), String.valueOf(newsletterEntity.getId()));
			if (optionalSubscription.isPresent()) {
				subscriptionMapper.createNewsletterInfoDto(newsLetterInfoDto, newsletterEntity.getIdNewsletter(), true);
			} else {
				subscriptionMapper.createNewsletterInfoDto(newsLetterInfoDto, newsletterEntity.getIdNewsletter(),
						false);
			}
		});
		return subscriptionMapper.createSubscriptionInfoDto(newsLetterInfoDto,
				userRepository.findById(Long.valueOf(idClient)).get());
	}

	/**
	 * return one client subscription information
	 */
	public SubscriptionInfoDto getSubscription(String subscriptionId, String idClient) {
		Optional<SubscriptionEntity> optionalSubscription = subscriptionRepository
				.findByIdClientAndIdNewsletter(Long.valueOf(idClient), subscriptionId);
		NewsletterEntity newsletterEntity = newsletterRepository.findById(Long.valueOf(subscriptionId)).get();
		List<NewsLetterInfoDto> newsLetterInfoDto = new ArrayList<>();
		if (optionalSubscription.isPresent()) {
			subscriptionMapper.createNewsletterInfoDto(newsLetterInfoDto, newsletterEntity.getIdNewsletter(), true);
		} else {
			subscriptionMapper.createNewsletterInfoDto(newsLetterInfoDto, newsletterEntity.getIdNewsletter(), false);
		}
		return subscriptionMapper.createSubscriptionInfoDto(newsLetterInfoDto,
				userRepository.findById(Long.valueOf(idClient)).get());
	}

	/**
	 * A client subscribes to a newsletter
	 */
	public UserDto createSubscription(String subscriptionId, String idClient) {
		subscriptionRepository.save(subscriptionMapper.createSubscriptionEntity(subscriptionId, idClient));
		return new UserDto(idClient);
	}

	/**
	 * A client unsubscribes to a newsletter
	 */
	@Transactional
	public UserDto deleteSubscription(String idNewsletter, String idClient) {
		if (subscriptionRepository.existsByIdClientAndIdNewsletter(Long.valueOf(idClient), idNewsletter)) {
			subscriptionRepository.deleteByIdClientAndIdNewsletter(Long.valueOf(idClient), idNewsletter);
		}
		return new UserDto(idClient);
	}
}
