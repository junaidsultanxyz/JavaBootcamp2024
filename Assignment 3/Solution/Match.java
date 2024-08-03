package yes;

import java.util.Random;
import static java.lang.Math.round;

public class Match {

    private Teams team1;
    private Teams team2;
    private Teams battingFirst;
    private Teams battingSecond;

    public Match(Teams team1, Teams team2) {
        this.team1 = team1;
        this.team2 = team2;
        this.battingFirst = null;
        this.battingSecond = null;
    }

    public void setTeam1(Teams team1) { this.team1 = team1; }
    public Teams getTeam1() { return team1; }


    public void setTeam2(Teams team2) { this.team2 = team2; }
    public Teams getTeam2() { return team2; }


    public void setBattingFirst(Teams battingFirst) { this.battingFirst = battingFirst; }
    public Teams getBattingFirst() { return battingFirst; }


    public void setBattingSecond(Teams battingSecond) { this.battingSecond = battingSecond; }
    public Teams getBattingSecond() { return battingSecond; }


    public void Toss() {
        Random random = new Random();
        if (random.nextBoolean()) {
            battingFirst = team1;
            battingSecond = team2;
        } else {
            battingFirst = team2;
            battingSecond = team1;
        }
        System.out.println(battingFirst.getName() + " will bat first.");
    }

    public void playInnings(Teams team) {
        Random random = new Random();
        for (int over = 1; over <= 20; over++) {
            System.out.println("Over " + over + ":");
            for (int ball = 1; ball <= 6; ball++) {
                int run = random.nextInt(7);
                boolean wicket = random.nextBoolean();
                Players currentBatsman = team.getPlayers().get(team.getWickets());
                if (wicket) {
                    System.out.println("Wicket -> " + currentBatsman.getName() + " is out!");
                    currentBatsman.setOut();
                    team.addWickets();
                    if (team.getWickets() == 11) {
                        System.out.println("All out!");
                        return;  // Exit innings if all players are out
                    }
                } else {
                    System.out.println("Ball " + ball + ":");
                    currentBatsman.addRuns(run);
                    currentBatsman.addBallFaced();
                    team.addRuns(run);
                }
            }
            team.addOvers();
        }
    }

    public void displayScorecard(Teams team)
    {
        System.out.println("Stats of " + team.getName() + " :");

        for (int i=0 ; i<team.getPlayers().size() ; i++)
        {
            Players player=team.getPlayers().get(i);
            System.out.println(player.getName() + ": " + player.getRuns() + " runs, " + player.getBallsFaced() + " balls \nStrike Rate: " + round(player.strikeRate()));
        }
        System.out.println("Total Runs: (" + team.getTotalRuns() + ") and wickets (" + team.getWickets() + ") in " + team.getOvers() + " overs");
    }

    public void declareWinner() {
        if (team1.getTotalRuns() > team2.getTotalRuns()) {
            System.out.println(team1.getName() + " is winner. Score : " + team1.getTotalRuns());
        }
        else if (team2.getTotalRuns() > team1.getTotalRuns()) {
            System.out.println(team2.getName() + " is winner. Score : " + team2.getTotalRuns());
        }
        else {
            System.out.println("Match tied");
        }
    }
}

