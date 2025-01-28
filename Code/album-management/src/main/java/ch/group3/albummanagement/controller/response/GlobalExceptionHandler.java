package ch.group3.albummanagement.controller.response;


import ch.group3.albummanagement.controller.response.ErrorResponse.ErrorResponseBuilder;
import ch.group3.albummanagement.controller.response.GeneralError.GeneralErrorWithCause;
import ch.group3.albummanagement.validation.exception.AlbumValidationException;
import ch.group3.albummanagement.validation.exception.BandRequestFailedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@RestControllerAdvice
public class GlobalExceptionHandler {

	/**
	 * @param ex the exception thrown during bean validation
	 * @return formatted error response
	 */
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
		List<GenericError> errors = ex.getBindingResult().getFieldErrors().stream()
				.map(fieldError -> new ValidationError(fieldError.getField(), fieldError.getDefaultMessage()))
				.collect(Collectors.toList());
		ex.getAllErrors();

		ErrorResponse validationErrorResponse = ErrorResponse.builder()
				.message("Validation failed")
				.errors(errors)
				.status(BAD_REQUEST)
				.build();

		return new ResponseEntity<>(validationErrorResponse, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(AlbumValidationException.class)
	public ResponseEntity<ErrorResponse> handleAlbumValidationException(AlbumValidationException ex) {
		ErrorResponseBuilder response = ErrorResponse.builder()
				.message("Request failed with errors: ")
				.status(BAD_REQUEST);
		if (ex instanceof BandRequestFailedException) {
			response.error(new GeneralErrorWithCause(ex.getMessage(), ex.getCause()));
			return new ResponseEntity<>(response.build(), BAD_REQUEST);
		}
		response.error(new GeneralError(ex.getMessage())).message("Validation failed");
		return new ResponseEntity<>(response.build(), BAD_REQUEST);
	}
}
