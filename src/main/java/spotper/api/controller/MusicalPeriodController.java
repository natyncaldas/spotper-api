package spotper.api.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import spotper.api.exception.ResourceNotFoundException;
import spotper.api.model.MusicalPeriod;
import spotper.api.repository.MusicalPeriodRepository;

@RestController
@RequestMapping("/api/v1")
public class MusicalPeriodController {
    @Autowired
    private MusicalPeriodRepository musicalPeriodRepository;

    @CrossOrigin
    @GetMapping("/musical_periods")
    public List<MusicalPeriod> getAllMusicalPeriods() {
        return musicalPeriodRepository.findAll();
    }

    @CrossOrigin
    @GetMapping("/musical_periods/{id}")
    public ResponseEntity<MusicalPeriod> getMusicalPeriodsById(@PathVariable(value = "id") Long musicalPeriodId)
            throws ResourceNotFoundException {
        MusicalPeriod musicalPeriod = musicalPeriodRepository.findById(musicalPeriodId)
                .orElseThrow(() -> new ResourceNotFoundException("Musical period not found for this id :: " + musicalPeriodId));
        return ResponseEntity.ok().body(musicalPeriod);
    }

    @CrossOrigin
    @PostMapping("/musical_periods")
    public MusicalPeriod createMusicalPeriod(@Valid @RequestBody MusicalPeriod musicalPeriod) {
        return musicalPeriodRepository.save(musicalPeriod);
    }

    @CrossOrigin
    @PutMapping("/musical_periods/{id}")
    public ResponseEntity<MusicalPeriod> updateMusicalPeriod(@PathVariable(value = "id") Long musicalPeriodId,
                                                   @Valid @RequestBody MusicalPeriod musicalPeriodDetails) throws ResourceNotFoundException {
        MusicalPeriod musicalPeriod = musicalPeriodRepository.findById(musicalPeriodId)
                .orElseThrow(() -> new ResourceNotFoundException("Musical period not found for this id :: " + musicalPeriodId));

        musicalPeriod.setPeriodDescription(musicalPeriodDetails.getPeriodDescription());
        musicalPeriod.setDuration(musicalPeriodDetails.getDuration());
        final MusicalPeriod updatedMusicalPeriod = musicalPeriodRepository.save(musicalPeriod);
        return ResponseEntity.ok(updatedMusicalPeriod);
    }

    @CrossOrigin
    @DeleteMapping("/musical_periods/{id}")
    public Map<String, Boolean> deleteMusicalPeriod(@PathVariable(value = "id") Long musicalPeriodId)
            throws ResourceNotFoundException {
        MusicalPeriod musicalPeriod = musicalPeriodRepository.findById(musicalPeriodId)
                .orElseThrow(() -> new ResourceNotFoundException("Musical period not found for this id :: " + musicalPeriodId));

        musicalPeriodRepository.delete(musicalPeriod);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}

