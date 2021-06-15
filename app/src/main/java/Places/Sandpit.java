package Places;

import java.util.Random;

import Utilities.SectorTypes;

/**Class representing snadpit */
public class Sandpit extends Sector {
    /**
     * Constructor 
     * 
     * @param random random which which perform points will be granted
    */
    Sandpit(Random random){
        super(random);
        type = SectorTypes.sandpit;
    }
}
