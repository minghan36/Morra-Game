package nz.ac.auckland.se281;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private List<Integer> fingersHistory = new ArrayList<>();
    private int sum;

    public Player(String name){
        this.name = name;
    }

    public void setFingers(int fingers){
        fingersHistory.add(fingers);
    }

    public void setSum(int sum){
        this.sum = sum;
    }

    public int getSum(){
        return sum;
    }

    public int getLatestFingers(){
        return fingersHistory.get(fingersHistory.size() - 1);
    }
}