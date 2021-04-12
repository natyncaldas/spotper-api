package spotper.api.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spotper.api.model.TrackPlaylist;
import spotper.api.repository.TrackPlaylistRepository;


@RestController
@RequestMapping("/api/v1")
public class TrackPlaylistController {
    @Autowired
    private TrackPlaylistRepository trackPlaylistRepository;

    @CrossOrigin
    @PostMapping("/tracks/playlists")
    public TrackPlaylist createTrackPlaylist(@Valid @RequestBody TrackPlaylist trackPlaylist) {
        return trackPlaylistRepository.save(trackPlaylist);
    }

    @CrossOrigin
    @DeleteMapping("/tracks/playlists")
    public Map<String, Boolean> deleteTrackPlaylist(@RequestParam() long trackId, @RequestParam() long playlistId) {

        List<TrackPlaylist> trackPlaylists = trackPlaylistRepository.findByTrackAndPlaylistId(trackId, playlistId);
        Map<String, Boolean> response = new HashMap<>();
        for (TrackPlaylist tp:trackPlaylists) {
            trackPlaylistRepository.delete(tp);
            response.put("deleted", Boolean.TRUE);
        }
        return response;
    }
}

