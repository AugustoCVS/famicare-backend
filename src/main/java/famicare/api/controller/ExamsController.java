package famicare.api.controller;

import famicare.api.domain.Exams.*;
import famicare.api.domain.Relative.RelativeRepository;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/exams")
@SecurityRequirement(name = "bearer-key")
public class ExamsController {
    @Autowired
    private ExamsRepository repository;

    @Autowired
    private RelativeRepository relativeRepository;

    @PostMapping("/{relativeId}")
    @Transactional
    public ResponseEntity registerRelativeExams(@PathVariable Long relativeId, @RequestBody @Valid registerExams data){
        var relative = relativeRepository.getReferenceById(relativeId);
        var exams = new Exams(data);

        exams.setRelative(relative);
        repository.save(exams);

        return ResponseEntity.ok().body(new detailsExams(exams));
    }

    @GetMapping("/{relativeId}")
    public ResponseEntity<List<listExamsData>> list(@PathVariable Long relativeId){
        var relative = relativeRepository.getReferenceById(relativeId);
        var list = repository.findAllByRelativeId(relative.getId());

        if (list.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(list);

    }

    @PutMapping("/{relativeId}/{id}")
    @Transactional
    public ResponseEntity update(@PathVariable Long relativeId, @PathVariable Long id, @RequestBody @Valid updateExams data){
        var relative = relativeRepository.getReferenceById(relativeId);
        Exams exams = repository.getReferenceById(id);

        if(exams.getRelative().getId().equals(relativeId)){
            exams.updateData(data);
        }

        return ResponseEntity.ok(new detailsExams(exams));
    }


}
