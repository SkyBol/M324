package ch.group3.albummanagement.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class AlbumDTO {

	@NotNull
	@NotBlank
	private String title;

	@NotNull
	private long band;

	@NotNull
	private LocalDate releaseDate;

	@NotBlank
	@NotNull
	private String label;

	@NotNull
	@Min(1)
	private BigDecimal price;
}
