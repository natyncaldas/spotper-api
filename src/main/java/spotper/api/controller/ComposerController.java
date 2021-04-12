package spotper.api.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import spotper.api.exception.ResourceNotFoundException;
import spotper.api.model.Composer;
import spotper.api.repository.ComposerRepository;

@RestController
@RequestMapping("/api/v1")
public class ComposerController {
    @Autowired
    private ComposerRepository composerRepository;

    @CrossOrigin
    @GetMapping("/composers")
    public List<Composer> getAllComposers() {
        return composerRepository.findAll();
    }

    @CrossOrigin
    @GetMapping("/composers/{id}")
    public ResponseEntity<Composer> getComposersById(@PathVariable(value = "id") Long composerId)
            throws ResourceNotFoundException {
        Composer composer = composerRepository.findById(composerId)
                .orElseThrow(() -> new ResourceNotFoundException("Composer not found for this id :: " + composerId));
        return ResponseEntity.ok().body(composer);
    }

    @CrossOrigin
    @PostMapping("/composers")
    public Composer createComposer(@Valid @RequestBody Composer composer) {
        return composerRepository.save(composer);
    }

    @CrossOrigin
    @PutMapping("/composers/{id}")
    public ResponseEntity<Composer> updateComposer(@PathVariable(value = "id") Long composerId,
                                                         @Valid @RequestBody Composer composerDetails) throws ResourceNotFoundException {
        Composer composer = composerRepository.findById(composerId)
                .orElseThrow(() -> new ResourceNotFoundException("Composer not found for this id :: " + composerId));

        composer.setComposerName(composerDetails.getComposerName());
        composer.setBirthDate(composerDetails.getBirthDate());
        composer.setDeathDate(composerDetails.getDeathDate());
        composer.setCity(composerDetails.getCity());
        composer.setCountry(composerDetails.getCountry());
        final Composer updatedComposer = composerRepository.save(composer);
        return ResponseEntity.ok(updatedComposer);
    }

    @CrossOrigin
    @DeleteMapping("/composers/{id}")
    public Map<String, Boolean> deleteComposer(@PathVariable(value = "id") Long composerId)
            throws ResourceNotFoundException {
        Composer composer = composerRepository.findById(composerId)
                .orElseThrow(() -> new ResourceNotFoundException("Composer not found for this id :: " + composerId));

        composerRepository.delete(composer);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}

