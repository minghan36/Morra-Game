package nz.ac.auckland.se281;

public class MediumAI implements AI {

  private int count = 1;

  @Override
  public int[] play(Player player) {
    UseStrategy useStrategy = new UseStrategy(new RandomStrategy());
    if (count > 3) {
      useStrategy.setStrategy(new AverageStrategy());
      return useStrategy.run(player);
    } else {
      count++;
      return useStrategy.run(player);
    }
  }
}
