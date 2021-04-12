package spotper.api.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import spotper.api.exception.ResourceNotFoundException;
import spotper.api.model.Label;
import spotper.api.model.LabelPhone;
import spotper.api.repository.LabelPhoneRepository;

@RestController
@RequestMapping("/api/v1")
public class LabelPhoneController {
    @Autowired
    private LabelPhoneRepository labelPhoneRepository;

    @CrossOrigin
    @GetMapping("/labelPhones")
    public List<LabelPhone> getAllLabelPhones() {
        return labelPhoneRepository.findAll();
    }

    @CrossOrigin
    @GetMapping("/labelPhones/{phone}")
    public ResponseEntity<LabelPhone> getLabelPhoneById(@PathVariable(value = "phone") Long labelPhoneId)
            throws ResourceNotFoundException {
        LabelPhone labelPhone = labelPhoneRepository.findById(labelPhoneId)
                .orElseThrow(() -> new ResourceNotFoundException("Label phone not found for this id :: " + labelPhoneId));
        return ResponseEntity.ok().body(labelPhone);
    }

    @CrossOrigin
    @PostMapping("/labelPhones")
    public LabelPhone createLabelPhone(@Valid @RequestBody LabelPhone labelPhone) {
        return labelPhoneRepository.save(labelPhone);
    }

    @CrossOrigin
    @PutMapping("/labelPhones/{phone}")
    public ResponseEntity<LabelPhone> updateLabelPhone(@PathVariable(value = "phone") Long labelPhoneId,
                                             @Valid @RequestBody LabelPhone labelPhoneDetails) throws ResourceNotFoundException {
        LabelPhone labelPhone = labelPhoneRepository.findById(labelPhoneId)
                .orElseThrow(() -> new ResourceNotFoundException("Label phone not found for this id :: " + labelPhoneId));

        labelPhone.setPhoneNumber(labelPhoneDetails.getPhoneNumber());
        labelPhone.setPhoneType(labelPhoneDetails.getPhoneType());
        final LabelPhone updatedLabelPhone = labelPhoneRepository.save(labelPhone);
        return ResponseEntity.ok(updatedLabelPhone);
    }

    @CrossOrigin
    @DeleteMapping("/labelPhones/{phone}")
    public Map<String, Boolean> deleteLabelPhone(@PathVariable(value = "phone") Long labelPhoneId)
            throws ResourceNotFoundException {
        LabelPhone labelPhone = labelPhoneRepository.findById(labelPhoneId)
                .orElseThrow(() -> new ResourceNotFoundException("Label phone not found for this id :: " + labelPhoneId));

        labelPhoneRepository.delete(labelPhone);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
