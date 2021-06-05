package Places;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.Map.Entry;

import People.Competitor;

public class Referee {
    private static int type;

    private Sector judgingSector;
    private Random random;
    private Map <String, List<Integer>> scoreboard; 
    private Map <String,Integer> MapWinnersInSector;

    Referee(Sector judgingSector, Random random, int type){
        scoreboard = new HashMap<String, List<Integer>>();
        this.judgingSector = judgingSector;
    }

    public void judge(){
        List <Competitor> queue = judgingSector.getQueue();
        for(Competitor competitor: queue){
            if(type<1){
                if(scoreboard.containsKey(competitor.name)){
                    scoreboard.get(competitor.name).add(competitor.perform(random.nextInt(100)));
                }
                else{
                    List<Integer> to_add = new ArrayList<Integer>();
                    to_add.add(competitor.perform(random.nextInt(100)));
                    scoreboard.put(competitor.name, to_add);
                }
            }
            else {
                competitor.prepare(random.nextInt(100));
            }
        }
    }

    public Map <String, Integer> getResults(){ 
        
        Set<Entry<String,List<Integer>>> entrySetScoreboard = scoreboard.entrySet();
        for(Entry<String,List<Integer>> entry: entrySetScoreboard){
            MapWinnersInSector.put(entry.getKey(),Collections.max(entry.getValue()));
        }       
        return MapWinnersInSector;
    }
}
