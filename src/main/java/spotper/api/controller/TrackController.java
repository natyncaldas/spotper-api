package spotper.api.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spotper.api.exception.ResourceNotFoundException;
import spotper.api.model.Track;
import spotper.api.repository.TrackRepository;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class TrackController {
    @Autowired
    private TrackRepository trackRepository;

    @CrossOrigin
    @GetMapping("/tracks")
    public List<Track> getAllTracks() {
        return trackRepository.findAll();
    }

    @CrossOrigin
    @GetMapping("/albums/{id}/tracks")
    public List<Track> getTracksByAlbumId(@PathVariable(value = "id") long albumId) {
        return trackRepository.findTrackByAlbumId(albumId);
    }

    @CrossOrigin
    @GetMapping("/playlists/{id}/tracks")
    public List<Track> getTracksByPlaylistId(@PathVariable(value = "id") long playlistId) {
        return trackRepository.findTrackByPlaylistId(playlistId);
    }

    @CrossOrigin
    @GetMapping("/tracks/{id}")
    public ResponseEntity<Track> getTrackById(@PathVariable(value = "id") Long trackId)
            throws ResourceNotFoundException {
        Track track = trackRepository.findById(trackId)
                .orElseThrow(() -> new ResourceNotFoundException("Track not found for this id :: " + trackId));
        return ResponseEntity.ok().body(track);
    }
    @CrossOrigin
    @PutMapping("/tracks/{id}")
    public ResponseEntity<Track> updateTrack(@PathVariable(value = "id") Long trackId,
                                             @Valid @RequestBody Track trackDetails) throws ResourceNotFoundException {
        Track track = trackRepository.findById(trackId)
                .orElseThrow(() -> new ResourceNotFoundException("Track not found for this id :: " + trackId));

        track.setLastPlayed(trackDetails.getLastPlayed());
        track.setPlayCount(trackDetails.getPlayCount());
        final Track updatedTrack = trackRepository.save(track);
        return ResponseEntity.ok(updatedTrack);
    }

    @CrossOrigin
    @PostMapping("/tracks")
    public Track createTrack(@Valid @RequestBody Track track) {
        return trackRepository.save(track);
    }

    @CrossOrigin
    @DeleteMapping("/tracks/{id}")
    public Map<String, Boolean> deleteTrack(@PathVariable(value = "id") Long trackId)
            throws ResourceNotFoundException {
        Track track = trackRepository.findById(trackId)
                .orElseThrow(() -> new ResourceNotFoundException("Label not found for this id :: " + trackId));

        trackRepository.delete(track);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
