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
        int mostPlayed = 0;
        int maxCount = 0;
        int count;
        for (int i=1; i<=5; i++){
            count = 0;
            for (int finger:history){
                if(i==finger){
                    count++;
                    if(count>maxCount){
                        mostPlayed = i;
                    }
                }
            }
        }
        return fingers + mostPlayed;
    } 
}
