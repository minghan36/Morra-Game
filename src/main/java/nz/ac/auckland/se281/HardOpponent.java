package nz.ac.auckland.se281;

public class HardOpponent implements Opponent {

  private int count = 1;

  @Override
  public int[] play(Player player) {
    UseStrategy useStrategy = new UseStrategy(new RandomStrategy());
    // Changes strategy to TopStrategy from round 4 and onwards
    if (count > 3) {
      useStrategy.setStrategy(new TopStrategy());
      return useStrategy.run(player);
    } else {
      count++;
      return useStrategy.run(player);
    }
  }
}
