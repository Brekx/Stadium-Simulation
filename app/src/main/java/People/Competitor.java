package People;

import java.util.Random;

import app.src.main.java.Places.Stadium;

public abstract class Competitor {
    public String name;

    private int strength, speed, prep;

    public Competitor(String name, int strength, int speed, int prep){
        if(strength >= 0 && strength <= 100 && speed >= 0 && speed <= 100 && prep >= 0 && prep <= 100){
            this.name =  name;
            this.strength = strength;
            this.speed = speed;
            this.prep = prep;
        }
        else {
            //TODO: Exception wrong stats
            this.name =  "ADAM";
            this.strength = 20;
            this.speed = 15;
            this.prep = 4;
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

    public void move(Stadium stadium, Random random){
        switch(random.nextInt(3)){
            case 1:
                stadium.getTrack().joinQueue(this);
                break;
            case 2:
                stadium.getCloakroom().joinQueue(this);
                break;
            case 3:
                stadium.getSandpit().joinQueue(this);
                break;
            default:
                break;
        }
    }
}

