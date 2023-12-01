package famicare.api.domain.healthAgenda;

import famicare.api.domain.Prescriptions.registerPrescriptions;
import famicare.api.domain.Prescriptions.updatePrescription;
import famicare.api.domain.Relative.Relative;
import jakarta.persistence.*;

import java.util.Objects;

@Table(name="agenda")
@Entity(name="Agenda")
public class HealthAgenda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;

    private String date;

    private String doctor;

    private String local;

    private String observations;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_relative")
    private Relative relative;

    public HealthAgenda(registerHealthAgenda data) {
        this.type = data.type();
        this.date = data.date();
        this.doctor = data.doctor();
        this.local = data.local();
        this.observations = data.observations();
    }

    public void updateData(updateHealthAgendaData data) {

        if(data.type() != null ){
            this.type = data.type();
        }

        if(data.date() != null){
            this.date = data.date();
        }

        if(data.doctor() != null){
            this.doctor = data.doctor();
        }

        if(data.local() != null){
            this.local = data.local();
        }

        if(data.observations() != null){
            this.observations = data.observations();
        }
    }

    public HealthAgenda() {
    }

    public HealthAgenda(Long id, String type, String date, String doctor, String local, String observations, Relative relative) {
        this.id = id;
        this.type = type;
        this.date = date;
        this.doctor = doctor;
        this.local = local;
        this.observations = observations;
        this.relative = relative;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }

    public Relative getRelative() {
        return relative;
    }

    public void setRelative(Relative relative) {
        this.relative = relative;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HealthAgenda that = (HealthAgenda) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
