package com.adidas.emailService.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adidas.emailService.Dto.ResponseDto;
import com.adidas.emailService.Services.EmailService;

@RestController
@RequestMapping("/subscriptions")
@CrossOrigin("*")
public class EmailServiceController {

	@Autowired
	EmailService emailService;

	/**
	 * A newsletter is sent to all subscribers
	 * @param newsletterId
	 * @return an ok message
	 */
	@PostMapping("send-newsletter/{newsletterId}")
	public ResponseEntity<ResponseDto> createSubscription(@PathVariable long newsletterId) {
		emailService.sendNewsletter(newsletterId);
		ResponseDto responseDto = new ResponseDto("Newsletter has been sent succesfully");
		return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
	}

}
