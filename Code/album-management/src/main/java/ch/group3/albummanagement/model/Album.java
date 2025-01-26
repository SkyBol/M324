package ch.group3.albummanagement.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Setter
@Getter
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long albumId;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private long band;

    @Column(nullable = false)
    private LocalDate releaseDate;

    @Column(nullable = false)
    private String label;

    @Column(nullable = false)
    private BigDecimal price;
}
