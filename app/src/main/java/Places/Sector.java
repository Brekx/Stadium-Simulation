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

    Sector(Random random, int type){
        queue = new ArrayList<Competitor>();
        referee = new Referee(this, random);
    }

    public void joinQueue(Competitor competitor){
        queue.add(competitor);
    }

    public List<Competitor> getQueue(){
        return queue;
    }
}
