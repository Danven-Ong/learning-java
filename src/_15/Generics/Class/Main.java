package _15.Generics.Class;

import java.lang.annotation.AnnotationFormatError;

interface Player {

    String name();
}
record BaseballPlayer(String name, String position) implements Player{}
record FootballPlayer(String name, String position) implements Player{}

public class Main {
    public static void main(String[] args) {

        Affiliation philly = new Affiliation("city", "Philadelphia, PA", "US");

        BaseballTeam phillies1 = new BaseballTeam("Philadelphia Phillies");
        BaseballTeam astros1 = new BaseballTeam("Houston Astros");
        scoreResult(phillies1, 3, astros1, 5);
        //prints "Philadelphia Phillies (Ranked 3) lost to Houston Astros (Ranked 1)"

        //Generic class is encouraged to include type parameter
        SportsTeam<BaseballPlayer, Affiliation> phillies = new SportsTeam<>("Philadelphia Phillies",
                philly);
        SportsTeam<BaseballPlayer, Affiliation> astros = new SportsTeam<>("Houston Astros");
        scoreResult(phillies, 3, astros, 5);
        //prints "Philadelphia Phillies (Ranked 3) lost to Houston Astros (Ranked 1)"

        var harper =  new BaseballPlayer("B Harper", "Right Fielder");
        var marsh = new BaseballPlayer("B Marsh", "Right Fielder");
        phillies.addTeamMember(harper);
        phillies.addTeamMember(marsh);
        phillies.listTeamMembers();
        //prints
        //"Philadelphia Phillies Roster"
        //"AFFILIATION: city (Philadelphia, PA in US)"
        //"B Harper"
        //"B Marsh"

        //A generic class allows different types to be accepted (except primitive types)
        SportsTeam<FootballPlayer, Affiliation> afc = new SportsTeam<>("Adelaide Crows");
        var tex = new FootballPlayer("Tex", "Centre half forward");
        afc.addTeamMember(tex);
        afc.listTeamMembers();
        //prints
        //"Adelaide Crows Roster"
        //"tex"

    }

    public static void scoreResult(BaseballTeam team1, int t1_score,
                                   BaseballTeam team2, int t2_score) {
        String message = team1.setScore(t1_score, t2_score);
        team2.setScore(t2_score, t1_score);
        System.out.printf("%s %s %s%n", team1, message, team2);
    }


    public static void scoreResult(SportsTeam team1, int t1_score,
                                   SportsTeam team2, int t2_score) {
        String message = team1.setScore(t1_score, t2_score);
        team2.setScore(t2_score, t1_score);
        System.out.printf("%s %s %s%n", team1, message, team2);
    }

}
