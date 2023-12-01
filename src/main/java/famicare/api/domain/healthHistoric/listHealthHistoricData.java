package famicare.api.domain.healthHistoric;

public record listHealthHistoricData(
        Long id,
        String diagnostic,
        String treatment,
        String allergies,
        String results
) {
    public listHealthHistoricData(HealthHistoric healthHistoric){
        this(
                healthHistoric.getId(),
                healthHistoric.getDiagnostic(),
                healthHistoric.getTreatment(),
                healthHistoric.getAllergies(),
                healthHistoric.getResults()
        );
    }

}
