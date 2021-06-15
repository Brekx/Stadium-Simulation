package Utilities;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import People.Competitor;
import People.Jumper;
import People.LongDistanceRunner;
import People.Sprinter;

/**Class representing generator */
public class Generator {
    private int competitors_number;
    private List<Competitor> competitorsList;
    private String line;

    /**
     * Constructor
     * 
     * @param competitors_number number of competitors
     */
    public Generator(int competitors_number){
        this.competitors_number = competitors_number;
    }

    /** 
     * Generate random competitors from attached file, which contains many names
     * 
     * @param random random value
     * @return returns list of competitors
     */
    List <Competitor> generateCompetitors(Random random){
        competitorsList = new ArrayList<Competitor>() ;

        Scanner scanner1;

        String name;
        int strength, speed, prep;

        Competitor competitor;

        try{
             scanner1 = new Scanner(ResourceManager.getNames());
        }
        catch(Exception e){
            throw new Error(e.toString());
        }

        List <String> names = new ArrayList<>();
        while(scanner1.hasNext()){
            names.add(scanner1.nextLine());
        }
        scanner1.close();
        
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
