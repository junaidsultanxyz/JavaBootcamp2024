package yes;

import java.util.ArrayList;

public class Teams {

    private String name;
    private ArrayList<Players> players;
    private int totalRuns;
    private int wickets;
    private int overs;

    public Teams(String name) {
        this.name = name;
        this.players = new ArrayList<>();
        this.totalRuns = 0;
        this.wickets = 0;
        this.overs = 0;
    }

    public void setName(String name) {
        if (name.isEmpty()) { System.out.println("Team name cannot be empty!"); }
        else { this.name = name; }
    }

    public ArrayList<Players> getPlayers() { return players; }
    public String getName() {return name; }
    public int getTotalRuns() { return totalRuns; }
    public int getWickets() { return wickets; }
    public int getOvers() { return overs; }

    public void addWickets() { this.wickets+=1; }
    public void addPlayer(Players player) { this.players.add(player); }
    public void addRuns(int runs) { this.totalRuns += runs; }
    public void addOvers() { this.overs+=1; }
}
