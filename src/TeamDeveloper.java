public class TeamDeveloper extends TeamMember {
    private String technology;

    public TeamDeveloper(String nombre, String technology) {
        super(nombre);
        this.technology = technology;
    }

    public String getTechnology() {
        return this.technology;
    }

    @Override
    public String getDuties() {
        return this.getId() + ", " + this.getName() + ", " + this.technology;
    }

}