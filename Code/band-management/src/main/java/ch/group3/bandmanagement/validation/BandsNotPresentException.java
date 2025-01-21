package ch.group3.bandmanagement.validation;

public class BandsNotPresentException extends RuntimeException {
	public BandsNotPresentException(String message) {
		super(message);
	}
}
