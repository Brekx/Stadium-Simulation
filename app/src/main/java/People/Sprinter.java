package People;

import Utilities.CompetitorsTypes;

/**Class representing sprinter */
public class Sprinter extends Competitor {

    /**
     * Basic Sprinter constructor
     * 
     * @param name name
     * @param strength strength
     * @param speed speed
     * @param prep preparation
     */
    public Sprinter(String name, int strength, int speed, int prep){
        super(name, strength, speed, prep);
        type = CompetitorsTypes.sprinter;
    }

    @Override
    public int perform(int param1) {
        return sprint(param1);
    }

    /** 
     * This method includes special formula which returns score achieved for sprint based on competitor's attributes
     * 
     * @param param1 parameter
     * 
     * @return returns score achieved for sprint
     */
    public int sprint(int param1){
        return (int) (.01*param1*(.1*strength+.6*speed+.3*prep));
    }
}
