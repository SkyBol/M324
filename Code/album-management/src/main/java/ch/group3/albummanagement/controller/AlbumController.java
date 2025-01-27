package ch.group3.albummanagement.controller;

import ch.group3.albummanagement.model.AlbumDTO;
import ch.group3.albummanagement.service.AlbumService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/album")
public class AlbumController {

	private final AlbumService albumService;

	@Autowired
	public AlbumController(AlbumService albumService) {
		this.albumService = albumService;
	}

	@PostMapping
	public ResponseEntity<AlbumDTO> createAlbum(@Valid @RequestBody AlbumDTO album) {
		return ResponseEntity.status(CREATED).body(albumService.save(album));
	}

	@GetMapping
	public ResponseEntity<Object> health() {
		return ResponseEntity.status(200).build();
	}
}
