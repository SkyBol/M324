package ch.group3.albummanagement.model;

import ch.group3.albummanagement.AlbumStubs;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Locale;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AlbumTest {

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
    public void testAlbumTitleNotBlank() {
        AlbumDTO band = AlbumStubs.validAlbum();
        band.setTitle("");

        Set<ConstraintViolation<AlbumDTO>> violations = validator.validate(band);
        assertEquals(1, violations.size());
        assertEquals("must not be blank", violations.iterator().next().getMessage());
    }

    @Test
    public void testAlbumLabelNotBlank() {
        AlbumDTO band = AlbumStubs.validAlbum();
        band.setLabel("");

        Set<ConstraintViolation<AlbumDTO>> violations = validator.validate(band);
        assertEquals(1, violations.size());
        assertEquals("must not be blank", violations.iterator().next().getMessage());
    }

    @Test
    public void testAlbumReleaseDateNotNull() {
        AlbumDTO band = AlbumStubs.validAlbum();
        band.setReleaseDate(null);

        Set<ConstraintViolation<AlbumDTO>> violations = validator.validate(band);
        assertEquals(1, violations.size());
        assertEquals("must not be null", violations.iterator().next().getMessage());
    }

    @Test
    public void testAlbumPriceMinimum() {
        AlbumDTO band = AlbumStubs.validAlbum();
        band.setPrice(BigDecimal.valueOf(0));

        Set<ConstraintViolation<AlbumDTO>> violations = validator.validate(band);
        assertEquals(1, violations.size());
        assertEquals("must be greater than or equal to 1", violations.iterator().next().getMessage());
    }

    @Test
    public void testValidAlbum() {
        AlbumDTO band = AlbumStubs.validAlbum();

        Set<ConstraintViolation<AlbumDTO>> violations = validator.validate(band);
        assertTrue(violations.isEmpty());
    }
}
