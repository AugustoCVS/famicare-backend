package famicare.api.controller;

import famicare.api.domain.Relative.*;
import famicare.api.domain.Relative.Relative;
import famicare.api.domain.Relative.RelativeRepository;
import famicare.api.domain.Relative.listRelativeData;
import famicare.api.domain.family.AuthData;
import famicare.api.domain.family.Family;
import famicare.api.domain.family.FamilyRepository;
import famicare.api.infra.Security.TokenService;
import famicare.api.infra.Security.dataTokenJwt;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/relative")
@SecurityRequirement(name = "bearer-key")
public class RelativeController {

    @Autowired
    private RelativeRepository repository;

    @Autowired
    private FamilyRepository familyRepository;

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/register/{familyId}")
    @Transactional
    public ResponseEntity registerRelativeInFamily(@PathVariable Long familyId, @RequestBody @Valid registerRelativeData data, UriComponentsBuilder uriBuilder) {
        var family = familyRepository.getReferenceById(familyId);
        var relative = new Relative(data);

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String encryptedPassword = bCryptPasswordEncoder.encode(relative.getPassword());
        String encryptedConfirmPassword = bCryptPasswordEncoder.encode(relative.getConfirm_password());
        relative.setPassword(encryptedPassword);
        relative.setConfirm_password(encryptedConfirmPassword);

        relative.setFamily(family);
        repository.save(relative);

        var uri = uriBuilder.path("/family/{id}").buildAndExpand(relative.getId()).toUri();

        return ResponseEntity.created(uri).body(new detailsRelativeData(relative));
    }

    @GetMapping("/{familyId}")
    public ResponseEntity<List<listRelativeData>> list(@PathVariable Long familyId){
        var family = familyRepository.getReferenceById(familyId);
        var list = repository.findAllByFamilyId(family.getId());

        if (list.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(list);
    }

    @GetMapping("/{familyId}/{id}")
    public ResponseEntity<detailsRelativeData> list(@PathVariable Long familyId, @PathVariable Long id){
        var family = familyRepository.getReferenceById(familyId);
        var relative = repository.getReferenceById(id);

        if(relative.getFamily().getId().equals(familyId)){
            var list = repository.getReferenceById(id);

            return ResponseEntity.ok(new detailsRelativeData(list));
        }

        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{familyId}/{id}")
    @Transactional
    public ResponseEntity update(@PathVariable Long familyId, @PathVariable Long id, @RequestBody @Valid updateRelativeData data){
        Family family = familyRepository.getReferenceById(familyId);
        Relative relative = repository.getReferenceById(id);

        if(relative.getFamily().getId().equals(familyId)){
            relative.updateData(data);
        }

        return ResponseEntity.ok(new detailsRelativeData(relative));
    }

    @PostMapping("/{familyId}/login")
    public ResponseEntity login(@PathVariable Long familyId, @RequestBody @Valid AuthRelativeData data){
        Family family = familyRepository.getReferenceById(familyId);

        Relative relative = repository.findByEmail(data.email());

        if (relative != null && relative.getFamily().getId().equals(familyId)) {
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

            if (encoder.matches(data.password(), relative.getPassword())) {
                return ResponseEntity.ok(new detailsRelativeData(relative));
            }
        }

        return ResponseEntity.notFound().build();
    }

}
