package People;

import Utilities.CompetitorsTypes;

public class Sprinter extends Competitor {

    public Sprinter(String name, int strength, int speed, int prep){
        super(name, strength, speed, prep);
        type = CompetitorsTypes.sprinter;
    }

    @Override
    public int perform(int param1) {
        return sprint(param1);
    }

    public int sprint(int param1){
        return (int) (param1*(.1*strength+.6*speed+.3*prep));
    }
}
