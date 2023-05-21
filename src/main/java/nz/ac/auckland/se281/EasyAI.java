package nz.ac.auckland.se281;

public class EasyAI implements AI {

  @Override
  public int[] play(Player player) {
    UseStrategy useStrategy = new UseStrategy(new RandomStrategy());
    return useStrategy.run(player);
  }
}
