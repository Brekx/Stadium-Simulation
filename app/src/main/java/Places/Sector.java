package Places;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import People.Competitor;

public abstract class Sector {
    private List<Competitor> queue;
    protected Referee referee;

    Sector(Random random, int type){
        queue = new ArrayList<Competitor>();
        referee = new Referee(this, random, type);
    }

    public void joinQueue(Competitor competitor){
        queue.add(competitor);
    }

    protected List<Competitor> getQueue(){
        return queue;
    }
}
