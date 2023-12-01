package famicare.api.domain.Prescriptions;

import jakarta.validation.constraints.NotBlank;

public record updatePrescription(

        String date,

        String medicine,

        String dosage,

        String duration,

        String instructions,
        String doctor
) {
}
