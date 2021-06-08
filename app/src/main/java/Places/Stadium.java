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

public class Stadium {
    private List <Sector> sectorList;
    private int last_index_track, last_index_sandpit, last_index_cloakroom;


    public Stadium(int tracks, int sandpits, int cloakrooms, Random random, List <Competitor> competitors){
        sectorList = new ArrayList<Sector>();
        for(int i=0; i<tracks; i++){
            Track to_add = new Track(random);
            sectorList.add(to_add);
        }
        for(int i=0; i<sandpits; i++){
            Sandpit to_add = new Sandpit(random);
            sectorList.add(to_add);
        }
        for(int i=0; i<cloakrooms; i++){
            Cloakroom to_add = new Cloakroom(random);
            sectorList.add(to_add);
        }
        for(Competitor competitor:competitors){
            getCloakroom().joinQueue(competitor);
        }
    }

    public void performCompetition(Random random, int minimum_to_perform_competition){
        for(Sector sector: sectorList){
            sector.referee.judge(random, minimum_to_perform_competition);
        }
    }

    public void performMovement(Random random){
        List <Competitor> already_moved = new ArrayList<Competitor>();
        for(Sector sector: sectorList){
            for(Competitor competitor: new ArrayList<Competitor>(sector.getQueue())){
                if(!already_moved.contains(competitor)){
                    sector.leaveQueue(competitor);
                    competitor.move(this, random);
                    already_moved.add(competitor);
                }
            }
        }
    }

    public Track getTrack(){
        for(int i=last_index_track; i<sectorList.size()+last_index_track; i++){
            if(sectorList.get(i%sectorList.size()).getClass()==Track.class){
                last_index_track = i%sectorList.size();
                return (Track) sectorList.get(i%sectorList.size());
            }
        }
        //TODO: Raise an error, sector not found
        return null;
    }

    public Sandpit getSandpit(){
        for(int i=last_index_sandpit; i<sectorList.size()+last_index_sandpit; i++){
            if(sectorList.get(i%sectorList.size()).getClass()==Sandpit.class){
                last_index_sandpit = i%sectorList.size();
                return (Sandpit) sectorList.get(i%sectorList.size());
            }
        }
        //TODO: Raise an error, sector not found
        return null;
    }

    public Cloakroom getCloakroom(){
        for(int i=last_index_cloakroom; i<sectorList.size()+last_index_cloakroom; i++){
            if(sectorList.get(i%sectorList.size()).getClass()==Cloakroom.class){
                last_index_cloakroom = i%sectorList.size();
                return (Cloakroom) sectorList.get(i%sectorList.size());
            }
        }
        //TODO: Raise an error, sector not found
        return null;
    }

    public void getResults(){
        Map <CompetitorsTypes, Map<Competitor, Integer>> scoreboard_unified = new HashMap<CompetitorsTypes, Map<Competitor, Integer>>();
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
            System.out.print("Wynik w " + competitorsTypes.toString() + " ");
            LinkedHashMap<Competitor, Integer> reverseSortedMap = new LinkedHashMap<>();
            scoreboard_unified.get(competitorsTypes).entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())) .forEachOrdered(x -> reverseSortedMap.put(x.getKey(), x.getValue()));
            System.out.println(reverseSortedMap);
        }
    }
}
