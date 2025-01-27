package ch.group3.albummanagement.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
public class ApplicationConfiguration {

	@Value("${band.url}")
	private String bandUrl;
}
