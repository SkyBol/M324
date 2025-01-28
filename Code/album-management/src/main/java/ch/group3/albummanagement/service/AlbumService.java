package ch.group3.albummanagement.service;

import ch.group3.albummanagement.model.Album;
import ch.group3.albummanagement.model.AlbumDTO;
import ch.group3.albummanagement.model.mapper.AlbumMapper;
import ch.group3.albummanagement.repository.AlbumRepository;
import ch.group3.albummanagement.validation.AlbumValidationService;
import ch.group3.albummanagement.validation.ValidationResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlbumService {

	private final AlbumRepository albumRepository;
	private final AlbumMapper mapper;
	private final AlbumValidationService albumValidationService;

	@Autowired
	public AlbumService(AlbumRepository albumRepository, AlbumMapper mapper, AlbumValidationService albumValidationService) {
		this.albumRepository = albumRepository;
		this.mapper = mapper;
		this.albumValidationService = albumValidationService;
	}

	public AlbumDTO save(AlbumDTO albumDTO) {
		ValidationResult validationResult = albumValidationService.validate(albumDTO);
		Album album = albumRepository.save(mapper.toEntity(validationResult.getOrThrow()));
		return mapper.toDto(album);
	}
}
