package nz.ac.auckland.se281;

public class HardAI implements AI {

  private int count = 1;

  @Override
  public int[] play(Player player) {
    UseStrategy useStrategy = new UseStrategy(new RandomStrategy());
    if (count > 3) {
      useStrategy.setStrategy(new TopStrategy());
      return useStrategy.run(player);
    } else {
      count++;
      return useStrategy.run(player);
    }
  }
}
