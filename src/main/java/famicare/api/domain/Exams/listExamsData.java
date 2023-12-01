package famicare.api.domain.Exams;

import famicare.api.domain.appointments.Appointments;

public record listExamsData(
        Long id,
        String type,

        String date,

        String result,

        String observations,

        String doctor
) {

    public listExamsData(Exams exams){
        this(
                exams.getId(),
                exams.getType(),
                exams.getDate(),
                exams.getResult(),
                exams.getObservations(),
                exams.getDoctor()
        );
    }
}
