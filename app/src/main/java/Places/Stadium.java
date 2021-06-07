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

public class Stadium {
    private List <Sector> sectorList;
    private int last_index_track, last_index_sandpit, last_index_cloakroom;

    public Stadium(int tracks, int sandpits, int cloakrooms, Random random){
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
    }

    public void performCompetition(Random random){
        for(Sector sector: sectorList){
            sector.referee.judge(random);
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
        Map <String, Integer> track_scoreboard_unified = new HashMap<String, Integer>();
        Map <String, Integer> sandpit_scoreboard_unified = new HashMap<String, Integer>();
        for(Sector sector : sectorList){
            Map <String, Integer> scoreboard = sector.referee.getResults();
            Set<Entry<String,Integer>> entrySectorResults = scoreboard.entrySet();
            
            if(sector.referee.type==1){//to pewnie bd do zmiany jak zrobisz to co chciales z typeami
                for(Entry<String,Integer> entry: entrySectorResults){
                    track_scoreboard_unified.put(entry.getKey(),entry.getValue());
                }
            }
            else if(sector.referee.type==0){//same here
                for(Entry<String,Integer> entry: entrySectorResults){
                    sandpit_scoreboard_unified.put(entry.getKey(),entry.getValue());
                }  
            }
        }
        //System.out.println("Unsorted Map track : " + track_scoreboard_unified);
        LinkedHashMap<String, Integer> reverseSortedMapTrack = new LinkedHashMap<>();
        track_scoreboard_unified.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())) .forEachOrdered(x -> reverseSortedMapTrack.put(x.getKey(), x.getValue()));
        System.out.println("Results on track : " + reverseSortedMapTrack);
        //System.out.println("Unsorted Map sandpit : " + sandpit_scoreboard_unified);
        LinkedHashMap<String, Integer> reverseSortedMapSandpit = new LinkedHashMap<>();
        sandpit_scoreboard_unified.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())) .forEachOrdered(x -> reverseSortedMapSandpit.put(x.getKey(), x.getValue()));
        System.out.println("Results on sandpit : " + reverseSortedMapSandpit);
    }
}
