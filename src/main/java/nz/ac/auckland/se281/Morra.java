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
    System.out.println(Integer.toString(numbers));
  }

  public void showStats() {}

  private boolean isValidInput(String[] input) {

    for (String value : input) {
      if (!Utils.isInteger(value)) {
        return false;
      }
    }

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
