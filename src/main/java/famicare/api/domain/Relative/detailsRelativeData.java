package famicare.api.domain.Relative;

public record detailsRelativeData(Long id, String name, String cpf, String email) {
    public detailsRelativeData(Relative relative){
        this(relative.getId(),relative.getName() ,relative.getCpf() , relative.getEmail());
    }
}
