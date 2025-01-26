package ch.group3.albummanagement.validation.exception;

public class BandRequestFailedException extends AlbumValidationException {
	public BandRequestFailedException(Throwable cause) {
		super("Band request failed with an exception", cause);
	}
}
