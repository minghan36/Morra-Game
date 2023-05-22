package nz.ac.auckland.se281;

public class MediumOpponent implements Opponent {

  private int count = 1;

  @Override
  public int[] play(Player player) {
    UseStrategy useStrategy = new UseStrategy(new RandomStrategy());
    //Sets strategy to AverageStrategy for round 4 and onwards
    if (count > 3) {
      useStrategy.setStrategy(new AverageStrategy());
      return useStrategy.run(player);
    } else {
      count++;
      return useStrategy.run(player);
    }
  }
}
