package Utilities;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.io.File;
import java.util.Scanner;

import People.Competitor;
import People.Jumper;
import People.LongDistanceRunner;
import People.Sprinter;

/// class representing generator
public class Generator {
    private int competitors_number; ///< number of competitors
    List<Competitor> competitorsList; ///< list of competitors
    Jumper jumper1; ///< jumper instance
    Sprinter sprinter1; ///< sprinter instance
    LongDistanceRunner longDistanceRunner1; ///< long distance runner instance
    String line; ///< line 

    /// constructor with parameters
    /**
     * 
     * @param competitors_number number of competitors
     */
    public Generator(int competitors_number){
        this.competitors_number = competitors_number;
    }

    /// generate competitors
    /** generate random competitors from attached file, which contains many names
     * 
     * @param random random value
     * @return returns list of competitors
     */
    List <Competitor> generateCompetitors(Random random){
        competitorsList = new ArrayList<Competitor>() ;

        File file = new File("app/src/main/resources/names.txt");
        Scanner scanner1;

        String name;
        int strength, speed, prep;

        Competitor competitor;

        try{
             scanner1 = new Scanner(file);
        }
        catch(Exception exception){
            return null;
        }

        List <String> names = new ArrayList<>();
        while(scanner1.hasNext()){
            names.add(scanner1.nextLine());
        }
        scanner1.close();

        //tu mieli byc jumper1,LongDistanceRunner1,sprinter1,line ale wtedy wyrzuca blad inicjalizacji 
        
        for(int i=0;i<competitors_number;i++){
            name = names.get(random.nextInt(names.size()));
            strength = random.nextInt(101);
            speed = random.nextInt(101);
            prep = random.nextInt(101);

            switch(random.nextInt(3)){
                case 0: 
                    competitor = new Jumper(name, strength, speed, prep);
                break;
                case 1:
                    competitor = new LongDistanceRunner(name, strength, speed, prep);
                break;
                default:
                    competitor = new Sprinter(name, strength, speed, prep);
                break;
            }
            competitorsList.add(competitor);
        }
    return competitorsList;
    } 
    
}
