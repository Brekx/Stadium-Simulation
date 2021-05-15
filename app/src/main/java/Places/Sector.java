package Places;

import java.util.List;

import People.Competitor;
import People.Referee;

public abstract class Sector {
    private List<Competitor> queue;
    Referee referee;

    public void joinQueue(Competitor competitor){
        queue.add(competitor);
    }

    public List<Competitor> getQueue(){
        return queue;
    }
}
