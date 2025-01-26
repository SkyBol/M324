package ch.group3.albummanagement.controller.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ValidationError implements GenericError {
	private String field;
	private String message;
}
