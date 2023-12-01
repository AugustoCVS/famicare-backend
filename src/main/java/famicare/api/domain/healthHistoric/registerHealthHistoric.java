package famicare.api.domain.healthHistoric;

import jakarta.validation.constraints.NotBlank;

public record registerHealthHistoric(
        @NotBlank(message = "As doenças não podem ser vazias")
        String diagnostic,

        @NotBlank(message = "O tratamento não pode ser vazio")
        String treatment,

        @NotBlank(message = "As alergias não podem ser vazias")
        String allergies,

        @NotBlank(message = "Os resultados de exames não podem ser vazios")
        String results

) {
}
