package famicare.api.domain.Relative;

import famicare.api.domain.Exams.Exams;
import famicare.api.domain.Prescriptions.Prescriptions;
import famicare.api.domain.appointments.Appointments;
import famicare.api.domain.family.Family;
import famicare.api.domain.healthHistoric.HealthHistoric;
import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Table(name="relative")
@Entity(name="Relative")
public class Relative {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String cpf;
    private String password;
    private String confirm_password;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_family")
    private Family family;


    @OneToMany(mappedBy = "relative", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<HealthHistoric> healthHistoric;

    @OneToMany(mappedBy = "relative", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Appointments> appointments;

    @OneToMany(mappedBy = "relative", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Exams> exams;

    @OneToMany(mappedBy = "relative", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Prescriptions> prescriptions;


    public Relative() {
    }

    public Relative(registerRelativeData data){
        this.name = data.name();
        this.email = data.email();
        this.cpf = data.cpf();
        this.password = data.password();
        this.confirm_password = data.confirm_password();
    }

    public void updateData(updateRelativeData data){
        if(data.cpf() != null){
            this.cpf = data.cpf();
        }

        if( data.name() != null ) {
            this.name = data.name();
        }

        if(data.email() != null){
            this.email = data.email();
        }

    }

    public Relative(Long id, String name, String email, String cpf, String password, String confirm_password, Family family) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.cpf = cpf;
        this.password = password;
        this.confirm_password = confirm_password;
        this.family = family;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirm_password() {
        return confirm_password;
    }

    public void setConfirm_password(String confirm_password) {
        this.confirm_password = confirm_password;
    }

    public Family getFamily() {
        return family;
    }

    public void setFamily(Family family) {
        this.family = family;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Relative relative = (Relative) o;
        return Objects.equals(id, relative.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
