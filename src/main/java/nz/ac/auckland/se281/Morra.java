package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Difficulty;

public class Morra {

  private int round;
  private Player currentPlayer;
  private AI AI = null;
  private int pointsToWin;
  // Players points in index 0, AI's points in index 1
  private int[] points = new int[] {0, 0};

  public Morra() {}

  public void newGame(Difficulty difficulty, int pointsToWin, String[] options) {
    currentPlayer = new Player(options[0]);
    MessageCli.WELCOME_PLAYER.printMessage(options[0]);
    round = 1;
    this.pointsToWin = pointsToWin;
    AI = AIFactory.createAI(difficulty);
  }

  public void play() {
    if (AI == null) {
      MessageCli.GAME_NOT_STARTED.printMessage();
      return;
    }
    MessageCli.START_ROUND.printMessage(Integer.toString(round));
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
    // Set relevant informtion to the player. Print message accordingly.
    currentPlayer.setFingers(Integer.parseInt(inputArray[0]));
    currentPlayer.setSum(Integer.parseInt(inputArray[1]));
    MessageCli.PRINT_INFO_HAND.printMessage(
        currentPlayer.getName(),
        Integer.toString(currentPlayer.getLatestFingers()),
        Integer.toString(currentPlayer.getSum()));

    int[] valuesAI = AI.play(currentPlayer);
    MessageCli.PRINT_INFO_HAND.printMessage(
        "Jarvis", Integer.toString(valuesAI[0]), Integer.toString(valuesAI[1]));

    int sum = valuesAI[0] + currentPlayer.getLatestFingers();

    if ((valuesAI[1] == sum) && (currentPlayer.getSum() != sum)) {
      MessageCli.PRINT_OUTCOME_ROUND.printMessage("AI_WINS");
      points[1]++;
      if (points[1] == pointsToWin) {
        MessageCli.END_GAME.printMessage("Jarvis", Integer.toString(round));
        AI = null;
        return;
      }
    } else if ((valuesAI[1] != sum) && (currentPlayer.getSum() == sum)) {
      MessageCli.PRINT_OUTCOME_ROUND.printMessage("HUMAN_WINS");
      points[0]++;
      if (points[0] == pointsToWin) {
        MessageCli.END_GAME.printMessage(currentPlayer.getName(), Integer.toString(round));
        AI = null;
        return;
      }
    } else {
      MessageCli.PRINT_OUTCOME_ROUND.printMessage("DRAW");
    }

    round++;
  }

  public void showStats() {
    if (AI == null) {
      MessageCli.GAME_NOT_STARTED.printMessage();
      return;
    }
    MessageCli.PRINT_PLAYER_WINS.printMessage(
        currentPlayer.getName(),
        Integer.toString(points[0]),
        Integer.toString(pointsToWin - points[0]));
    MessageCli.PRINT_PLAYER_WINS.printMessage(
        "Jarvis", Integer.toString(points[1]), Integer.toString(pointsToWin - points[1]));
  }

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
