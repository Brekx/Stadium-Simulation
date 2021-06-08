package People;

import Utilities.CompetitorsTypes;

public class Jumper extends Competitor {

    public Jumper(String name, int strength, int speed, int prep){
        super(name, strength, speed, prep);
        type = CompetitorsTypes.jumper;
    }

    @Override
    public int perform(int param1){
        return jump(param1);
    }

    public int jump(int param1){
        return (int) (param1*(.5*strength+.2*speed+.3*prep));
    }
}