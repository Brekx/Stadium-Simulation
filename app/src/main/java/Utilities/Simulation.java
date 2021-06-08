package Utilities;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import Places.Stadium;

public class Simulation implements FlowControl {
    private int number_of_iterations;
    private Random random;
    private Stadium stadium;
    private ViewUtility viewUtility;

    Simulation(Generator generator, Random random, int number_of_iterations){
        this.random = random;
        this.number_of_iterations = number_of_iterations;
        this.viewUtility = new ViewUtility();
        this.viewUtility.makeView();
        this.stadium = new Stadium(1, 1, 1, random, generator.generateCompetitors(random), this);
    }

    public void runSimulation(){
        for(int iteration = 0; iteration < number_of_iterations; iteration++){
            //Choosing queues
            stadium.performMovement(random);
            //Performing time
            stadium.performCompetition(random, 2);

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

    @Override
    public void move(int index_from, int index_to) {
        viewUtility.getCanva().sectorViews.get(index_from).current_people--;
        viewUtility.getCanva().moveBetween(index_from, index_to);
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        viewUtility.getCanva().sectorViews.get(index_to).current_people++;
    }

    @Override
    public void perform_competition(int index) {
        viewUtility.getCanva().sectorViews.get(index).animate();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addContest(int index) {
        viewUtility.getCanva().sectorViews.get(index).current_people++;
    }
}
