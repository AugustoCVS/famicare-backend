package famicare.api.domain.healthHistoric;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HealthHistoricRepository extends JpaRepository<HealthHistoric, Long> {

    List<listHealthHistoricData> findAllByRelativeId(Long id);

}
