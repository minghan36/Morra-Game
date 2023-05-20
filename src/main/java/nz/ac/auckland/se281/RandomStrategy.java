package nz.ac.auckland.se281;

public class RandomStrategy implements Strategies{

    @Override
    public int chooseFingers() {
        return Utils.getRandomNumber(1, 5);
    }

    @Override
    public int chooseSum(int fingers, Player currentPlayer) {
        return fingers + Utils.getRandomNumber(1, 5);
    }

}