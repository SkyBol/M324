package ch.group3.bandmanagement.validation;

import ch.group3.bandmanagement.model.Band;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidDissolutionDateValidator implements ConstraintValidator<ValidDissolutionDate, Band> {
	@Override
	public boolean isValid(Band band, ConstraintValidatorContext constraintValidatorContext) {
		if (band.getDissolutionDate() == null) {
			return true;
		}

		if (band.getDissolutionDate().isBefore(band.getFoundingDate())) {
			constraintValidatorContext.disableDefaultConstraintViolation();
			constraintValidatorContext.buildConstraintViolationWithTemplate(constraintValidatorContext.getDefaultConstraintMessageTemplate())
					.addPropertyNode("dissolutionDate")
					.addConstraintViolation();

			return false;
		}

		return true;
	}
}
