package nz.ac.auckland.se281;

public class UseStrategy {
    
    private Strategies strategy;

    public UseStrategy(Strategies strategy){
        this.strategy = strategy;
    }

    public void setStrategy(Strategies strategy) {
        this.strategy = strategy;
    }

    public int[] run(){
        int[] values = new int[2];
        values[0] = strategy.chooseFingers();
        values[1] = strategy.chooseSum(values[0]);
        return values;
    }


}
