package tp_ia.among;

import frsf.cidisi.faia.agent.Agent;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.environment.Environment;




public class AmongPerception extends Perception {

  
    private Object[][] adjacencySensor;

    
    
    public AmongPerception() {
        
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



    @Override
    public String toString() {
    	
    	StringBuffer str = new StringBuffer();

        str.append("\n");
        for (int i=0; i<this.adjacencySensor.length;i++)
        {
        	
        	str.append("[" +  this.adjacencySensor[i][0] + "\t");
        	str.append(this.adjacencySensor[i][1] + ",");
        	str.append(this.adjacencySensor[i][2] + "]\n");
        }

        return str.toString();
	}
}
