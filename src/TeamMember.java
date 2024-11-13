public abstract class TeamMember {

    private String nombre;
    private static int contador = 0;
    private int id;

    public TeamMember(String nombre) {
        this.nombre = nombre;
        this.id = getUniqueId();
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.nombre;
    }

    @Override
    public String toString() {
        return this.id + ", " + this.nombre;
    }

    public abstract String getDuties();

    public int getUniqueId() {
        return contador++;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || !(o instanceof TeamMember))
            return false;

        if (this == o)
            return true;

        TeamMember tm = (TeamMember) o;

        return this.id == tm.getId();

    }

    @Override
    public int hashCode() {
        return 31 * this.id;
    }

}