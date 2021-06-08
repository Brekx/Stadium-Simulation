package Places;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import People.Competitor;
import Utilities.SectorTypes;

public abstract class Sector {
    private List<Competitor> queue;
    protected Referee referee;
    public SectorTypes type;

    Sector(Random random){
        queue = new ArrayList<Competitor>();
        referee = new Referee(this, random);
    }

    public void joinQueue(Competitor competitor){
        queue.add(competitor);
    }

    public void leaveQueue(Competitor competitor){
        try{
            queue.remove(competitor);
        }
        catch(Exception e){
        }
    }

    public List<Competitor> getQueue(){
        return queue;
    }
}
