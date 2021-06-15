package Places;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import People.Competitor;
import Utilities.SectorTypes;

/**Class representing sector */
public abstract class Sector {
    /**List of competitors being in queue */
    private List<Competitor> queue;
    /**Referee which is judging here */
    protected Referee referee;
    /**Type of sector */
    public SectorTypes type;

    /** 
     * Constructor which creates queue and referee
     * 
     * @param random random value
     */
    Sector(Random random){
        queue = new ArrayList<Competitor>();
        referee = new Referee(this, random);
    }

    /** 
     * Competitor joins queue - is added to it
     * 
     * @param competitor competitor
     */
    public void joinQueue(Competitor competitor){
        queue.add(competitor);
    }

    /** 
     * Competitor leaves queue - is removed from it
     * 
     * @param competitor competitor that wants to leave queue
     */
    public void leaveQueue(Competitor competitor){
        try{
            queue.remove(competitor);
        }
        catch(Exception e){
        }
    }

    /**
     * Getter of queue
     * 
     * @return returns list of competitors
     */
    public List<Competitor> getQueue(){
        return queue;
    }
}
