package Places;

import java.util.Random;

import Utilities.SectorTypes;

public class Track extends Sector {
    Track(Random random){
        super(random);
        type =  SectorTypes.track;
    }
}
