package nz.ac.auckland.se281;

public class RandomStrategy implements Strategies{

    @Override
    public int chooseFingers() {
        return Utils.getRandomNumber(1, 10);
    }

    @Override
    public int chooseSum(int fingers) {
        return fingers + Utils.getRandomNumber(1, 5);
    }

}