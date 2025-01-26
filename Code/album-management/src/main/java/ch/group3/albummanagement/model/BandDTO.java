package ch.group3.albummanagement.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;

@Data
public class BandDTO {

	@NotBlank
	@Size(max = 255)
	private String bandName;

	@NotBlank
	@Size(max = 255)
	private String genre;

	@NotNull
	@PastOrPresent
	private LocalDate foundingDate;

	@NotNull
	@Min(value = 1)
	private Integer bandMembers;

	private LocalDate dissolutionDate;

}
