package famicare.api.domain.appointments;

import jakarta.validation.constraints.NotBlank;

public record updateAppointments(
        String doctor,
        String diagnostic,
        String treatment,
        String medicines,
        String results,
        String observations
) {
}
