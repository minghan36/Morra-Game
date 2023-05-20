package nz.ac.auckland.se281;

import java.util.List;

public class AverageStrategy implements Strategies{

    @Override
    public int chooseFingers() {
        return Utils.getRandomNumber(1, 5);
    }

    @Override
    public int chooseSum(int fingers, Player currentPlayer) {
        List<Integer> history = currentPlayer.getFingersHistory();
        int sum = 0;
        if (!history.isEmpty()){
            for (int finger : history){
                sum += finger;
            }
        }
        return fingers + (int) Math.round((double)sum/history.size());
    }
    
}
