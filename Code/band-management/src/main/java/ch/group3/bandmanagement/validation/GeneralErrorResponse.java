package ch.group3.bandmanagement.validation;

import lombok.Getter;

@Getter
public class GeneralErrorResponse {

	private final String body;

	public GeneralErrorResponse(String body) {
		this.body = body;
	}
}
