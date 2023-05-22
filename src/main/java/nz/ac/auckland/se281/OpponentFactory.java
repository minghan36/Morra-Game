package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Difficulty;

public class OpponentFactory {

  public static Opponent createOpponent(Difficulty difficulty) {
    //switch case to set the difficulty of the AI
    switch (difficulty) {
      case EASY:
        return new EasyOpponent();
      case MEDIUM:
        return new MediumOpponent();
      case HARD:
        return new HardOpponent();
      case MASTER:
        return new MasterOpponent();
    }
    return null;
  }
}
