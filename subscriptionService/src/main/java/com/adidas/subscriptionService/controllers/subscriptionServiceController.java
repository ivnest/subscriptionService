package com.adidas.subscriptionService.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adidas.subscriptionService.Dto.SubscriptionInfoDto;
import com.adidas.subscriptionService.Dto.UserDto;
import com.adidas.subscriptionService.Services.SubscriptionService;

@RestController
@RequestMapping("/subscriptions")
@CrossOrigin("*")
public class subscriptionServiceController {

	@Autowired
	SubscriptionService subscriptionService;

	@GetMapping("/client/{clientId}")
	public ResponseEntity<SubscriptionInfoDto> listSubscriptions(@PathVariable String clientId) {
		return new ResponseEntity<SubscriptionInfoDto>(subscriptionService.listAllSubscription(clientId),
				HttpStatus.OK);
	}

	@GetMapping("subscription/{subscriptionId}/client/{clientId}")
	public ResponseEntity<SubscriptionInfoDto> getSubscription(@PathVariable String subscriptionId,
			@PathVariable String clientId) {
		return new ResponseEntity<SubscriptionInfoDto>(subscriptionService.getSubscription(subscriptionId, clientId),
				HttpStatus.OK);
	}

	@PostMapping("subscription/{subscriptionId}/client/{clientId}")
	public ResponseEntity<UserDto> createSubscription(@PathVariable String subscriptionId,
			@PathVariable String clientId) {
		return new ResponseEntity<UserDto>(subscriptionService.createSubscription(subscriptionId, clientId),
				HttpStatus.OK);
	}

	@DeleteMapping("subscription/{subscriptionId}/client/{clientId}")
	public ResponseEntity<UserDto> deleteSubscription(@PathVariable String subscriptionId,
			@PathVariable String clientId) {
		return new ResponseEntity<UserDto>(subscriptionService.deleteSubscription(subscriptionId, clientId),
				HttpStatus.OK);

	}
}
