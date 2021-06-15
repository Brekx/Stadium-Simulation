package Places;

import java.util.Random;

import Utilities.SectorTypes;

/**Class representing cloakroom */
public class Cloakroom extends Sector {
    /**
     * Constructor 
     * 
     * @param random random with which preparation points will be granted
    */
    Cloakroom(Random random){
        super(random);
        type = SectorTypes.cloakroom;
    }
}
