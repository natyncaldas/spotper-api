package spotper.api.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import spotper.api.exception.ResourceNotFoundException;
import spotper.api.model.Playlist;
import spotper.api.repository.PlaylistRepository;

@RestController
@RequestMapping("/api/v1")
public class PlaylistController {
    @Autowired
    private PlaylistRepository playlistRepository;

    @CrossOrigin
    @GetMapping("/playlists")
    public List<Playlist> getAllPlaylists() {
        return playlistRepository.findAll();
    }

    @CrossOrigin
    @GetMapping("/playlists/{id}")
    public ResponseEntity<Playlist> getPlaylistById(@PathVariable(value = "id") Long playlistId)
            throws ResourceNotFoundException {
        Playlist playlist = playlistRepository.findById(playlistId)
                .orElseThrow(() -> new ResourceNotFoundException("Playlist not found for this id :: " + playlistId));
        return ResponseEntity.ok().body(playlist);
    }

    @CrossOrigin
    @PostMapping("/playlists")
    public Playlist createPlaylist(@Valid @RequestBody Playlist playlist) {
        return playlistRepository.save(playlist);
    }

    @CrossOrigin
    @PutMapping("/playlists/{id}")
    public ResponseEntity<Playlist> updatePlaylist(@PathVariable(value = "id") Long playlistId,
                                             @Valid @RequestBody Playlist playlistDetails) throws ResourceNotFoundException {
        Playlist playlist = playlistRepository.findById(playlistId)
                .orElseThrow(() -> new ResourceNotFoundException("Playlist not found for this id :: " + playlistId));

        playlist.setPlaylistName(playlistDetails.getPlaylistName());
        playlist.setTotalDuration(playlistDetails.getTotalDuration());
        final Playlist updatedPlaylist = playlistRepository.save(playlist);
        return ResponseEntity.ok(updatedPlaylist);
    }

    @CrossOrigin
    @DeleteMapping("/playlists/{id}")
    public Map<String, Boolean> deletePlaylist(@PathVariable(value = "id") Long playlistId)
            throws ResourceNotFoundException {
        Playlist playlist = playlistRepository.findById(playlistId)
                .orElseThrow(() -> new ResourceNotFoundException("Playlist not found for this id :: " + playlistId));

        playlistRepository.delete(playlist);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
