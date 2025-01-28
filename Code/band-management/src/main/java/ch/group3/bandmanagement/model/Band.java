package ch.group3.bandmanagement.model;

import ch.group3.bandmanagement.validation.ValidDissolutionDate;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDate;

@Data
@Entity
@ValidDissolutionDate
public class Band {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "band_id")
    private Long bandId;

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
