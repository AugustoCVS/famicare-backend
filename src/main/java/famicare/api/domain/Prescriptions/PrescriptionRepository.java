package famicare.api.domain.Prescriptions;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PrescriptionRepository extends JpaRepository<Prescriptions, Long> {

    List<listPrescriptionsData> findAllByRelativeId(Long id);
}
