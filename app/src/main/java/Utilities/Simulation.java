package Utilities;

import java.util.Random;

import Places.Stadium;

public class Simulation {
    private int number_of_iterations;
    private Random random;
    private Stadium stadium;

    Simulation(Generator generator, Random random, int number_of_iterations){
        this.random = random;
        this.number_of_iterations = number_of_iterations;
        this.stadium = new Stadium(1, 1, 1, random, generator.generateCompetitors(random));
    }

    public void runSimulation(){
        for(int iteration = 0; iteration < number_of_iterations; iteration++){
            //Choosing queues
            stadium.performMovement(random);
            //Performing time
            stadium.performCompetition(random);
        }
        //Result time
        stadium.getResults();
    }

    public static void main(String[] strings){
        Generator generator = new Generator(5);
        Random random = new Random();
        Simulation simulation = new Simulation(generator, random, 5);
        simulation.runSimulation();
    }
}
