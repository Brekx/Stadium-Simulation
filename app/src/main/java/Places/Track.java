package Places;

import java.util.Random;

import Utilities.SectorTypes;

///class representing track
public class Track extends Sector {
    ///constructor with random parameter
    Track(Random random){
        super(random);
        type =  SectorTypes.track;
    }
}
