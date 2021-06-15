package Places;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import People.Competitor;
import Utilities.SectorTypes;

/// class representing sector
public abstract class Sector {
    private List<Competitor> queue; ///< queue
    protected Referee referee; ///< referee
    public SectorTypes type; ///< type

    /// constructor with random parameter
    /** constructor which creates queue and referee
     * 
     * @param random random value
     */
    Sector(Random random){
        queue = new ArrayList<Competitor>();
        referee = new Referee(this, random);
    }

    /// join queue 
    /** competitor joins queue - is added to it
     * 
     * @param competitor competitor
     */
    public void joinQueue(Competitor competitor){
        queue.add(competitor);
    }

    /// leave queue
    /** competitor leaves queue - is removed from it
     * 
     * @param competitor
     */
    public void leaveQueue(Competitor competitor){
        try{
            queue.remove(competitor);
        }
        catch(Exception e){
        }
    }

    /// get queue
    /**
     * 
     * @return returns list of competitors
     */
    public List<Competitor> getQueue(){
        return queue;
    }
}
