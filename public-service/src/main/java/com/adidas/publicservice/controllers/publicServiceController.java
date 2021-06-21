package com.adidas.publicservice.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.adidas.publicservice.dto.ResponseDto;
import com.adidas.publicservice.dto.SubscriptionInfoDto;
import com.adidas.publicservice.dto.UserDto;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/subscriptions")
@CrossOrigin("*")
public class publicServiceController {

	@Autowired
	RestTemplate restTemplate;

	@Value("${subscriptionService.host}")
	private String subscriptionServiceHost;

	@Value("${emailService.host}")
	private String emailServiceHost;

	@Autowired
	ObjectMapper objectMapper;

	/**
	 * 
	 * @param clientId
	 * @return the list of all subscriptions of a client (and indicates if client is
	 *         subscribed or not)
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws RestClientException
	 * @throws IOException
	 */
	@GetMapping("/client/{clientId}")
	public ResponseEntity<SubscriptionInfoDto> listSubscriptions(@PathVariable String clientId)
			throws JsonParseException, JsonMappingException, RestClientException, IOException {

		return restTemplate.exchange("http://" + subscriptionServiceHost + "/subscriptions/client/" + clientId,

				HttpMethod.GET, null, new ParameterizedTypeReference<SubscriptionInfoDto>() {
				});
	}

	/**
	 * 
	 * @param subscriptionId
	 * @param clientId
	 * @return one client subscription information
	 */
	@GetMapping("subscription/{subscriptionId}/client/{clientId}")
	public ResponseEntity<SubscriptionInfoDto> getSubscription(@PathVariable String subscriptionId,
			@PathVariable String clientId) {

		return restTemplate
				.exchange(
						"http://" + subscriptionServiceHost + "/subscriptions/subscription/" + subscriptionId
								+ "/client/" + clientId,
						HttpMethod.GET, null, new ParameterizedTypeReference<SubscriptionInfoDto>() {
						});
	}

	/**
	 * A client subscribes to a newsletter
	 * @param subscriptionId
	 * @param clientId
	 * @return clientId
	 */
	@PostMapping("subscription/{subscriptionId}/client/{clientId}")
	public ResponseEntity<UserDto> createSubscription(@PathVariable String subscriptionId,
			@PathVariable String clientId) {

		return restTemplate
				.exchange(
						"http://" + subscriptionServiceHost + "/subscriptions/subscription/" + subscriptionId
								+ "/client/" + clientId,
						HttpMethod.POST, null, new ParameterizedTypeReference<UserDto>() {
						});
	}

	/**
	 * A client unsubscribes to a newsletter
	 * @param subscriptionId
	 * @param clientId
	 * @return clientId
	 */
	@DeleteMapping("subscription/{subscriptionId}/client/{clientId}")
	public ResponseEntity<UserDto> deleteSubscription(@PathVariable String subscriptionId,
			@PathVariable String clientId) {
		return restTemplate
				.exchange(
						"http://" + subscriptionServiceHost + "/subscriptions/subscription/" + subscriptionId
								+ "/client/" + clientId,
						HttpMethod.DELETE, null, new ParameterizedTypeReference<UserDto>() {
						});
	}

	/**
	 * A newsletter is sent to all subscribers
	 * @param newsletterId
	 * @return an ok message
	 */
	@PostMapping("send-newsletter/{newsletterId}")
	public ResponseEntity<ResponseDto> sendNewsletter(@PathVariable String newsletterId) {
		return restTemplate.exchange("http://" + emailServiceHost + "/subscriptions/send-newsletter/" + newsletterId,
				HttpMethod.POST, null, new ParameterizedTypeReference<ResponseDto>() {
				});
	}
}
