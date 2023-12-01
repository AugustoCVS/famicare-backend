package famicare.api.controller;

import famicare.api.domain.Prescriptions.*;
import famicare.api.domain.Relative.RelativeRepository;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prescriptions")
@SecurityRequirement(name = "bearer-key")
public class PrescriptionsController {
    @Autowired
    private PrescriptionRepository repository;

    @Autowired
    private RelativeRepository relativeRepository;

    @PostMapping("/{relativeId}")
    @Transactional
    public ResponseEntity registerRelativePrescriptions(@PathVariable Long relativeId, @RequestBody @Valid registerPrescriptions data){
        var relative = relativeRepository.getReferenceById(relativeId);
        var prescriptions = new Prescriptions(data);

        prescriptions.setRelative(relative);
        repository.save(prescriptions);

        return ResponseEntity.ok().body(new detailsPrescriptions(prescriptions));
    }

    @GetMapping("/{relativeId}")
    public ResponseEntity<List<listPrescriptionsData>> list(@PathVariable Long relativeId){
        var relative = relativeRepository.getReferenceById(relativeId);
        var list = repository.findAllByRelativeId(relative.getId());

        if (list.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(list);

    }

    @PutMapping("/{relativeId}/{id}")
    @Transactional
    public ResponseEntity update(@PathVariable Long relativeId, @PathVariable Long id, @RequestBody @Valid updatePrescription data){
        var relative = relativeRepository.getReferenceById(relativeId);
        Prescriptions prescriptions = repository.getReferenceById(id);

        if(prescriptions.getRelative().getId().equals(relativeId)){
            prescriptions.updateData(data);
        }

        return ResponseEntity.ok(new detailsPrescriptions(prescriptions));
    }


}
