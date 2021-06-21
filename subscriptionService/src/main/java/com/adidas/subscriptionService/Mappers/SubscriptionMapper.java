package com.adidas.subscriptionService.Mappers;

import java.util.List;

import org.springframework.stereotype.Component;

import com.adidas.subscriptionService.Dto.NewsLetterInfoDto;
import com.adidas.subscriptionService.Dto.SubscriptionInfoDto;
import com.adidas.subscriptionService.Entity.SubscriptionEntity;
import com.adidas.subscriptionService.Entity.UserEntity;

@Component
public class SubscriptionMapper {

	public void createNewsletterInfoDto(List<NewsLetterInfoDto> newsLetterInfoDto, String idNewsletter,
			boolean allowed) {
		newsLetterInfoDto.add(new NewsLetterInfoDto(allowed, idNewsletter));
	}

	public SubscriptionInfoDto createSubscriptionInfoDto(List<NewsLetterInfoDto> newsLetterInfoDto,
			UserEntity userEntity) {
		return new SubscriptionInfoDto(userEntity.getEmail(), userEntity.getFirstName(), userEntity.getGender(),
				userEntity.getDateOfBirth(), newsLetterInfoDto);
	}

	public SubscriptionEntity createSubscriptionEntity(String subscriptionId, String idClient) {
		return new SubscriptionEntity(Long.valueOf(idClient), subscriptionId);
	}

}
