package famicare.api.domain.family;

import jakarta.validation.constraints.NotNull;

public record updateFamilyData(
        String name,
        String email
    ) {
}
