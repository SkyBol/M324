package ch.group3.albummanagement.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long albumId;

    @Column(nullable = false, length = 255)
    private String title;

    @Column(nullable = false)
    private long band;

    @Column(nullable = false)
    private LocalDate releaseDate;

    @Column(nullable = false, length = 255)
    private String label;

    @Column(nullable = false)
    private BigDecimal price;
}
