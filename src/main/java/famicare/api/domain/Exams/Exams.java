package famicare.api.domain.Exams;

import famicare.api.domain.Relative.Relative;
import jakarta.persistence.*;

import java.util.Objects;

@Table(name = "exams")
@Entity(name = "exams")
public class Exams {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;

    private String date;

    private String result;

    private String observations;

    private String doctor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_relative")
    private Relative relative;

    public Exams(registerExams data) {
        this.type = data.type();
        this.date = data.date();
        this.doctor = data.doctor();
        this.result = data.result();
        this.observations = data.observations();
    }

    public void updateData(updateExams data) {

        if(data.type() != null ){
            this.type = data.type();
        }

        if(data.date() != null){
            this.date = data.date();
        }

        if(data.doctor() != null){
            this.doctor = data.doctor();
        }

        if(data.result() != null){
            this.result = data.result();
        }

        if(data.observations() != null){
            this.observations = data.observations();
        }

    }

    public Exams() {
    }

    public Exams(Long id, String type, String date, String result, String observations, String doctor, Relative relative) {
        this.id = id;
        this.type = type;
        this.date = date;
        this.result = result;
        this.observations = observations;
        this.doctor = doctor;
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

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
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
        Exams exams = (Exams) o;
        return Objects.equals(id, exams.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
