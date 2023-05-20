package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Difficulty;

public class Morra {

  private int round;
  private Player currentPlayer;

  public Morra() {}

  public void newGame(Difficulty difficulty, int pointsToWin, String[] options) {
    currentPlayer = new Player(options[0]);
    MessageCli.WELCOME_PLAYER.printMessage(options[0]);
    round = 1;
  }

  public void play() {
    MessageCli.START_ROUND.printMessage(Integer.toString(round));
    round++;
    MessageCli.ASK_INPUT.printMessage();
    String input = Utils.scanner.nextLine();
    String[] inputArray = input.trim().split(" ");
    // Game asks for Input until user inputs valid values.
    while (!isValidInput(inputArray)) {
      MessageCli.INVALID_INPUT.printMessage();
      MessageCli.ASK_INPUT.printMessage();
      input = Utils.scanner.nextLine();
      inputArray = input.trim().split(" ");
    }
    currentPlayer.setFingers(Integer.parseInt(inputArray[0]));
    currentPlayer.setSum(Integer.parseInt(inputArray[1]));
    MessageCli.PRINT_INFO_HAND.printMessage(
        currentPlayer.getName(),
        Integer.toString(currentPlayer.getLatestFingers()),
        Integer.toString(currentPlayer.getSum()));
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
