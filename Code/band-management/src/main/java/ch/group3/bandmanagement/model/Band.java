package ch.group3.bandmanagement.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Band {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bandId;

    @Column(nullable = false, length = 255)
    private String bandName;

    @Column(nullable = false, length = 255)
    private String genre;

    @Column(nullable = false)
    private LocalDate foundingDate;

    @Column(nullable = false)
    private Integer bandMembers;

    private LocalDate dissolutionDate;

}
