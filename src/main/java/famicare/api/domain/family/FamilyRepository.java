package famicare.api.domain.family;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface FamilyRepository extends JpaRepository<Family, Long> {
    List<listFamilyData> findAllById(Long id);

    Page<Family> findAllByAtivoTrue(Pageable pageable);

    UserDetails findByEmail(String email);

}
