public class Competitor {
    private int teamNumber;
    private int weight;
    private int exp;
    private String name;
    private int powerLevel;

    public Competitor(int teamNumber, String name, int weight, int exp) {
        this.teamNumber = teamNumber;
        this.weight = weight;
        this.exp = exp;
        this.name = name;
        powerLevel = weight / 20 + exp;
    }
    public int getTeamNumber() {
        return teamNumber;
    }
    public int getWeight() {
        return weight;
    }
    public int getExp() {
        return exp;
    }
    public String getName() {
        return name;
    }
    public int getPowerLevel() {
        return powerLevel;
    }
    public String toString() {
        String team = "";
        switch (teamNumber) {
            case 1:
                team = "Georgia Tech";
                break;
            case 2:
                team = "Emory";
                break;
            case 3:
                team = "Georgia State";
        }
        return String.format("%s is on %s's team, weighs %d pounds, and has %d years of experience",
                name, team, weight, exp);
    }
}