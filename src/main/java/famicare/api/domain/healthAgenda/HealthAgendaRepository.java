package famicare.api.domain.healthAgenda;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HealthAgendaRepository extends JpaRepository<HealthAgenda, Long> {
    List<listHealthAgendaData> findAllByRelativeId(Long id);
}
