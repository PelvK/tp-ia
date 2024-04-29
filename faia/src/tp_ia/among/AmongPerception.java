package tp_ia.among;

import frsf.cidisi.faia.agent.Agent;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.environment.Environment;




public class AmongPerception extends Perception {

    public static int UNKNOWN_PERCEPTION = -1;
    public static int EMPTY_PERCEPTION = 0;
    public static int ENEMY_PERCEPTION = 1;
    public static int FOOD_PERCEPTION = 2;

    private Object[][] adjacencySensor;
    private int energy;

    public AmongPerception() {
        energy = 50;
    }

    public AmongPerception(Agent agent, Environment environment) {
        super(agent, environment);
    }

    /**
     * This method is used to setup the perception.
     */
    @Override
    public void initPerception(Agent agent, Environment environment) {
        //AmongAgent amongAgent = (AmongAgent) agent;
        AmongEnvironment amongEnvironment = (AmongEnvironment) environment;
        AmongEnvironmentState environmentState = amongEnvironment.getEnvironmentState();


        this.setAdjacencySensor(amongEnvironment.getAdjacency(environmentState.getAgentPosition()));
    
    }


    public Object[][] getAdjacencySensor() {
        return adjacencySensor;
    }

    public void setAdjacencySensor(Object[][] adjacencySensor) {
        this.adjacencySensor = adjacencySensor;
    }


    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    @Override
    public String toString() {
        StringBuffer str = new StringBuffer();

        str.append("Energy: " + this.energy);
        str.append("; ");
        str.append("Left Sensor: " + this.adjacencySensor.toString());

        return str.toString();
    }
}
