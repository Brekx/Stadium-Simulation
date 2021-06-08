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
import Utilities.SectorTypes;

public class Referee {

    private Sector judgingSector;
    private Map <Competitor, List<Integer>> scoreboard;

    Referee(Sector judgingSector, Random random){
        scoreboard = new HashMap<Competitor, List<Integer>>();
        this.judgingSector = judgingSector;
    }

    public void judge(Random random){
        List <Competitor> queue = judgingSector.getQueue();
        for(Competitor competitor: queue){
            if(judgingSector.type == SectorTypes.cloakroom){
                competitor.prepare(random.nextInt(100));
            }
            else{
                if(scoreboard.containsKey(competitor)){
                    scoreboard.get(competitor).add(competitor.perform(random.nextInt(100)));
                }
                else{
                    List<Integer> to_add = new ArrayList<Integer>();
                    to_add.add(competitor.perform(random.nextInt(100)));
                    scoreboard.put(competitor, to_add);
                }
            }
        }
    }

    public Map<Competitor, Integer> getResults(){ 
        Map <Competitor, Integer> bestScoresInSector = new HashMap<Competitor, Integer>();
        
        Set<Entry<Competitor,List<Integer>>> entrySetScoreboard = scoreboard.entrySet();
        for(Entry<Competitor,List<Integer>> entry: entrySetScoreboard){
            bestScoresInSector.put(entry.getKey(),Collections.max(entry.getValue()));
        }       
        return bestScoresInSector;
    }
}
