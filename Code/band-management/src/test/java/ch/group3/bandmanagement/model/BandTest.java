package ch.group3.bandmanagement.model;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Locale;
import java.util.Set;

import static ch.group3.bandmanagement.BandStubs.validBandWithOutDissolutionDate;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BandTest {

	private Validator validator;

	@BeforeAll
	static void setLang() {
		Locale.setDefault(Locale.ENGLISH);
	}

	@BeforeEach
	public void setup() {
		validator = Validation.buildDefaultValidatorFactory().getValidator();
	}

	@Test
	public void testBandNameNotBlank() {
		Band band = validBandWithOutDissolutionDate();
		band.setBandName("");

		Set<ConstraintViolation<Band>> violations = validator.validate(band);
		assertEquals(1, violations.size());
		assertEquals("must not be blank", violations.iterator().next().getMessage());
	}

	@Test
	public void testGenreNotBlank() {
		Band band = validBandWithOutDissolutionDate();
		band.setGenre("");
		Set<ConstraintViolation<Band>> violations = validator.validate(band);
		assertEquals(1, violations.size());
		assertEquals("must not be blank", violations.iterator().next().getMessage());
	}


	@Test
	public void testBandMembersMinValue() {
		Band band = validBandWithOutDissolutionDate();
		band.setBandMembers(0);

		Set<ConstraintViolation<Band>> violations = validator.validate(band);
		assertEquals(1, violations.size());
		assertEquals("must be greater than or equal to 1", violations.iterator().next().getMessage());
	}

	@Test
	public void testDissolutionDateNull() {
		Band band = validBandWithOutDissolutionDate();
		band.setDissolutionDate(null);

		Set<ConstraintViolation<Band>> violations = validator.validate(band);
		assertTrue(violations.isEmpty());
	}

	@Test
	public void testDissolutionDateBeforeFoundingDate() {
		Band band = validBandWithOutDissolutionDate();
		band.setDissolutionDate(LocalDate.of(1999, 1, 1));
		band.setFoundingDate(LocalDate.of(2000, 1, 1));

		Set<ConstraintViolation<Band>> violations = validator.validate(band);
		assertEquals(1, violations.size());
		assertEquals("dissolution date must be before the founding date!", violations.iterator().next()
				.getMessage());
	}

	@Test
	public void testValidBand() {
		Band band = validBandWithOutDissolutionDate();

		Set<ConstraintViolation<Band>> violations = validator.validate(band);
		assertTrue(violations.isEmpty());
	}
}
