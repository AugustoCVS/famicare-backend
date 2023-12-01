package famicare.api.domain.Prescriptions;

import famicare.api.domain.Exams.Exams;

public record detailsPrescriptions(
        String date,

        String medicine,

        String dosage,

        String duration,

        String instructions,

        String doctor
) {

    public detailsPrescriptions(Prescriptions prescriptions){
        this(
                prescriptions.getDate(),
                prescriptions.getMedicine(),
                prescriptions.getDosage(),
                prescriptions.getDuration(),
                prescriptions.getInstructions(),
                prescriptions.getDoctor()

        );
    }
}
