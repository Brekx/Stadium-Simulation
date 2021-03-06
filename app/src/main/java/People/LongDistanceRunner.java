package People;

import Utilities.CompetitorsTypes;

/**Class representing long distance runner */
public class LongDistanceRunner extends Competitor {

/**
 * Basic LongDistanceRunner constructor
 * 
 * @param name name
 * @param strength strength
 * @param speed speed
 * @param prep preparation
 */
public LongDistanceRunner(String name, int strength, int speed, int prep){
        super(name, strength, speed, prep);
        type = CompetitorsTypes.long_distance_runner;
    }

    @Override
    public int perform(int param1) {
        return run(param1);
    }

    /** 
     * This method includes special formula which returns score achieved for run based on competitor's attributes
     * 
     * @param param1 parameter
     * 
     * @return returns score achieved for run
     */
    public int run(int param1){
        return (int) (.01*param1*(.2*strength+.2*speed+.6*prep));
    }
}
