package spotper.api.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spotper.api.model.ComposerPeriod;
import spotper.api.repository.ComposerPeriodRepository;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class ComposerPeriodController {
    @Autowired
    private ComposerPeriodRepository composerPeriodRepository;

    @CrossOrigin
    @PostMapping("/composers/musical_periods")
    public ComposerPeriod createComposerPeriod(@Valid @RequestBody ComposerPeriod composerPeriod) {
        return composerPeriodRepository.save(composerPeriod);
    }

    @CrossOrigin
    @DeleteMapping("/composers/musical_periods")
    public Map<String, Boolean> deleteComposerPeriod(@RequestParam Long composerId, @RequestParam Long periodId) {
        List<ComposerPeriod> composerPeriods = composerPeriodRepository.findByPeriodOrComposerId(composerId, periodId);
        Map<String, Boolean> response = new HashMap<>();
        for (ComposerPeriod cp:composerPeriods) {
            composerPeriodRepository.delete(cp);
            response.put("deleted", Boolean.TRUE);
        }
        return response;
    }
}

