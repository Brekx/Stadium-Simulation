package People;

import java.util.Random;

import Places.Sector;

public class Referee {
    Sector judgingSector;
    Random random;
    int type;
    //private Map<Competitor, List<int>> scoreboard;

    public Referee(Sector judgingSector, Random random, int type){
        this.judgingSector = judgingSector;
    }

    public void judge(){
        List <Competitor> queue = judgingSector.getQueue();
        for(Competitor competitor: queue){
            if(type){
                //TODO: add to scoreboard
                competitor.perform(random.nextInt(100));
            }
            else {
                competitor.prepare(random.nextInt(100));
            }
        }
    }

    public void getResults(){

    }
}
