package yes;

public class Players {

    private String name;
    private int runs;
    private int ballsFaced;
    private boolean isOut;

    public Players(String name) {
        this.name = name;
        this.runs = 0;
        this.ballsFaced = 0;
        this.isOut = false;
    }

    public void setName(String name) {
        if (name.isEmpty()) { System.out.println("Player name cannot be empty!"); }
        else { this.name = name; }
    }
    public void setOut() { this.isOut = true; }

    public int getRuns() { return runs; }
    public String getName() { return name; }
    public int getBallsFaced() { return ballsFaced; }

    public void addRuns(int runs) { this.runs += runs; }
    public void addBallFaced() { this.ballsFaced+=1; }

    public boolean isOut() { return isOut; }
    public double strikeRate() { return (ballsFaced > 0) ? (runs * 100.0 / ballsFaced) : 0.0; }


}

