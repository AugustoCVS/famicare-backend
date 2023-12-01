package famicare.api.domain.healthHistoric;

public record detailsHealthHistoric(
        String diagnostic,
        String treatment,
        String allergies,
        String results
) {

    public detailsHealthHistoric(HealthHistoric healthHistoric){
        this(
                healthHistoric.getDiagnostic(),
                healthHistoric.getTreatment(),
                healthHistoric.getAllergies(),
                healthHistoric.getResults());
    }

}
