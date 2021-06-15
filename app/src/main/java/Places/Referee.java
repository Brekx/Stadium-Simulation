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

/// class representing referee
public class Referee {

    private Sector judgingSector; ///< judging sector
    private Map <Competitor, List<Integer>> scoreboard; ///<scoreboard

    /// constructor with parameters
    /**
     * 
     * @param judgingSector judging sector
     * @param random random value
     */
    Referee(Sector judgingSector, Random random){
        scoreboard = new HashMap<Competitor, List<Integer>>();
        this.judgingSector = judgingSector;
    }

    /// judge
    /** referee gives points for being in specific sector
     * 
     * @param random random value
     * @param minimum_to_perform_competition minimum to perform competition
     */
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

    /// get results
    /** it returns competitor and their best score
     * 
     * @return returns map containing competitor and their best score
     */
    public Map<Competitor, Integer> getResults(){ 
        Map <Competitor, Integer> bestScoresInSector = new HashMap<Competitor, Integer>();
        
        Set<Entry<Competitor,List<Integer>>> entrySetScoreboard = scoreboard.entrySet();
        for(Entry<Competitor,List<Integer>> entry: entrySetScoreboard){
            bestScoresInSector.put(entry.getKey(),Collections.max(entry.getValue()));
        }       
        return bestScoresInSector;
    }

    ///count competitors
    /** it counts the number of competitors from specific type
     * 
     * @param queue queue
     * @param type competitor type
     * @return returns sum
     */
    private int countCompetitors(List <Competitor> queue, CompetitorsTypes type){
        int sum = 0;
        for(Competitor competitor:queue)
            if(competitor.type == type)
                sum++;
        return sum;
    }

    /// add to scoreboard
    /** it adds competitor's score to scoreboard
     * 
     * @param competitor competitor
     * @param random random value
     * @param score score
     */
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
