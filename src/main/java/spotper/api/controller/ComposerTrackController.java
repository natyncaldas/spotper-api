package spotper.api.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import spotper.api.model.ComposerTrack;
import spotper.api.repository.ComposerTrackRepository;

@RestController
@RequestMapping("/api/v1")
public class ComposerTrackController {
    @Autowired
    private ComposerTrackRepository composerTrackRepository;

    @CrossOrigin
    @PostMapping("/composers/tracks")
    public ComposerTrack createComposerTrack(@Valid @RequestBody ComposerTrack composerTrack) {
        return composerTrackRepository.save(composerTrack);
    }

    @CrossOrigin
    @DeleteMapping("/composers/tracks")
    public Map<String, Boolean> deleteComposerTrack(@RequestParam Long composerId, @RequestParam Long trackId) {

        List<ComposerTrack> composerTracks = composerTrackRepository.findByComposerAndTrackId(composerId, trackId);
        Map<String, Boolean> response = new HashMap<>();
        for (ComposerTrack ct:composerTracks) {
            composerTrackRepository.delete(ct);
            response.put("deleted", Boolean.TRUE);
        }
        return response;
    }
}

