package ch.group3.bandmanagement.repository;

import ch.group3.bandmanagement.model.Band;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BandRepository extends JpaRepository<Band, Long> {
}
