package famicare.api.domain.healthAgenda;

import jakarta.validation.constraints.NotBlank;

public record registerHealthAgenda(
        @NotBlank(message = "O tipo não pode ser vazio")
        String type,
        @NotBlank(message = "A data não pode ser vazia")
        String date,
        @NotBlank(message = "O doutor não pode ser vazia")
        String doctor,
        @NotBlank(message = "O local não pode ser vazio")
        String local,
        @NotBlank(message = "As observacoes não podem ser vazias")
        String observations
) {
}
