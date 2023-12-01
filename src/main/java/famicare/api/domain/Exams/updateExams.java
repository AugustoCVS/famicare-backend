package famicare.api.domain.Exams;

import jakarta.validation.constraints.NotBlank;

public record updateExams(
        String type,
        String date,
        String result,
        String observations,
        String doctor
) {
}
