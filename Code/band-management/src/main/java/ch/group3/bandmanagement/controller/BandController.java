package ch.group3.bandmanagement.controller;

import ch.group3.bandmanagement.model.Band;
import ch.group3.bandmanagement.repository.BandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/bands")
public class BandController {

    @Autowired
    private BandRepository bandRepository;

    @PostMapping
    public ResponseEntity<Band> createBand(@Valid @RequestBody Band band) {
        return ResponseEntity.status(HttpStatus.CREATED).body(bandRepository.save(band));
    }
}
