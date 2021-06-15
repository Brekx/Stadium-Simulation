package Places;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.Map.Entry;

import People.Competitor;
import Utilities.CompetitorsTypes;
import Utilities.FlowControl;

/**Class representing stadium */
public class Stadium {
    /**List od sectors */
    private List <Sector> sectorList;
    /**Last index track */
    private int last_index_track;
    /**Last index sandpit */
    private int last_index_sandpit;
    /**Last index cloakroom */
    private int last_index_cloakroom;
    /**Flow control */
    private FlowControl flowControl;

    /** 
     * Constructor which creates sectors and makes competitors join queues 
     * 
     * @param tracks number of tracks
     * @param sandpits number of sandpits
     * @param cloakrooms number of cloakrooms
     * @param random random value
     * @param competitors list of competitors
     * @param flowControl flow control
     */
    public Stadium(int tracks, int sandpits, int cloakrooms, Random random, List <Competitor> competitors, FlowControl flowControl){
        this.flowControl = flowControl;
        sectorList = new ArrayList<Sector>();
        for(int i=0; i<cloakrooms; i++){
            Cloakroom to_add = new Cloakroom(random);
            sectorList.add(to_add);
        }
        for(int i=0; i<sandpits; i++){
            Sandpit to_add = new Sandpit(random);
            sectorList.add(to_add);
        }
        for(int i=0; i<tracks; i++){
            Track to_add = new Track(random);
            sectorList.add(to_add);
        }
        for(Competitor competitor:competitors){
            Sector sector = getCloakroom();
            sector.joinQueue(competitor);
            flowControl.addContest(sectorList.indexOf(sector));
        }
    }

    /** 
     * Every competitor performs and gets result
     * 
     * @param random random value
     * @param minimum_to_perform_competition minimal amount of competitors
     */
    public void performCompetition(Random random, int minimum_to_perform_competition){
        for(Sector sector: sectorList){
            sector.referee.judge(random, minimum_to_perform_competition);
        }
        flowControl.perform_competition();
    }

    /** 
     * Tells competetitors to move
     * 
     * @param random random value
     */
    public void performMovement(Random random){
        List <Competitor> already_moved = new ArrayList<Competitor>();
        for(Sector sector: sectorList){
            for(Competitor competitor: new ArrayList<Competitor>(sector.getQueue())){
                if(!already_moved.contains(competitor)){
                    sector.leaveQueue(competitor);
                    flowControl.move(sectorList.indexOf(sector), sectorList.indexOf(competitor.move(this, random)));
                    already_moved.add(competitor);
                }
            }
        }
    }

    /// get track
    /**
     * 
     * @return returns track
     */
    public Track getTrack(){
        for(int i=last_index_track; i<sectorList.size()+last_index_track; i++){
            if(sectorList.get(i%sectorList.size()).getClass()==Track.class){
                last_index_track = i%sectorList.size();
                return (Track) sectorList.get(i%sectorList.size());
            }
        }
        throw new NoSuchFieldError("No Tracks");
    }

    /// get sandpit
    /**
     * 
     * @return returns sandpit
     */
    public Sandpit getSandpit(){
        for(int i=last_index_sandpit; i<sectorList.size()+last_index_sandpit; i++){
            if(sectorList.get(i%sectorList.size()).getClass()==Sandpit.class){
                last_index_sandpit = i%sectorList.size();
                return (Sandpit) sectorList.get(i%sectorList.size());
            }
        }
        throw new NoSuchFieldError("No Sandpits");
    }

    /// get cloakroom
    /**
     * 
     * @return returns cloakroom
     */
    public Cloakroom getCloakroom(){
        for(int i=last_index_cloakroom; i<sectorList.size()+last_index_cloakroom; i++){
            if(sectorList.get(i%sectorList.size()).getClass()==Cloakroom.class){
                last_index_cloakroom = i%sectorList.size();
                return (Cloakroom) sectorList.get(i%sectorList.size());
            }
        }
        throw new NoSuchFieldError("No Cloakrooms");
    }

    /// get results
    /** it unifies specific competitors scores
     * 
     * @return returns unified scoreboards
     */
    public Map <CompetitorsTypes, String> getResults(){
        Map <CompetitorsTypes, Map<Competitor, Integer>> scoreboard_unified = new HashMap<CompetitorsTypes, Map<Competitor, Integer>>();
        Map <CompetitorsTypes, String> results = new HashMap<CompetitorsTypes, String>();
        for(Sector sector : sectorList){
            Map <Competitor, Integer> scoreboard = sector.referee.getResults();
            Set<Entry<Competitor,Integer>> entrySectorResults = scoreboard.entrySet();
            
            for(Entry<Competitor,Integer> entry: entrySectorResults){
                if(scoreboard_unified.containsKey(entry.getKey().type)){
                    scoreboard_unified.get(entry.getKey().type).put(entry.getKey(), entry.getValue());
                }
                else{
                    scoreboard_unified.put(entry.getKey().type, new HashMap<Competitor, Integer>());
                }
            }

        }

        for(CompetitorsTypes competitorsTypes: scoreboard_unified.keySet()){
            String to_add = "";
            LinkedHashMap<Competitor, Integer> reverseSortedMap = new LinkedHashMap<>();
            scoreboard_unified.get(competitorsTypes).entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())) .forEachOrdered(x -> reverseSortedMap.put(x.getKey(), x.getValue()));
            System.out.println(reverseSortedMap);
            

            Set<Entry<Competitor,Integer>> entrySetScoreboard = reverseSortedMap.entrySet();
            for(Entry<Competitor,Integer> entry: entrySetScoreboard){
                to_add += entry.getKey().name + "\t" + entry.getValue() + "\n";
            }
            results.put(competitorsTypes, to_add);
        }
        return results;
    }
}
