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
import People.Jumper;
import People.LongDistanceRunner;
import People.Sprinter;
import Utilities.CompetitorsTypes;

public class Referee {

    private Sector judgingSector;
    private Map <Competitor, List<Integer>> scoreboard;

    Referee(Sector judgingSector, Random random){
        scoreboard = new HashMap<Competitor, List<Integer>>();
        this.judgingSector = judgingSector;
    }

    public void judge(Random random, int minimum_to_perform_competition){
        List <Competitor> queue = judgingSector.getQueue();
        for(Competitor competitor: queue){
            switch(judgingSector.type){
                case cloakroom:
                    competitor.prepare(random.nextInt(100));
                    break;
                case sandpit:
                    if(countCompetitors(queue, CompetitorsTypes.jumper)>minimum_to_perform_competition && competitor.type == CompetitorsTypes.jumper)
                        addToScoreboard(competitor, random, ((Jumper)competitor).jump(random.nextInt(100)));
                    break;
                case track:
                    if(countCompetitors(queue, CompetitorsTypes.sprinter)>minimum_to_perform_competition && competitor.type == CompetitorsTypes.sprinter)
                        addToScoreboard(competitor, random, ((Sprinter)competitor).sprint(random.nextInt(100))); 
                    if(countCompetitors(queue, CompetitorsTypes.long_distance_runner)>minimum_to_perform_competition && competitor.type == CompetitorsTypes.long_distance_runner)
                        addToScoreboard(competitor, random, ((LongDistanceRunner)competitor).run(random.nextInt(100)));
                    break;
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

    private int countCompetitors(List <Competitor> queue, CompetitorsTypes type){
        int sum = 0;
        for(Competitor competitor:queue)
            if(competitor.type == type)
                sum++;
        return sum;
    }

    private void addToScoreboard(Competitor competitor, Random random, int score){
        if(scoreboard.containsKey(competitor)){
            scoreboard.get(competitor).add(score);
        }
        else{
            List<Integer> to_add = new ArrayList<Integer>();
            to_add.add(score);
            scoreboard.put(competitor, to_add);
        }
    }
}
