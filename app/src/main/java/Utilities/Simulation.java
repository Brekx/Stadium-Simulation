package Utilities;

import java.util.Map;
import java.util.Random;

import Places.Stadium;

/**Class representing simulation */
public class Simulation implements FlowControl {
    private int number_of_iterations; ///< number of iterations
    private Random random; ///< random value
    private Stadium stadium; ///< stadium
    private ViewUtility viewUtility; ///< view utility

    /**
     * Constructor with parameters
     * 
     * @param generator generator
     * @param random random value
     * @param number_of_iterations number of iterations
     */
    Simulation(Generator generator, Random random, int number_of_iterations){
        this.random = random;
        this.number_of_iterations = number_of_iterations;
        this.viewUtility = new ViewUtility();
        this.viewUtility.makeView(1, 1, 1);
        this.stadium = new Stadium(1, 1, 1, random, generator.generateCompetitors(random), this);
    }

    /** 
     * Method that runs the whole simulation
     * 
     */
    public void runSimulation(){
        for(int iteration = 0; iteration < number_of_iterations; iteration++){
            //Choosing queues
            stadium.performMovement(random);
            //Performing time
            stadium.performCompetition(random, 0);
        }
        viewUtility.getFrame().setVisible(false);
    }

    public static void main(String[] strings){
        Generator generator = new Generator(10);
        Random random = new Random();
        Simulation simulation = new Simulation(generator, random, 5);
        simulation.runSimulation();

        Frame.view(simulation);
    }

    @Override
    public void move(int index_from, int index_to) {
        viewUtility.getCanva().sectorViews.get(index_from).current_people--;
        viewUtility.getCanva().moveBetween(index_from, index_to);
        viewUtility.getCanva().sectorViews.get(index_to).current_people++;
    }

    @Override
    public void perform_competition() {
        viewUtility.getCanva().sectorViews.forEach(x -> x.animate());
    }

    @Override
    public void addContest(int index) {
        viewUtility.getCanva().sectorViews.get(index).current_people++;
    }

    @Override
    public Map<CompetitorsTypes, String> getResults() {
        return stadium.getResults();
    }
}
