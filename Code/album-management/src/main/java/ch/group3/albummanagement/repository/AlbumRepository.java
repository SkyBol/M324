package ch.group3.albummanagement.repository;

import ch.group3.albummanagement.model.Album;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumRepository extends JpaRepository<Album, Long> {
}
