package com.adidas.emailService.Services;


public interface EmailService {

	/**
	 * A newsletter is sent to all subscribers
	 * @param newsletterId
	 */
	void sendNewsletter(long newsletterId);
	
}
