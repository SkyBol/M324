package ch.group3.albummanagement.validation.exception;

public abstract class AlbumValidationException extends RuntimeException {
	public AlbumValidationException(String message) {
		super(message);
	}

	public AlbumValidationException(String message, Throwable cause) {
		super(message, cause);
	}
}
