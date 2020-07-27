public class Player {
  private int jerseyNumber;
  private String position;
  private String name;
  private int scoredGoals;
  private double scoringProb;
  private boolean isPlaying;

  // Constructor
  public Player(int jerseyNumber, String position, String name,
                double scoringProb) {

    this.jerseyNumber = jerseyNumber;
    this.position = position;
    this.name = name;
    this.scoringProb = scoringProb;
    this.scoredGoals = 0;
    this.isPlaying = false;
  }

  // getter for scoredGoals
  public int getScoredGoals() {
    return this.scoredGoals;
  }

  // this method calculates/updates the value of scoredGoals
  public void calcScoredGoals() {
    double rand = Math.random();
    if (rand <= this.scoringProb) {
      this.scoredGoals++;
    }
  }

  // getter for scoringProb
  public double getScoringProb() {
    return this.scoringProb;
  }

  // setter for scoringProb
  public void setScoringProb(double scoringProb) {
    this.scoringProb = scoringProb;
  }

  // getter for isPlaying
  public boolean getIsPlaying() {
    return this.isPlaying;
  }

  // setter for isPlaying
  public void setIsPlaying(boolean isPlaying) {
    this.isPlaying = isPlaying;
  }

  // getter for position
  public String getPosition() {
    return this.position;
  }

  public String toString() {
    return "[" + this.name + ", " + this.jerseyNumber + ", " + this.position
      + ", " + this.scoredGoals + ", "
      + (this.isPlaying ? "playing]" : "substitute]");
  }
}
