package famicare.api.domain.Exams;

import jakarta.validation.constraints.NotBlank;

public record registerExams(
        @NotBlank(message = "O tipo de exame não pode ser vazio")
        String type,
        @NotBlank(message = "O data do exame não pode ser vazia")
        String date,
        @NotBlank(message = "O resultado do exame não pode ser vazio")
        String result,
        @NotBlank(message = "As observacoes do exame não pode ser vazias")
        String observations,
        @NotBlank(message = "O doutor do exame não pode ser vazio")
        String doctor
) {
}
