package famicare.api.controller;

import famicare.api.domain.Relative.RelativeRepository;
import famicare.api.domain.Relative.detailsRelativeData;
import famicare.api.domain.healthHistoric.*;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/historic")
@SecurityRequirement(name = "bearer-key")
public class HealthHistoricController {

    @Autowired
    private HealthHistoricRepository repository;

    @Autowired
    private RelativeRepository relativeRepository;

    @PostMapping("/{relativeId}")
    @Transactional
    public ResponseEntity registerRelativeHistoric(@PathVariable Long relativeId, @RequestBody @Valid registerHealthHistoric data){
        var relative = relativeRepository.getReferenceById(relativeId);
        var historic = new HealthHistoric(data);

        historic.setRelative(relative);
        repository.save(historic);

        return ResponseEntity.ok().body(new detailsHealthHistoric(historic));
    }

    @GetMapping("/{relativeId}")
    public ResponseEntity<List<listHealthHistoricData>> list(@PathVariable Long relativeId){
        var relative = relativeRepository.getReferenceById(relativeId);
        var list = repository.findAllByRelativeId(relative.getId());

        if (list.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(list);

    }

    @PutMapping("/{relativeId}/{id}")
    @Transactional
    public ResponseEntity update(@PathVariable Long relativeId, @PathVariable Long id, @RequestBody @Valid updateHealthHistoric data){
        var relative = relativeRepository.getReferenceById(relativeId);
        HealthHistoric healthHistoric = repository.getReferenceById(id);

        if(healthHistoric.getRelative().getId().equals(relativeId)){
            healthHistoric.updateData(data);
        }

        return ResponseEntity.ok(new detailsHealthHistoric(healthHistoric));
    }


}
