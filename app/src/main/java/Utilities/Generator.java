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

public class Generator {
    private int competitors_number;
    List<Competitor> competitorsList;
    Jumper jumper1;
    Sprinter sprinter1; 
    LongDistanceRunner longDistanceRunner1;
    String line;

    public Generator(int competitors_number){
        this.competitors_number = competitors_number;
    }

    List <Competitor> generateCompetitors(Random random){
        competitorsList = new ArrayList<Competitor>() ;

        File file = new File("names.txt");
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
