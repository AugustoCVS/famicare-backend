package famicare.api.domain.appointments;

public record listAppointmentsData(
        Long id,

        String doctor,

        String diagnostic,

        String treatment,

        String medicines,

        String results,

        String observations
) {

    public listAppointmentsData(Appointments appointments){
        this(
                appointments.getId(),
                appointments.getDoctor(),
                appointments.getDiagnostic(),
                appointments.getTreatment(),
                appointments.getMedicines(),
                appointments.getResults(),
                appointments.getObservations()
        );
    }
}
