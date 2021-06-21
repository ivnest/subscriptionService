package com.adidas.emailService.Dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SubscriptionInfoDto {
	private String email;
	private String firstName;
	private String gender;
	private String dateOfBirth;
	private List<NewsLetterInfoDto> newsletterInfo;
}
