package People;

import Utilities.CompetitorsTypes;

/**Class representing jumper */
public class Jumper extends Competitor {

    /**
     * Basic Jumper constructor
     * 
     * @param name name
     * @param strength strength
     * @param speed speed
     * @param prep preparation
     */
    public Jumper(String name, int strength, int speed, int prep){
        super(name, strength, speed, prep);
        type = CompetitorsTypes.jumper;
    }

    @Override
    public int perform(int param1){
        return jump(param1);
    }

    /** 
     * This method includes special formula which returns score achieved for jump based on competitor's attributes
     * 
     * @param param1 parameter
     * @return returns score achieved for jump
     */
    public int jump(int param1){
        return (int) (.01*param1*(.5*strength+.2*speed+.3*prep));
    }
}