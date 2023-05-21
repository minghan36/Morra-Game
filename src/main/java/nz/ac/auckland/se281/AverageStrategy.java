package nz.ac.auckland.se281;

import java.util.ArrayList;
import java.util.List;

public class AverageStrategy implements Strategies{

    @Override
    public int chooseFingers() {
        return Utils.getRandomNumber(1, 5);
    }

    @Override
    public int chooseSum(int fingers, Player currentPlayer) {
        List<Integer> history = new ArrayList<Integer>(currentPlayer.getFingersHistory());
        history.remove(history.size()-1);
        int sum = 0;
        if (!history.isEmpty()){
            for (int finger : history){
                sum += finger;
            }
        }
        return fingers + (int) Math.round((double)sum/history.size());
    }
    
}
