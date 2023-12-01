package famicare.api.domain.healthAgenda;

import famicare.api.domain.Prescriptions.Prescriptions;

public record detailsHealthAgenda(
        String type,

        String date,

        String doctor,

        String local,

        String observations
) {

    public detailsHealthAgenda(HealthAgenda healthAgenda){
        this(
                healthAgenda.getType(),
                healthAgenda.getDate(),
                healthAgenda.getDoctor(),
                healthAgenda.getLocal(),
                healthAgenda.getObservations()

        );
    }
}
