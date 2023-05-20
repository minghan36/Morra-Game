package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Difficulty;

public class Morra {

  private int round;

  public Morra() {}

  public void newGame(Difficulty difficulty, int pointsToWin, String[] options) {
    MessageCli.WELCOME_PLAYER.printMessage(options[0]);
    round = 1;
  }

  public void play() {
    MessageCli.START_ROUND.printMessage(Integer.toString(round));
    round++;
    MessageCli.ASK_INPUT.printMessage();
    String input = Utils.scanner.nextLine();
    String[] inputArray = input.trim().split(" ");
    //Game asks for Input until user inputs valid values.
    while (!isValidInput(inputArray)) {
      MessageCli.INVALID_INPUT.printMessage();
      MessageCli.ASK_INPUT.printMessage();
      String inputs = Utils.scanner.nextLine();
      String[] inputsArray = input.trim().split(" ");
    }
  }

  public void showStats() {}

  private boolean isValidInput(String[] input) {
    // Checks that all inputs are integers
    for (String value : input) {
      if (!Utils.isInteger(value)) {
        return false;
      }
    }
    // Checks for other conditions of input
    if ((input.length != 2)
        || (Integer.parseInt(input[0]) < 1)
        || (Integer.parseInt(input[0]) > 5)
        || (Integer.parseInt(input[1]) < 1)
        || (Integer.parseInt(input[1]) > 10)) {
      return false;
    }

    return true;
  }
}
