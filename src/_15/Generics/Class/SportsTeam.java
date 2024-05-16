package _15.Generics.Class;

import java.util.ArrayList;
import java.util.List;

record Affiliation(String name, String type, String countryCode) {

    @Override
    public String toString() {
        return name + " (" + type + " in " + countryCode + ")";
    }
}
//Creating a generic class
public class SportsTeam<T extends Player, S> { //T & S are conventions,
    //extends Player ensures type T is a Player or a subtype of Player

    private String teamName;
    private List<T> teamMembers = new ArrayList<>();
    private int totalWins = 0;
    private int totalLosses = 0;
    private int totalTies = 0;
    private S affiliation;

    public SportsTeam(String teamName) {
        this.teamName = teamName;
    }

    public SportsTeam(String teamName, S affiliation) {
        this.teamName = teamName;
        this.affiliation = affiliation;
    }

    public void addTeamMember(T t) {

        if (!teamMembers.contains(t)) {
            teamMembers.add(t);
        }
    }

    public void listTeamMembers() {

        System.out.println(teamName + " Roster");
        if (affiliation != null) {
            System.out.println("AFFILIATION: "+ affiliation);
        }
        for (T t : teamMembers) {
            System.out.println(t.name());
        }
    }

    public int ranking() {
        return (totalLosses * 2) + totalTies + 1;
    }

    public String setScore(int ourScore, int theirScore) {

        String message = "lost to";
        if (ourScore > theirScore) {
            totalWins ++;
            message = "beat";
        } else if (ourScore == theirScore) {
            totalTies++;
            message = "tied with ";
        } else {
            totalLosses++;
        }
        return message;
    }

    @Override
    public String toString() {
        return teamName + " (Ranked " + ranking() + ")";
    }
}
