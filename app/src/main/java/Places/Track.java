package Places;

import java.util.Random;

import Utilities.SectorTypes;

/**Class representing track */
public class Track extends Sector {
    /**
     * Constructor with random parameter
     * 
     * @param random random with which perform points will be granted
     */
    Track(Random random){
        super(random);
        type =  SectorTypes.track;
    }
}
