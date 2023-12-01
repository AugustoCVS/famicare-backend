package famicare.api.domain.healthAgenda;

public record listHealthAgendaData(
        Long id,
        String type,

        String date,

        String doctor,

        String local,

        String observations
) {

    public listHealthAgendaData(HealthAgenda healthAgenda){
        this(
                healthAgenda.getId(),
                healthAgenda.getType(),
                healthAgenda.getDate(),
                healthAgenda.getDoctor(),
                healthAgenda.getLocal(),
                healthAgenda.getObservations()

        );
    }
}
