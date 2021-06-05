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

    List <Competitor> generateCompetitors(){
        Random random = new Random();
        competitorsList = new ArrayList<Competitor>() ;

        File file = new File("names.txt");
        Scanner scanner1 = new Scanner(file);
        
        int random_name_number;        
        //tu mieli byc jumper1,LongDistanceRunner1,sprinter1,line ale wtedy wyrzuca blad inicjalizacji 
        
        for(int i=0;i<competitors_number;i++){

            random_name_number = random.nextInt(18238);
            for(int j=0;j<random_name_number;j++){
                line = scanner1.nextLine();
            }

            int random_competitor_type=random.nextInt(3); 
            switch(random_competitor_type){
                case 0: 
                jumper1.name = line;
                jumper1.strength = random.nextInt(101);
                jumper1.speed = random.nextInt(101);
                jumper1.prep = random.nextInt(101);
                competitorsList.add(jumper1);
                break;

                case 1:
                sprinter1.name = line;
                sprinter1.strength = random.nextInt(101);
                sprinter1.speed = random.nextInt(101);
                sprinter1.prep = random.nextInt(101);
                competitorsList.add(sprinter1);
                break;

                case 2:
                longDistanceRunner1.name = line;
                longDistanceRunner1.strength = random.nextInt(101);
                longDistanceRunner1.speed = random.nextInt(101);
                longDistanceRunner1.prep = random.nextInt(101);
                competitorsList.add(longDistanceRunner1);               
                break;
            }
        }
    return competitorsList;
    } 
    
}
