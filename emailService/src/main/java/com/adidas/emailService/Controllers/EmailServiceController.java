package com.adidas.emailService.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.adidas.emailService.Dto.ResponseDto;
import com.adidas.emailService.Services.EmailService;

@Controller
@RequestMapping("/email")
public class EmailServiceController {

	@Autowired
	EmailService emailService;

	@PostMapping("newsletter/{newsletterId}")
	public ResponseEntity<ResponseDto> createSubscription(@PathVariable long newsletterId) {
		emailService.sendNewsletter(newsletterId);
		ResponseDto responseDto = new ResponseDto("Newsletter has been sent succesfully");
		return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
	}

}
