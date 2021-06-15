package People;

import java.util.Random;

import Places.Sector;
import Places.Stadium;
import Utilities.CompetitorsTypes;

///class representing competitor
public abstract class Competitor {
    public String name; ///< name
    public CompetitorsTypes type; ///< type

    protected int strength; ///< strength
    protected int speed; ///< speed
    protected int prep; ///< preparation

    /// constructor with parameters
    /**
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

    /// perform 
    /**
     * 
     * @param param1 parameter
     * @return returns parameter
     */
    public int perform(int param1){
        return param1;
    }

    /// prepare to competition
    /** competitor gains preparation points if total score is less than 100
     * 
     * @param extra_prep
     */
    public void prepare(int extra_prep) {
        if(extra_prep > 0 && extra_prep + prep < 100)
            prep += extra_prep;
        else if (extra_prep + prep > 100)
            prep = 100;
    }

    /// move at the stadium
    /** competitor moves to randomly chosen sector
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

