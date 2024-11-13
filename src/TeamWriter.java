public class TeamWriter extends TeamMember {

    public TeamWriter(String nombre) {
        super(nombre);
    }

    @Override
    public String getDuties() {
        return this.getId() + ", " + this.getName() + ", " + "Redactar documentación";
    }

}