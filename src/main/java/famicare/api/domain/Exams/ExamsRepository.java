package famicare.api.domain.Exams;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExamsRepository extends JpaRepository<Exams, Long> {
    List<listExamsData> findAllByRelativeId(Long id);
}
