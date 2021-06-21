package com.adidas.subscriptionService.Services;

import com.adidas.subscriptionService.Dto.SubscriptionInfoDto;
import com.adidas.subscriptionService.Dto.UserDto;

public interface SubscriptionService {

	SubscriptionInfoDto listAllSubscription(String clientId);

	SubscriptionInfoDto getSubscription(String subscriptionId, String clientId);

	UserDto createSubscription(String subscriptionId, String clientId);

	UserDto deleteSubscription(String subscriptionId, String clientId);
	
}
