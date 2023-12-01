package famicare.api.domain.healthAgenda;

import jakarta.validation.constraints.NotBlank;

public record updateHealthAgendaData(
        String type,
        String date,
        String doctor,
        String local,
        String observations
) {
}
