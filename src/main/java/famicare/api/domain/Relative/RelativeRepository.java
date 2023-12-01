package famicare.api.domain.Relative;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface RelativeRepository extends JpaRepository<Relative, Long> {

    List<listRelativeData> findAllById(Long id);
    List<listRelativeData> findAllByFamilyId(Long id);

    List<listRelativeData> findByEmailAndPassword(String email, String password);
    Relative findByEmail(String email);

}

