package People;

import Utilities.CompetitorsTypes;

public class Sprinter extends Competitor {

    public Sprinter(String name, int strength, int speed, int prep){
        super(name, strength, speed, prep);
        type = CompetitorsTypes.sprinter;
    }

    @Override
    public int perform(int param1) {
        return run(param1);
    }

    public int run(int param1){
        return 0;
    }
}
