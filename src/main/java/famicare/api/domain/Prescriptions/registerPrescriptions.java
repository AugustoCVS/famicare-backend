package famicare.api.domain.Prescriptions;

import jakarta.validation.constraints.NotBlank;

public record registerPrescriptions(
        @NotBlank(message = "A data da receita não pode ser vazia")
        String date,
        @NotBlank(message = "O medicamento não pode ser vazio")
        String medicine,
        @NotBlank(message = "A dosagem não pode ser vazia")
        String dosage,
        @NotBlank(message = "A duracao não pode ser vazia")
        String duration,
        @NotBlank(message = "A instucoes não pode ser vazias")
        String instructions,
        @NotBlank(message = "O campo medico não pode ser vazio")
        String doctor
) {
}
