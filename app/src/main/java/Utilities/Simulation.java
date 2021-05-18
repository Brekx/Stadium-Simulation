package Utilities;

import java.util.List;
import java.util.Random;

import People.Competitor;
import Places.Stadium;

public class Simulation {
    private int number_of_iterations;
    private Random random;
    private Stadium stadium;
    private List <Competitor> competitorsList;

    Simulation(Generator generator, Random random, int number_of_iterations){
        this.competitorsList = generator.generateCompetitors();
        this.random = random;
        this.number_of_iterations = number_of_iterations;
        this.stadium = new Stadium(1, 1, 1, random);
    }

    public void runSimulation(){
        for(int iteration = 0; iteration < number_of_iterations; iteration++){
            //Choosing queues
            for(Competitor competitor: competitorsList){
                competitor.move(stadium, random);
            }

            //Performing time
            stadium.performCompetition();

        }
        //Result time
    }

    public static void main(String[] strings){
        Generator generator = new Generator(5);
        Random random = new Random();
        Simulation simulation = new Simulation(generator, random, 5);
        simulation.runSimulation();
    }
}
