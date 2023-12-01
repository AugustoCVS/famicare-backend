package famicare.api.domain.healthHistoric;

import famicare.api.domain.Relative.Relative;
import jakarta.persistence.*;

import java.util.Objects;

@Table(name = "historic")
@Entity(name = "Historic")
public class HealthHistoric {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String diagnostic;

    private String treatment;

    private String allergies;

    private String results;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_relative")
    private Relative relative;

    public HealthHistoric() {
    }

    public HealthHistoric(registerHealthHistoric data) {
        this.diagnostic = data.diagnostic();
        this.treatment = data.treatment();
        this.allergies = data.allergies();
        this.results = data.results();
    }

    public void updateData(updateHealthHistoric data){
        if(data.diagnostic() != null){
            this.diagnostic = data.diagnostic();
        }

        if(data.treatment() != null){
            this.treatment = data.treatment();
        }

        if(data.allergies() != null){
            this.allergies = data.allergies();
        }

        if(data.results() != null){
            this.results = data.results();
        }
    }

    public HealthHistoric(Long id, String diagnostic, String treatment, String allergies, String results,  Relative relative) {
        this.id = id;
        this.diagnostic = diagnostic;
        this.treatment = treatment;
        this.allergies = allergies;
        this.results = results;
        this.relative = relative;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
    public String getAllergies() {
        return allergies;
    }
    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }
    public String getResults() {
        return results;
    }
    public void setResults(String results) {
        this.results = results;
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
        HealthHistoric that = (HealthHistoric) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
