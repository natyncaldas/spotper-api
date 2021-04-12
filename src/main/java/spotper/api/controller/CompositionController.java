package spotper.api.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import spotper.api.exception.ResourceNotFoundException;
import spotper.api.model.Composition;
import spotper.api.model.Label;
import spotper.api.repository.CompositionRepository;

@RestController
@RequestMapping("/api/v1")
public class CompositionController {
    @Autowired
    private CompositionRepository compositionRepository;

    @CrossOrigin
    @GetMapping("/compositions")
    public List<Composition> getAllCompositions() {
        return compositionRepository.findAll();
    }

    @CrossOrigin
    @GetMapping("/compositions/{id}")
    public ResponseEntity<Composition> getCompositionById(@PathVariable(value = "id") Long compositionId)
            throws ResourceNotFoundException {
        Composition composition = compositionRepository.findById(compositionId)
                .orElseThrow(() -> new ResourceNotFoundException("Composition not found for this id :: " + compositionId));
        return ResponseEntity.ok().body(composition);
    }

    @CrossOrigin
    @PostMapping("/compositions")
    public Composition createComposition(@Valid @RequestBody Composition composition) {
        return compositionRepository.save(composition);
    }

    @CrossOrigin
    @PutMapping("/compositions/{id}")
    public ResponseEntity<Composition> updateComposition(@PathVariable(value = "id") Long compositionId,
                                             @Valid @RequestBody Composition compositionDetails) throws ResourceNotFoundException {
        Composition composition = compositionRepository.findById(compositionId)
                .orElseThrow(() -> new ResourceNotFoundException("Composition not found for this id :: " + compositionId));

        composition.setCompositionDescription(compositionDetails.getCompositionDescription());
        composition.setCompositionType(compositionDetails.getCompositionType());
        final Composition updatedComposition = compositionRepository.save(composition);
        return ResponseEntity.ok(updatedComposition);
    }

    @CrossOrigin
    @DeleteMapping("/compositions/{id}")
    public Map<String, Boolean> deleteComposition(@PathVariable(value = "id") Long compositionId)
            throws ResourceNotFoundException {
        Composition composition = compositionRepository.findById(compositionId)
                .orElseThrow(() -> new ResourceNotFoundException("Composition not found for this id :: " + compositionId));

        compositionRepository.delete(composition);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}

