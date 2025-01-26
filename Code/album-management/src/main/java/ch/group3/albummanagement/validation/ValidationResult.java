package ch.group3.albummanagement.validation;

import ch.group3.albummanagement.model.AlbumDTO;
import ch.group3.albummanagement.validation.exception.AlbumValidationException;
import lombok.Getter;

import java.util.Optional;

import static org.springframework.util.Assert.isTrue;

@Getter
public final class ValidationResult {

	private final Optional<AlbumValidationException> exception;
	private final Optional<AlbumDTO> album;

	private ValidationResult(Optional<AlbumValidationException> exception, Optional<AlbumDTO> album) {
		this.exception = exception;
		this.album = album;
	}

	public static ValidationResult error(AlbumValidationException exception) {
		return new ValidationResult(Optional.of(exception), Optional.empty());
	}

	public static ValidationResult success(AlbumDTO album) {
		return new ValidationResult(Optional.empty(), Optional.of(album));
	}

	public AlbumDTO getOrThrow() {
		if (exception.isEmpty() && album.isPresent()) {
			return album.get();
		}
		isTrue(exception.isPresent(), "Album validation failed");
		throw exception.get();
	}
}
