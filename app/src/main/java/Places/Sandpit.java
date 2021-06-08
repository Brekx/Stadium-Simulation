package Places;

import java.util.Random;

import Utilities.SectorTypes;

public class Sandpit extends Sector {
    Sandpit(Random random){
        super(random, 2);
        type = SectorTypes.sandpit;
    }
}
