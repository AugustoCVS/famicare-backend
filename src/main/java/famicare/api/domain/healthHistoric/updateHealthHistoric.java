package famicare.api.domain.healthHistoric;

public record updateHealthHistoric(
        String diagnostic,
        String treatment,
        String allergies,
        String results) {
}
