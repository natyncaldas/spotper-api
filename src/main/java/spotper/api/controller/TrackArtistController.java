package spotper.api.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spotper.api.model.TrackArtist;
import spotper.api.repository.TrackArtistRepository;


@RestController
@RequestMapping("/api/v1")
public class TrackArtistController {
    @Autowired
    private TrackArtistRepository trackArtistRepository;

    @CrossOrigin
    @PostMapping("/tracks/artists")
    public TrackArtist createTrackArtist(@Valid @RequestBody TrackArtist trackArtist) {
        return trackArtistRepository.save(trackArtist);
    }

    @CrossOrigin
    @DeleteMapping("/tracks/artists")
    public Map<String, Boolean> deleteTrackArtist(@RequestParam(required = true) long trackId, @RequestParam(required = true) long artistId) {

        List<TrackArtist> trackArtists = trackArtistRepository.findByTrackAndArtistId(trackId, artistId);
        Map<String, Boolean> response = new HashMap<>();
        for (TrackArtist ta:trackArtists) {
            trackArtistRepository.delete(ta);
            response.put("deleted", Boolean.TRUE);
        }
        return response;
    }
}

