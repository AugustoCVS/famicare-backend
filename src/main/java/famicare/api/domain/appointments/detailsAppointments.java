package famicare.api.domain.appointments;

public record detailsAppointments(
        String doctor,

        String diagnostic,

        String treatment,

        String medicines,

        String results,

        String observations
) {

    public detailsAppointments(Appointments appointments){
        this(
                appointments.getDoctor(),
                appointments.getDiagnostic(),
                appointments.getTreatment(),
                appointments.getMedicines(),
                appointments.getResults(),
                appointments.getObservations()
        );
    }

}
