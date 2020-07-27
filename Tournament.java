import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Tournament {
  private Team[] teams;

  /*
   * This constructor creates an array of teams
   * @param numOfTeams  The number of teams
  */
  public Tournament(int numOfTeams) throws FileNotFoundException {
    this.teams = new Team[numOfTeams];
    Scanner input = new Scanner(new File("Teams.txt"));
    for (int i = 0; i < this.teams.length; i++) {
      this.teams[i] = new Team(input);
    }
  }

  // This method creates the formation of t1 and t2, it also gets the winner by
  // scoring ability
  public void play(Team t1, Team t2) {
    t1.createFirstEleven();
    t2.createFirstEleven();
    int score1 = t1.getScoringAbility();
    int score2 = t2.getScoringAbility();
    if (score1 >= score2) {
      System.out.println(t1.getTeamName() + " beats " + t2.getTeamName());
      t2.setWon(false);
    } else {
      // score2 > score1
      System.out.println(t2.getTeamName() + " beats " + t1.getTeamName());
      t1.setWon(false);
    }
  }

  // This method simulates the tournament
  public void run() {
    Team[] winners = this.teams;
    while (winners.length > 1) {
      Team[] nextRound = new Team[winners.length / 2];
      for (int i = 0; i < winners.length - 1; i += 2) {
        Team t1 = winners[i], t2 = winners[i + 1];
        play(t1, t2);
        nextRound[i / 2] = t1.getWon() ? t1 : t2;
      }
      winners = nextRound;
    }
    System.out.println("The Championship goes to:");
    System.out.println(winners[0]);
    System.out.println("Player of the tournament: " + winners[0].getBestPlayer());
  }

  public static void main(String[] args) throws FileNotFoundException {
    Tournament championsLeague = new Tournament(4);
    championsLeague.run();
  }
}
