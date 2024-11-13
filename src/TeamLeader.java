import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class TeamLeader extends TeamMember {

    private List<TeamMember> members;

    public TeamLeader(String nombre) {
        super(nombre);
        members = new ArrayList<>();
    }

    public boolean isMember(TeamMember tm) {
        if (tm == null || !members.contains(tm))
            return false;

        return true;
    }

    public boolean add(TeamMember tm) {
        if (tm == null ||
                !(tm instanceof TeamMember) ||
                !(tm instanceof TeamWriter) ||
                this.isMember(tm)) {
            return false;
        }
        members.add(tm);
        return true;
    }

    public boolean remove(int id) {
        if (id <= 0)
            return false;

        Iterator<TeamMember> iterador = members.iterator();

        while (iterador.hasNext()) {
            TeamMember tm = iterador.next();
            if (tm.getId() == id) {
                iterador.remove();
                return true;
            }
        }
        return false;
    }

    public List<TeamMember> getMembers() {
        List<TeamMember> lista = new ArrayList<>(members);

        Collections.sort(lista, (t1, t2) -> {
            int result = t1.getName().compareTo(t2.getName());
            if (result == 0)
                return Integer.compare(t1.getId(), t2.getId());
            return result;
        });

        return lista;
    }

    @Override
    public String getDuties() {

        if (members.isEmpty())
            return "EQUIPO VACÍO";

        String result = "";
        for (TeamMember tm : members) {
            result = result + ("Responsable de: " + tm.getDuties() + "\n");
        }

        return result;

    }

}