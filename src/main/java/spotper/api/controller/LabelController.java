package spotper.api.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spotper.api.exception.ResourceNotFoundException;
import spotper.api.model.Label;
import spotper.api.repository.LabelRepository;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class LabelController {
    @Autowired
    private LabelRepository labelRepository;

    @CrossOrigin
    @GetMapping("/labels")
    public List<Label> getAllLabels() {
        return labelRepository.findAll();
    }

    @CrossOrigin
    @GetMapping("/labels/{id}")
    public ResponseEntity<Label> getLabelById(@PathVariable(value = "id") Long labelId)
            throws ResourceNotFoundException {
        Label label = labelRepository.findById(labelId)
                .orElseThrow(() -> new ResourceNotFoundException("Label not found for this id :: " + labelId));
        return ResponseEntity.ok().body(label);
    }

    @CrossOrigin
    @PostMapping("/labels")
    public Label createLabel(@Valid @RequestBody Label label) {
        return labelRepository.save(label);
    }

    @CrossOrigin
    @PutMapping("/labels/{id}")
    public ResponseEntity<Label> updateLabel(@PathVariable(value = "id") Long labelId,
                                                   @Valid @RequestBody Label labelDetails) throws ResourceNotFoundException {
        Label label = labelRepository.findById(labelId)
                .orElseThrow(() -> new ResourceNotFoundException("Label not found for this id :: " + labelId));

        label.setHomepage(labelDetails.getHomepage());
        label.setAddress(labelDetails.getAddress());
        label.setLabelName(labelDetails.getLabelName());
        final Label updatedLabel = labelRepository.save(label);
        return ResponseEntity.ok(updatedLabel);
    }

    @CrossOrigin
    @DeleteMapping("/labels/{id}")
    public Map<String, Boolean> deleteLabel(@PathVariable(value = "id") Long labelId)
            throws ResourceNotFoundException {
        Label label = labelRepository.findById(labelId)
                .orElseThrow(() -> new ResourceNotFoundException("Label not found for this id :: " + labelId));

        labelRepository.delete(label);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
