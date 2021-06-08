package People;

import Utilities.CompetitorsTypes;

public class LongDistanceRunner extends Competitor {

    public LongDistanceRunner(String name, int strength, int speed, int prep){
        super(name, strength, speed, prep);
        type = CompetitorsTypes.long_distance_runner;
    }

    @Override
    public int perform(int param1) {
        return run(param1);
    }

    public int run(int param1){
        return (int) (param1*(.2*strength+.2*speed+.6*prep));
    }
}
