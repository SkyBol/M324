package ch.group3.bandmanagement.controller.response;

import ch.group3.bandmanagement.validation.ValidationError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

	/**
	 *
	 * @param ex the exception thrown during bean validation
	 * @return formatted error response
	 */
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ValidationErrorResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
		List<ValidationError> errors = ex.getBindingResult().getFieldErrors().stream()
				.map(fieldError -> new ValidationError(fieldError.getField(), fieldError.getDefaultMessage()))
				.collect(Collectors.toList());
		ex.getAllErrors();

		ValidationErrorResponse validationErrorResponse = new ValidationErrorResponse();
		validationErrorResponse.setMessage("Validation failed");
		validationErrorResponse.setErrors(errors);
		validationErrorResponse.setStatus(HttpStatus.BAD_REQUEST);

		return new ResponseEntity<>(validationErrorResponse, HttpStatus.BAD_REQUEST);
	}
}
