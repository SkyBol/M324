package ch.group3.bandmanagement.controller.response;

import ch.group3.bandmanagement.validation.ValidationError;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatusCode;

import java.util.List;

@Getter
@Setter
public class ValidationErrorResponse {

	private HttpStatusCode status;
	private String message;
	private List<ValidationError> errors;

}
