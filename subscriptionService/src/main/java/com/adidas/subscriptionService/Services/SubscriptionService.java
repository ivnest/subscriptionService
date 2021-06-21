package com.adidas.subscriptionService.Services;

import com.adidas.subscriptionService.Dto.SubscriptionInfoDto;
import com.adidas.subscriptionService.Dto.UserDto;

public interface SubscriptionService {

	/**
	 * return the list of all subscriptions of a client (and indicates if client is
	 *         subscribed or not)
	 * @param clientId
	 * @return SubscriptionInfoDto
	 */
	SubscriptionInfoDto listAllSubscription(String clientId);

	/**
	 * return one client subscription information
	 * @param subscriptionId
	 * @param clientId
	 * @return SubscriptionInfoDto
	 */
	SubscriptionInfoDto getSubscription(String subscriptionId, String clientId);

	/**
	 * A client subscribes to a newsletter
	 * @param subscriptionId
	 * @param clientId
	 * @return UserDto
	 */
	UserDto createSubscription(String subscriptionId, String clientId);

	/**
	 * A client unsubscribes to a newsletter
	 * @param subscriptionId
	 * @param clientId
	 * @return UserDto
	 */
	UserDto deleteSubscription(String subscriptionId, String clientId);
	
}
