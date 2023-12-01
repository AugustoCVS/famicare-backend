package famicare.api.domain.Prescriptions;

public record listPrescriptionsData(
        Long id,
        String date,

        String medicine,

        String dosage,

        String duration,

        String instructions,

        String doctor
) {

    public listPrescriptionsData(Prescriptions prescriptions){
        this(
                prescriptions.getId(),
                prescriptions.getDate(),
                prescriptions.getMedicine(),
                prescriptions.getDosage(),
                prescriptions.getDuration(),
                prescriptions.getInstructions(),
                prescriptions.getDoctor()

        );
    }
}
