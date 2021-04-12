package spotper.api.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import spotper.api.exception.ResourceNotFoundException;
import spotper.api.model.Album;
import spotper.api.repository.AlbumRepository;

@RestController
@RequestMapping("/api/v1")
public class AlbumController {
    @Autowired
    private AlbumRepository albumRepository;

    @CrossOrigin
    @GetMapping("/albums")
    public List<Album> getAllAlbums() {
        return albumRepository.findAll();
    }

    @CrossOrigin
    @GetMapping("/albums/{id}")
    public ResponseEntity<Album> getAlbumById(@PathVariable(value = "id") Long albumId)
            throws ResourceNotFoundException {
        Album album = albumRepository.findById(albumId)
                .orElseThrow(() -> new ResourceNotFoundException("Album not found for this id :: " + albumId));
        return ResponseEntity.ok().body(album);
    }

    @CrossOrigin
    @PostMapping("/albums")
    public Album createAlbum(@Valid @RequestBody Album album) {
        return albumRepository.save(album);
    }

    @CrossOrigin
    @PutMapping("/albums/{id}")
    public ResponseEntity<Album> updateAlbum(@PathVariable(value = "id") Long albumId,
                                             @Valid @RequestBody Album albumDetails) throws ResourceNotFoundException {
        Album album = albumRepository.findById(albumId)
                .orElseThrow(() -> new ResourceNotFoundException("Album not found for this id :: " + albumId));

        album.setAlbumDescription(albumDetails.getAlbumDescription());
        album.setPurchasePrice(albumDetails.getPurchasePrice());
        album.setPurchaseDate(albumDetails.getPurchaseDate());
        album.setPurchaseType(albumDetails.getPurchaseType());
        album.setRecordingDate(albumDetails.getRecordingDate());
        album.setAlbumName(albumDetails.getAlbumName());
        album.setAlbumCover(albumDetails.getAlbumCover());
        final Album updatedAlbum = albumRepository.save(album);
        return ResponseEntity.ok(updatedAlbum);
    }

    @CrossOrigin
    @DeleteMapping("/albums/{id}")
    public Map<String, Boolean> deleteAlbum(@PathVariable(value = "id") Long albumId)
            throws ResourceNotFoundException {
        Album album = albumRepository.findById(albumId)
                .orElseThrow(() -> new ResourceNotFoundException("Album not found for this id :: " + albumId));

        albumRepository.delete(album);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
