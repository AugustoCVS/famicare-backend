package famicare.api.domain.family;

public record detailsFamilyData(Long id, String name, String email) {

    public detailsFamilyData(Family family){
        this(family.getId(), family.getName(), family.getEmail());
    }

}
