package famicare.api.domain.Exams;

import famicare.api.domain.appointments.Appointments;

public record detailsExams(
        String type,

        String date,

        String result,

        String observations,

        String doctor
) {

    public detailsExams(Exams exams){
        this(
                exams.getType(),
                exams.getDate(),
                exams.getResult(),
                exams.getObservations(),
                exams.getDoctor()
        );
    }
}
