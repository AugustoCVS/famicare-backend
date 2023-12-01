package famicare.api.domain.appointments;

import famicare.api.domain.Relative.Relative;
import jakarta.persistence.*;

import java.util.Objects;

@Table(name = "appointments")
@Entity(name = "Appointments")
public class Appointments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String doctor;

    private String diagnostic;

    private String treatment;

    private String medicines;

    private String results;

    private String observations;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_relative")
    private Relative relative;

    public Appointments() {
    }

    public Appointments(Long id, String doctor, String diagnostic, String treatment, String medicines, String results, String observations, Relative relative) {
        this.id = id;
        this.doctor = doctor;
        this.diagnostic = diagnostic;
        this.treatment = treatment;
        this.medicines = medicines;
        this.results = results;
        this.observations = observations;
        this.relative = relative;
    }

    public Appointments(registerAppointments data) {
        this.diagnostic = data.diagnostic();
        this.doctor = data.doctor();
        this.treatment = data.treatment();
        this.medicines = data.medicines();
        this.results = data.results();
        this.observations = data.observations();
    }

    public void updateData(updateAppointments data) {

        if(data.diagnostic() != null ){
            this.diagnostic = data.diagnostic();
        }

        if(data.doctor() != null){
            this.doctor = data.doctor();
        }

        if(data.treatment() != null){
            this.treatment = data.treatment();
        }

        if(data.medicines() != null){
            this.medicines = data.medicines();
        }

        if(data.results() != null){
            this.results = data.results();
        }

        if(data.observations() != null){
            this.observations = data.observations();
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    public String getDiagnostic() {
        return diagnostic;
    }

    public void setDiagnostic(String diagnostic) {
        this.diagnostic = diagnostic;
    }

    public String getTreatment() {
        return treatment;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }

    public String getMedicines() {
        return medicines;
    }

    public void setMedicines(String medicines) {
        this.medicines = medicines;
    }

    public String getResults() {
        return results;
    }

    public void setResults(String results) {
        this.results = results;
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
        Appointments that = (Appointments) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
