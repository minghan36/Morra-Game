package nz.ac.auckland.se281;

import java.util.List;

public class TopStrategy implements Strategies{

    @Override
    public int chooseFingers() {
        return Utils.getRandomNumber(1, 5);
    }

    @Override
    public int chooseSum(int fingers, Player currentPlayer) {
        List<Integer> history = currentPlayer.getFingersHistory();
        history.remove(history.size()-1);
    }
    
}
