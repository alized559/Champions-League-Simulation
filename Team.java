import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;

public class Team {
  private String teamName;
  private String country;
  private Player[] players;
  private String formation;
  private int scoringAbility;
  private boolean won;

  /*
   * This constructor creates an array of players in the team
   * @param input  A scanner object that reads from file
  */
  public Team(Scanner input) {
    this.won = true;
    this.teamName = input.next();
    this.country = input.next();
    int numberPlayers = input.nextInt();
    this.players = new Player[numberPlayers];
    input.nextLine();
    for (int i = 0; i < numberPlayers; i++) {
      int jerseyNumber = input.nextInt();
      String position = input.next();
      String name = input.next();
      double scoringProb = input.nextDouble();
      this.players[i] = new Player(jerseyNumber, position, name, scoringProb);
    }
    this.formation = input.next();
  }

  // getter for country
  public String getCountry() {
    return this.country;
  }

  // getter for teamName
  public String getTeamName() {
    return this.teamName;
  }

  // getter for scoringAbility
  public int getScoringAbility() {
    return this.scoringAbility;
  }

  // getter for won
  public boolean getWon() {
    return this.won;
  }

  // setter for won
  public void setWon(boolean won) {
    this.won = won;
  }

  // This method decides whcih players are playing
  public void createFirstEleven() {
    int gk = 1; // always one goalkeeper
    int df = this.formation.charAt(0) - '0';
    int mf = this.formation.charAt(2) - '0';
    int fw = this.formation.charAt(4) - '0';
    for (int i = 0; i < players.length; i++) {
      String pos = this.players[i].getPosition();
      if (pos.equals("GK") && gk > 0) {
        gk--;
      } else if (pos.equals("DF") && df > 0) {
        df--;
      } else if (pos.equals("MF") && mf > 0) {
        mf--;
      } else if (pos.equals("FW") && fw > 0) {
        fw--;
      } else {
        break;
      }
      this.players[i].setIsPlaying(true);
      this.players[i].calcScoredGoals();
    }
  }

  // This method finds the scoring ability of the team
  public void scoringAbility() {
    for (int i = 0; i < this.players.length; i++) {
      if (this.players[i].getIsPlaying())
        this.scoringAbility += this.players[i].getScoredGoals();
    }
  }

  // This method returns the first player with max number of goals
  public Player getBestPlayer() {
    int max = Integer.MIN_VALUE;
    Player bestPlayer = null;
    for (int i = 0; i < this.players.length; i++) {
      if (this.players[i].getIsPlaying() == true) {
        if (this.players[i].getScoredGoals() > max) {
          max = this.players[i].getScoredGoals();
          bestPlayer = this.players[i];
        }
      }
    }
    return bestPlayer;
  }

  public String toString() {
    String s = "";
    for (int i = 0; i < this.players.length; i++) {
      s += this.players[i].toString() + "\n";
    }
    return this.teamName + ", " + this.country + ", " + this.players.length +
           "\n" + s;
  }
}
