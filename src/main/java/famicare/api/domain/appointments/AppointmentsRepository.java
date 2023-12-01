package famicare.api.domain.appointments;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AppointmentsRepository extends JpaRepository<Appointments, Long> {

    List<listAppointmentsData> findAllByRelativeId(Long id);
}
