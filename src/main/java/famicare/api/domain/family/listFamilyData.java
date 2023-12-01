package famicare.api.domain.family;

public record listFamilyData(Long id, String name, String email) {

    public listFamilyData(Family family){
        this(family.getId(), family.getName(), family.getEmail());
    }

}
