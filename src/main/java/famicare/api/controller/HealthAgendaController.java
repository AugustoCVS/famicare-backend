package famicare.api.controller;

import famicare.api.domain.Exams.*;
import famicare.api.domain.Relative.RelativeRepository;
import famicare.api.domain.healthAgenda.*;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agenda")
@SecurityRequirement(name = "bearer-key")
public class HealthAgendaController {

    @Autowired
    private HealthAgendaRepository repository;

    @Autowired
    private RelativeRepository relativeRepository;

    @PostMapping("/{relativeId}")
    @Transactional
    public ResponseEntity registerRelativeExams(@PathVariable Long relativeId, @RequestBody @Valid registerHealthAgenda data){
        var relative = relativeRepository.getReferenceById(relativeId);
        var healthAgenda = new HealthAgenda(data);

        healthAgenda.setRelative(relative);
        repository.save(healthAgenda);

        return ResponseEntity.ok().body(new detailsHealthAgenda(healthAgenda));
    }

    @GetMapping("/{relativeId}")
    public ResponseEntity<List<listHealthAgendaData>> list(@PathVariable Long relativeId){
        var relative = relativeRepository.getReferenceById(relativeId);
        var list = repository.findAllByRelativeId(relative.getId());

        if (list.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(list);

    }

    @PutMapping("/{relativeId}/{id}")
    @Transactional
    public ResponseEntity update(@PathVariable Long relativeId, @PathVariable Long id, @RequestBody @Valid updateHealthAgendaData data){
        var relative = relativeRepository.getReferenceById(relativeId);
        HealthAgenda healthAgenda = repository.getReferenceById(id);

        if(healthAgenda.getRelative().getId().equals(relativeId)){
            healthAgenda.updateData(data);
        }

        return ResponseEntity.ok(new detailsHealthAgenda(healthAgenda));
    }


}
