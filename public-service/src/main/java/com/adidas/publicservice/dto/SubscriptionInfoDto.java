package com.adidas.publicservice.dto;

import java.util.List;

import lombok.Data;

@Data
public class SubscriptionInfoDto {

	public SubscriptionInfoDto() {

	}

	private String email;
	private String firstName;
	private String gender;
	private String dateOfBirth;
	private List<NewsLetterInfoDto> newsletterInfo;
}
