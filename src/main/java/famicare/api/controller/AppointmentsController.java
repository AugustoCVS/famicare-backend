package famicare.api.controller;

import famicare.api.domain.Relative.RelativeRepository;
import famicare.api.domain.appointments.*;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appointments")
@SecurityRequirement(name = "bearer-key")
public class AppointmentsController {

    @Autowired
    private AppointmentsRepository repository;

    @Autowired
    private RelativeRepository relativeRepository;

    @PostMapping("/{relativeId}")
    @Transactional
    public ResponseEntity registerRelativeAppointments(@PathVariable Long relativeId, @RequestBody @Valid registerAppointments data){
        var relative = relativeRepository.getReferenceById(relativeId);
        var appointments = new Appointments(data);

        appointments.setRelative(relative);
        repository.save(appointments);

        return ResponseEntity.ok().body(new detailsAppointments(appointments));
    }

    @GetMapping("/{relativeId}")
    public ResponseEntity<List<listAppointmentsData>> list(@PathVariable Long relativeId){
        var relative = relativeRepository.getReferenceById(relativeId);
        var list = repository.findAllByRelativeId(relative.getId());

        if (list.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(list);

    }

    @PutMapping("/{relativeId}/{id}")
    @Transactional
    public ResponseEntity update(@PathVariable Long relativeId, @PathVariable Long id, @RequestBody @Valid updateAppointments data){
        var relative = relativeRepository.getReferenceById(relativeId);
        Appointments appointments = repository.getReferenceById(id);

        if(appointments.getRelative().getId().equals(relativeId)){
            appointments.updateData(data);
        }

        return ResponseEntity.ok(new detailsAppointments(appointments));
    }


}
