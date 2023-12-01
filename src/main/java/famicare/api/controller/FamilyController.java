package famicare.api.controller;

import famicare.api.domain.family.*;
import famicare.api.infra.Security.TokenService;
import famicare.api.infra.Security.dataTokenJwt;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/family")
public class FamilyController {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private FamilyRepository repository;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/register")
    @Transactional
    public ResponseEntity register(@RequestBody @Valid registerFamilyData data, UriComponentsBuilder uriBuilder){
        var family = new Family(data);
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String encryptedPassword = bCryptPasswordEncoder.encode(family.getPassword());
        String encryptedConfirmPassword = bCryptPasswordEncoder.encode(family.getConfirm_password());
        family.setPassword(encryptedPassword);
        family.setConfirm_password(encryptedConfirmPassword);

        repository.save(family);

        var uri = uriBuilder.path("/family/{id}").buildAndExpand(family.getId()).toUri();

        return ResponseEntity.created(uri).body(new detailsFamilyData(family));
    }

    @GetMapping
    @SecurityRequirement(name = "bearer-key")
    public ResponseEntity<Page<listFamilyData>> list(@PageableDefault(size = 20, sort = {"name"}) Pageable pageable){
        var page = repository.findAllByAtivoTrue(pageable).map(listFamilyData::new);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    @SecurityRequirement(name = "bearer-key")
    public ResponseEntity<detailsFamilyData> list(@PathVariable Long id){
        var list = repository.getReferenceById(id);
        return ResponseEntity.ok(new detailsFamilyData(list));
    }

    @PutMapping("/{id}")
    @Transactional
    @SecurityRequirement(name = "bearer-key")
    public ResponseEntity update(@PathVariable Long id, @RequestBody @Valid updateFamilyData data) {
        var family = repository.getReferenceById(id);
        family.updateData(data);

        return ResponseEntity.ok(new detailsFamilyData(family));
    }


    @DeleteMapping("/{id}")
    @Transactional
    @SecurityRequirement(name = "bearer-key")
    public ResponseEntity delete(@PathVariable Long id){
        Family family = repository.getReferenceById(id);
            family.softDelete();

        return ResponseEntity.noContent().build();
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthData data){
        var auth_token = new UsernamePasswordAuthenticationToken(data.email(), data.password());
        var auth = manager.authenticate(auth_token);

        var tokenJWT = tokenService.generateToken((Family) auth.getPrincipal());

        return ResponseEntity.ok(new dataTokenJwt(tokenJWT));
    }

}
