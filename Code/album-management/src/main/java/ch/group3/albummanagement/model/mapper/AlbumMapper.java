package ch.group3.albummanagement.model.mapper;


import ch.group3.albummanagement.model.Album;
import ch.group3.albummanagement.model.AlbumDTO;
import org.springframework.stereotype.Component;

@Component
public class AlbumMapper {

	public AlbumDTO toDto (Album album) {
		AlbumDTO dto = new AlbumDTO();
		dto.setBand(album.getBand());
		dto.setTitle(album.getTitle());
		dto.setPrice(album.getPrice());
		dto.setReleaseDate(album.getReleaseDate());
		dto.setLabel(album.getLabel());
		return dto;
	}

	public Album toEntity (AlbumDTO dto) {
		Album album = new Album();
		album.setBand(dto.getBand());
		album.setTitle(dto.getTitle());
		album.setPrice(dto.getPrice());
		album.setReleaseDate(dto.getReleaseDate());
		album.setLabel(dto.getLabel());
		return album;
	}
}
