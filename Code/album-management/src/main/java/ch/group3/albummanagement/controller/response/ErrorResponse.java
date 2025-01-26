package ch.group3.albummanagement.controller.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Singular;
import org.springframework.http.HttpStatusCode;

import java.util.List;

@Getter
@Builder
public class ErrorResponse {

	private HttpStatusCode status;
	private String message;
	@Singular
	private List<GenericError> errors;
}
