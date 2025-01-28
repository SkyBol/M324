package ch.group3.bandmanagement.controller;

import ch.group3.bandmanagement.model.Band;
import ch.group3.bandmanagement.repository.BandRepository;
import ch.group3.bandmanagement.validation.BandsNotPresentException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/bands")
public class BandController {

    @Autowired
    private BandRepository bandRepository;

    @PostMapping
    public ResponseEntity<Band> createBand(@Valid @RequestBody Band band) {
        return ResponseEntity.status(HttpStatus.CREATED).body(bandRepository.save(band));
    }

    @GetMapping
    public ResponseEntity<List<Band>> getBands() {
        List<Band> allBands = bandRepository.findAll();
        if (allBands.isEmpty()) {
            throw new BandsNotPresentException("No Bands are present");
        }
        return ResponseEntity.status(OK).body(allBands);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Band> getBandBy(@PathVariable long id) {
        return bandRepository.findById(id)
                .map(value -> ResponseEntity.status(OK).body(value))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
