package ch.group3.bandmanagement.validation;

import ch.group3.bandmanagement.DummyConstraintValidatorContext;
import ch.group3.bandmanagement.model.Band;
import jakarta.validation.ConstraintValidatorContext;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.LocalDate;
import java.util.stream.Stream;

import static ch.group3.bandmanagement.BandStubs.bandWithDates;
import static ch.group3.bandmanagement.BandStubs.validBandWithDissolutionDate;
import static ch.group3.bandmanagement.BandStubs.validBandWithOutDissolutionDate;
import static java.time.LocalDate.now;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

class ValidDissolutionDateValidatorTest {

	ValidDissolutionDateValidator validator;

	@BeforeEach
	void setUp() {
		validator = new ValidDissolutionDateValidator();
	}

	/**
	 * Tests the dissolution date validation with some valid Bands.
	 *
	 * @param band with a valid date combination
	 */
	@ParameterizedTest
	@MethodSource(value = "provideBandsWithValidDissolutionDates")
	void shouldBeValidDissolutionDate(Band band) {
		boolean isValid = validator.isValid(band, mock(ConstraintValidatorContext.class));

		assertTrue(isValid);
	}

	/**
	 * Tests the dissolution date validation with some invalid Bands.
	 *
	 * @param band with a invalid date combination
	 */
	@ParameterizedTest
	@MethodSource(value = "provideBandsWithInValidDissolutionDates")
	void shouldBeInValidDissolutionDate(Band band) {
		DummyConstraintValidatorContext context = new DummyConstraintValidatorContext();

		boolean isValid = validator.isValid(band, context);

		assertFalse(isValid);
	}

	private static Stream<Band> provideBandsWithValidDissolutionDates() {
		return Stream.of(validBandWithOutDissolutionDate(),
				validBandWithDissolutionDate(now()),
				bandWithDates(dateOfYear(2000), dateOfYear(2000)));
	}

	private static Stream<Band> provideBandsWithInValidDissolutionDates() {
		return Stream.of(bandWithDates(dateOfYear(2000), dateOfYear(1999)));
	}

	private static LocalDate dateOfYear(int year) {
		return LocalDate.of(year, 1, 1);
	}
}
