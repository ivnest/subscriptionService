package com.adidas.publicservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class NewsLetterInfoDto {

	public NewsLetterInfoDto() {
		
	}

	private boolean allowedNewsletter;
	private String newsletterId;
}
