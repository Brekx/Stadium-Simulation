package Places;

import java.util.Random;

import Utilities.SectorTypes;

public class Cloakroom extends Sector {
    Cloakroom(Random random){
        super(random, 0);
        type  = SectorTypes.cloakroom;
    }
}
