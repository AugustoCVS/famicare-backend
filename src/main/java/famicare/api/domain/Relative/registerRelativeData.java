package famicare.api.domain.Relative;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CPF;

public record registerRelativeData(
        @NotBlank(message = "O nome não pode ser vazio")
        String name,
        @NotBlank(message = "O email não pode ser vazio")
        @Email(message = "Email inválido")
        String email,
        @NotBlank(message = "O CPF não pode ser vazio")
        @CPF(message = "CPF inválido")
        String cpf,
        @NotBlank(message = "A senha não pode ser vazia")
        String password,
        @NotBlank(message = "A confirmação de senha não pode ser vazia")
        String confirm_password
) {
}
