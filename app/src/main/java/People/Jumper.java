package People;

public class Jumper extends Competitor {

    public Jumper(String name, int strength, int speed, int prep){
        super(name, strength, speed, prep);
    }

    @Override
    public int perform(int param1){
        return jump(param1);
    }

    public int jump(int param1){
        return 0;
    }
}