package nz.ac.auckland.se281;

import java.util.ArrayList;
import java.util.List;

public class TopStrategy implements Strategies {

  @Override
  public int chooseFingers() {
    return Utils.getRandomNumber(1, 5);
  }

  @Override
  public int chooseSum(int fingers, Player currentPlayer) {
    List<Integer> history = new ArrayList<Integer>(currentPlayer.getFingersHistory());
    history.remove(history.size() - 1);
    int mostPlayed = 0;
    int maxCount = 0;
    int count;
    // Nested loop counts each time a number appears... possible numbers is between 1 and 5
    // inclusive. If count is larger than maxCount, the mostPlayed number is replaced.
    for (int i = 1; i <= 5; i++) {
      count = 0;
      for (int finger : history) {
        if (i == finger) {
          count++;
          if (count > maxCount) {
            mostPlayed = i;
            maxCount = count;
          }
        }
      }
    }
    return fingers + mostPlayed;
  }
}
