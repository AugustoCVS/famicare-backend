package famicare.api.domain.Relative;

public record listRelativeData(Long id, String name, String cpf, String email) {
    public listRelativeData(Relative relative){
        this(relative.getId(), relative.getCpf(), relative.getName(), relative.getEmail());
    }
}
