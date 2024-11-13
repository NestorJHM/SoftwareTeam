import java.util.List;

public class UseTeamMember {

    public static void main(String[] args) {

        TeamLeader leader = new TeamLeader("The Leader");
        System.out.println(String.format("TeamLeader [%d, %s]", leader.getId(), leader.getName()));
        TeamWriter writer = new TeamWriter("TeamWriter");
        System.out.println("Writer#toString: " + writer);
        System.out.println("Writer#getDuties: " + writer.getDuties());
        TeamDeveloper dev = new TeamDeveloper("TeamDeveloper", "Java");
        System.out.println("Dev#toString: " + dev);
        System.out.println("Dev#getDuties: " + dev.getDuties());

        System.out.printf("Adding writer to the team: %b\n", leader.add(writer));
        System.out.printf("Removing writer from the team: %b\n",
                leader.remove(writer.getId()));
        System.out.printf("Removing unexistent member: %s\n", !leader.remove(1000) ? "works!" : "error");
        leader = new TeamLeader("The Leader");
        leader.add(new TeamDeveloper("Emily Smith", "Javascript"));
        leader.add(new TeamDeveloper("James", "Java"));
        leader.add(new TeamDeveloper("Guido van Rossum", "Python"));
        leader.add(new TeamWriter("Anthony"));
        leader.add(new TeamWriter("Blunt Doe"));

        List<TeamMember> members = leader.getMembers();
        System.out.println("\nNombres ordenados del equipo: ");
        members.stream().forEach(m -> System.out.println(m.getName()));
        System.out.println("\nResponsabilidades de TeamLeader: ");
        System.out.println(leader.getDuties());

    }
}