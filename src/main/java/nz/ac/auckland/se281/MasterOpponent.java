package nz.ac.auckland.se281;

public class MasterOpponent implements Opponent {

  private int count = 1;

  @Override
  public int[] play(Player player) {
    UseStrategy useStrategy = new UseStrategy(new RandomStrategy());
    // For round 4 and onwards, the Master AI will alternate between the average and top strategy.
    // If the round is an even number, use average. Otherwise use top.
    if (count > 3) {
      if ((count % 2) == 0) {
        count++;
        useStrategy.setStrategy(new AverageStrategy());
        return useStrategy.run(player);
      } else {
        count++;
        useStrategy.setStrategy(new TopStrategy());
        return useStrategy.run(player);
      }
    } else {
      count++;
      return useStrategy.run(player);
    }
  }
}
