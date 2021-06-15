package People;

import java.util.Random;

import Places.Sector;
import Places.Stadium;
import Utilities.CompetitorsTypes;

/**
 * Class representing competitor
 */
public abstract class Competitor {
    /** Competitor's name */
    public String name;
    /** Competitor type */
    public CompetitorsTypes type;

    /** Competitor's strenght points 0-100 */
    protected int strength;
    /** Competitor's speed points 0-100 */
    protected int speed;
    /** Competitor's preparation points 0-100 */
    protected int prep;

    /**
     * Competitor defined with all values
     * 
     * @param name name
     * @param strength strength
     * @param speed speed
     * @param prep preparation
     */
    public Competitor(String name, int strength, int speed, int prep){
        if(strength >= 0 && strength <= 100 && speed >= 0 && speed <= 100 && prep >= 0 && prep <= 100){
            this.name =  name;
            this.strength = strength;
            this.speed = speed;
            this.prep = prep;
        }
        else {
            throw new Error("Wrong stat values");
        }
    }

    /**
     * Perform an action
     * 
     * @param param1 parameter
     * @return returns performance
     */
    public int perform(int param1){
        return param1;
    }

    /** 
     * Competitor gains preparation points if total score is less than 100
     * 
     * @param extra_prep granted preparation points
     */
    public void prepare(int extra_prep) {
        if(extra_prep > 0 && extra_prep + prep < 100)
            prep += extra_prep;
        else if (extra_prep + prep > 100)
            prep = 100;
    }

    /** Competitor moves to randomly chosen sector
     * 
     * @param stadium stadium
     * @param random random value
     * @return returns chosen sector
     */
    public Sector move(Stadium stadium, Random random){
        Sector sector;
        switch(random.nextInt(3)){
            case 0:
                sector = stadium.getTrack();
                break;
            case 1:
                sector = stadium.getCloakroom();
                break;
            default:
                sector = stadium.getSandpit();
                break;
        }
        sector.joinQueue(this);
        return sector;
    }
}

