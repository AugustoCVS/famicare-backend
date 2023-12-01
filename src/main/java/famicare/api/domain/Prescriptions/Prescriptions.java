package famicare.api.domain.Prescriptions;

import famicare.api.domain.Relative.Relative;
import jakarta.persistence.*;

import java.util.Objects;

@Table(name = "prescriptions")
@Entity(name = "Prescriptions")
public class Prescriptions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String date;

    private String medicine;

    private String dosage;

    private String duration;

    private String instructions;

    private String doctor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_relative")
    private Relative relative;

    public Prescriptions(registerPrescriptions data) {
        this.date = data.date();
        this.medicine = data.medicine();
        this.dosage = data.dosage();
        this.duration = data.duration();
        this.instructions = data.instructions();
        this.doctor = data.doctor();
    }

    public void updateData(updatePrescription data) {

        if(data.date() != null ){
            this.date = data.date();
        }

        if(data.medicine() != null){
            this.medicine = data.medicine();
        }

        if(data.dosage() != null){
            this.dosage = data.dosage();
        }

        if(data.duration() != null){
            this.duration = data.duration();
        }

        if(data.instructions() != null){
            this.instructions = data.instructions();
        }

        if(data.doctor() != null){
            this.doctor = data.doctor();
        }
    }

    public Prescriptions() {
    }

    public Prescriptions(Long id, String date, String medicine, String dosage, String duration, String instructions, String doctor, Relative relative) {
        this.id = id;
        this.date = date;
        this.medicine = medicine;
        this.dosage = dosage;
        this.duration = duration;
        this.instructions = instructions;
        this.doctor = doctor;
        this.relative = relative;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMedicine() {
        return medicine;
    }

    public void setMedicine(String medicine) {
        this.medicine = medicine;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
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
        Prescriptions that = (Prescriptions) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
