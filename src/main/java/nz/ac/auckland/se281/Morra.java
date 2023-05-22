package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Difficulty;

public class Morra {

  private int round;
  private Player currentPlayer;
  private Opponent opponent = null;
  private int pointsToWin;
  // Players points in index 0, AI's points in index 1
  private int[] points = new int[] {0, 0};

  public Morra() {}

  public void newGame(Difficulty difficulty, int pointsToWin, String[] options) {
    currentPlayer = new Player(options[0]);
    MessageCli.WELCOME_PLAYER.printMessage(options[0]);
    round = 1;
    this.pointsToWin = pointsToWin;
    opponent = OpponentFactory.createOpponent(difficulty);
  }

  public void play() {
    if (opponent == null) {
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
    //Create values for the AI for fingers and sum using the relevant strategy
    int[] valuesOpponent = opponent.play(currentPlayer);
    MessageCli.PRINT_INFO_HAND.printMessage(
        "Jarvis", Integer.toString(valuesOpponent[0]), Integer.toString(valuesOpponent[1]));

    int sum = valuesOpponent[0] + currentPlayer.getLatestFingers();
    //Compares number of fingers to sum to decide whether the round is a draw, or win for either side.
    if ((valuesOpponent[1] == sum) && (currentPlayer.getSum() != sum)) {
      MessageCli.PRINT_OUTCOME_ROUND.printMessage("AI_WINS");
      points[1]++;
      if (points[1] == pointsToWin) {
        MessageCli.END_GAME.printMessage("Jarvis", Integer.toString(round));
        opponent = null;
        return;
      }
    } else if ((valuesOpponent[1] != sum) && (currentPlayer.getSum() == sum)) {
      MessageCli.PRINT_OUTCOME_ROUND.printMessage("HUMAN_WINS");
      points[0]++;
      if (points[0] == pointsToWin) {
        MessageCli.END_GAME.printMessage(currentPlayer.getName(), Integer.toString(round));
        opponent = null;
        return;
      }
    } else {
      MessageCli.PRINT_OUTCOME_ROUND.printMessage("DRAW");
    }

    round++;
  }

  public void showStats() {
    if (opponent == null) {
      MessageCli.GAME_NOT_STARTED.printMessage();
      return;
    }
    //Prints player information first, then prints AI stats
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
