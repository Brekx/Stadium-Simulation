package People;

import java.util.Random;

import Places.Sector;
import Places.Stadium;
import Utilities.CompetitorsTypes;

public abstract class Competitor {
    public String name;
    public CompetitorsTypes type;

    protected int strength, speed, prep;

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

    public int perform(int param1){
        return param1;
    }

    public void prepare(int extra_prep) {
        if(extra_prep > 0 && extra_prep + prep < 100)
            prep += extra_prep;
        else if (extra_prep + prep > 100)
            prep = 100;
    }

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

