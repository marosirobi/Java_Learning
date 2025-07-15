package model.generics;

interface Player{
    String name();
    String position();
}

record BaseballPlayer(String name, String position) implements Player{ }
record FootballPlayer(String name, String position) implements Player{ }
record VolleyballPlayer(String name, String position) implements Player{ }

public class Generics {

    public static void main(String[] args) {

        var philly = new Affiliation("city","Philadephia", "PA");
        BaseballTeam phillies1 = new BaseballTeam("Phillies");
        BaseballTeam astros1 = new BaseballTeam("Houston Astors");
        scoreResult(phillies1,2,astros1,5);

        SportsTeam phillies2 = new SportsTeam("Phillies");
        SportsTeam astros2 = new SportsTeam("Houston Astors");
        scoreResult(phillies2,2,astros2,5);

        Team<BaseballPlayer,Affiliation> phillies3 = new Team<BaseballPlayer,Affiliation>("Phillies",philly);
        Team<BaseballPlayer,Affiliation> astros3 = new Team<>("Houston Astors");
        scoreResult(phillies3,2,astros3,5);

        var harper = new BaseballPlayer("B Harper", "Right Fielder");
        var marsh = new BaseballPlayer("B Marsh", "Right Fielder");

        phillies3.addTeamMember(harper);
        phillies3.addTeamMember(marsh);

        phillies3.listTeamMembers();

        Team<FootballPlayer,String> rm = new Team<>("Real Madrid", "City of Madrid, Spain, in SP");
        var ron = new FootballPlayer("Ronaldo","Striker");

        rm.addTeamMember(ron);
        rm.listTeamMembers();

//        Team<String> badExample = new Team<String>("Real Madrid");
//        badExample.addTeamMember("Fred");
//        badExample.listTeamMembers();
    }

    public static void scoreResult(BaseballTeam team1, int score1,
                                   BaseballTeam team2, int score2){

        String message = team1.setScore(score1, score2);
        team2.setScore(score2, score1);

        System.out.printf("%s %s %s %n", team1, message, team2);
    }

    public static void scoreResult(SportsTeam team1, int score1,
                                   SportsTeam team2, int score2){

        String message = team1.setScore(score1, score2);
        team2.setScore(score2, score1);

        System.out.printf("%s %s %s %n", team1, message, team2);
    }

    public static void scoreResult(Team team1, int score1,
                                   Team team2, int score2){

        String message = team1.setScore(score1, score2);
        team2.setScore(score2, score1);

        System.out.printf("%s %s %s %n", team1, message, team2);
    }
}
