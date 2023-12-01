package famicare.api.domain.appointments;

import jakarta.validation.constraints.NotBlank;

public record registerAppointments(
        @NotBlank(message = "O campo doutor não pode ser vazio")
        String doctor,
        @NotBlank(message = "O campo diagnostico não pode ser vazio")
        String diagnostic,
        @NotBlank(message = "O campo tratamento não pode ser vazio")
        String treatment,
        @NotBlank(message = "O campo remedios não pode ser vazio")
        String medicines,
        @NotBlank(message = "O campo resultados não pode ser vazio")
        String results,
        @NotBlank(message = "O campo observacoes não pode ser vazio")
        String observations
) {
}
