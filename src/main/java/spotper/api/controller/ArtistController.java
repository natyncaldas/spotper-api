package spotper.api.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spotper.api.exception.ResourceNotFoundException;
import spotper.api.model.Album;
import spotper.api.model.Artist;
import spotper.api.repository.ArtistRepository;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class ArtistController {
    @Autowired
    private ArtistRepository artistRepository;

    @GetMapping("/artists")
    public List<Artist> getAllArtists() {
        return artistRepository.findAll();
    }

    @GetMapping("/artists/{id}")
    public ResponseEntity<Artist> getArtistById(@PathVariable(value = "id") Long artistId)
            throws ResourceNotFoundException {
        Artist artist = artistRepository.findById(artistId)
                .orElseThrow(() -> new ResourceNotFoundException("Artist not found for this id :: " + artistId));
        return ResponseEntity.ok().body(artist);
    }

    @CrossOrigin
    @PutMapping("/artists/{id}")
    public ResponseEntity<Artist> updateArtist(@PathVariable(value = "id") Long artistId,
                                             @Valid @RequestBody Artist artistDetails) throws ResourceNotFoundException {
        Artist artist = artistRepository.findById(artistId)
                .orElseThrow(() -> new ResourceNotFoundException("Artist not found for this id :: " + artistId));

        artist.setArtistName(artistDetails.getArtistName());
        artist.setArtistType(artistDetails.getArtistType());
        final Artist updatedArtist = artistRepository.save(artist);
        return ResponseEntity.ok(updatedArtist);
    }

    @CrossOrigin
    @PostMapping("/artists")
    public Artist createArtist(@Valid @RequestBody Artist artist) {
        return artistRepository.save(artist);
    }


    @CrossOrigin
    @DeleteMapping("/artists/{id}")
    public Map<String, Boolean> deleteArtist(@PathVariable(value = "id") Long artistId)
            throws ResourceNotFoundException {
        Artist artist = artistRepository.findById(artistId)
                .orElseThrow(() -> new ResourceNotFoundException("Artist not found for this id :: " + artistId));

        artistRepository.delete(artist);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
