package Places;

import java.util.Random;

import Utilities.SectorTypes;

///class representing snadpit
public class Sandpit extends Sector {
    ///constructor with random parameter
    Sandpit(Random random){
        super(random);
        type = SectorTypes.sandpit;
    }
}
