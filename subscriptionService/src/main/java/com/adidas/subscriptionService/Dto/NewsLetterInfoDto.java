package com.adidas.subscriptionService.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class NewsLetterInfoDto {
	private boolean allowedNewsletter;
	private String newsletterId;
}
