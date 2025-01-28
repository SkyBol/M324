package ch.group3.albummanagement.controller.response;

import lombok.Getter;

@Getter
public class GeneralError implements GenericError {

	private final String errorMessage;

	public GeneralError(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	@Getter
	public static class GeneralErrorWithCause extends GeneralError {

		private final Throwable cause;

		public GeneralErrorWithCause(String errorMessage, Throwable cause) {
			super(errorMessage);
			this.cause = cause;
		}
	}
}
