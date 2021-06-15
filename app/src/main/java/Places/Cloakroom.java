package Places;

import java.util.Random;

import Utilities.SectorTypes;

///class representing cloakroom
public class Cloakroom extends Sector {
    ///constructor with random parameter
    Cloakroom(Random random){
        super(random);
        type  = SectorTypes.cloakroom;
    }
}
