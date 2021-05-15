package Places;

import Places.Track;
import Places.Sandpit;
import Places.Cloakroom;
import java.util.List;

public class Stadium {
    private List <Sector> sectorList;
    
    public Stadium(int tracks, int sandpits, int cloakrooms){

    }

    public performCompetition(){
        for(Sector sector: sectorList){
            sector.referee.judge();
        }
    }

    public Track getTrack(){
        return null;
    }

    public Sandpit getSandpit(){
        return null;
    }

    public Cloakroom getCloakroom(){
        return null;
    }
}