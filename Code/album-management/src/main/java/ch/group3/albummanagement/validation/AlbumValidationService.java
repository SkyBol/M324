package ch.group3.albummanagement.validation;

import ch.group3.albummanagement.configuration.ApplicationConfiguration;
import ch.group3.albummanagement.model.AlbumDTO;
import ch.group3.albummanagement.model.BandDTO;
import ch.group3.albummanagement.validation.exception.AlbumValidationException;
import ch.group3.albummanagement.validation.exception.BandNotFoundException;
import ch.group3.albummanagement.validation.exception.BandRequestFailedException;
import ch.group3.albummanagement.validation.exception.InvalidAlbumDataException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static ch.group3.albummanagement.validation.ValidationResult.error;
import static ch.group3.albummanagement.validation.ValidationResult.success;

@Service
public class AlbumValidationService {

	private final ApplicationConfiguration applicationConfiguration;
	private final ObjectMapper objectMapper;

	@Autowired
	public AlbumValidationService(ApplicationConfiguration applicationConfiguration, ObjectMapper objectMapper1) {
		this.applicationConfiguration = applicationConfiguration;
		this.objectMapper = objectMapper1;
	}

	public ValidationResult validate(AlbumDTO album) {
		try {
			BandDTO band = getBandDTO(album.getBand());
			if (!isValidAlbumDate(album, band)) {
				return error(new InvalidAlbumDataException("Release date of album " + album.getTitle() + " must be after band founding date"));
			}
			return success(album);
		} catch (AlbumValidationException e) {
			return error(e);
		}
	}

	private BandDTO getBandDTO(long bandId) throws AlbumValidationException {
		try (HttpClient client = HttpClient.newHttpClient()) {
			HttpRequest request = HttpRequest.newBuilder()
					.uri(new URI(applicationConfiguration.getBandUrl() + "/bands/" + bandId))
					.build();
			HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
			if (response.statusCode() == 404) {
				throw new BandNotFoundException("Band with id " + bandId + " not found");
			}
			return objectMapper.readValue(response.body(), BandDTO.class);
		} catch (InterruptedException | IOException | URISyntaxException e) {
			throw new BandRequestFailedException(e.getCause());
		}
	}

	private boolean isValidAlbumDate(AlbumDTO album, BandDTO band) {
		return album.getReleaseDate().isAfter(band.getFoundingDate());
	}
}
