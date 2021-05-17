package Places;

import java.util.List;
import java.util.Random;

public class Stadium {
    private List <Sector> sectorList;

    private int last_index_track, last_index_sandpit, last_index_cloakroom;
    
    public Stadium(int tracks, int sandpits, int cloakrooms, Random random){
        for(int i=0; i<tracks; i++){
            Track to_add = new Track(random);
            sectorList.add(to_add);
        }
        for(int i=0; i<sandpits; i++){
            Sandpit to_add = new Sandpit(random);
            sectorList.add(to_add);
        }
        for(int i=0; i<cloakrooms; i++){
            Cloakroom to_add = new Cloakroom(random);
            sectorList.add(to_add);
        }
    }

    public void performCompetition(){
        for(Sector sector: sectorList){
            sector.referee.judge();
        }
    }

    public Track getTrack(){
        for(int i=last_index_track; i<sectorList.size()+last_index_track; i++){
            if(sectorList.get(i%sectorList.size()).getClass()==Track.class){
                last_index_track = i%sectorList.size();
                return (Track) sectorList.get(i%sectorList.size());
            }
        }
        //TODO: Raise an error, sector not found
        return null;
    }

    public Sandpit getSandpit(){
        for(int i=last_index_sandpit; i<sectorList.size()+last_index_sandpit; i++){
            if(sectorList.get(i%sectorList.size()).getClass()==Sandpit.class){
                last_index_sandpit = i%sectorList.size();
                return (Sandpit) sectorList.get(i%sectorList.size());
            }
        }
        //TODO: Raise an error, sector not found
        return null;
    }

    public Cloakroom getCloakroom(){
        for(int i=last_index_cloakroom; i<sectorList.size()+last_index_cloakroom; i++){
            if(sectorList.get(i%sectorList.size()).getClass()==Cloakroom.class){
                last_index_cloakroom = i%sectorList.size();
                return (Cloakroom) sectorList.get(i%sectorList.size());
            }
        }
        //TODO: Raise an error, sector not found
        return null;
    }
}