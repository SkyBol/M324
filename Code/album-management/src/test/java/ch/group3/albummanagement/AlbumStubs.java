package ch.group3.albummanagement;

import ch.group3.albummanagement.model.AlbumDTO;

import java.math.BigDecimal;
import java.time.LocalDate;

public class AlbumStubs {
    public static AlbumDTO validAlbum() {
        AlbumDTO album = new AlbumDTO();
        album.setTitle("Valid Album");
        album.setLabel("Valid");
        album.setPrice(BigDecimal.valueOf(12));
        album.setReleaseDate(LocalDate.now());
        return album;
    }
}
