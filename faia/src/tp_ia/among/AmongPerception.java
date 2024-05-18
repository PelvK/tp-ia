package tp_ia.among;

import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import frsf.cidisi.faia.agent.Agent;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.environment.Environment;




public class AmongPerception extends Perception {

  
    private HashMap<String, List<Integer>> adjacencySensor;

    
    
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


    public HashMap<String, List<Integer>> getAdjacencySensor() {
        return adjacencySensor;
    }

    public void setAdjacencySensor(HashMap<String, List<Integer>> adjacencySensor) {
        this.adjacencySensor = adjacencySensor;
    }



    @Override
    public String toString() {
    	
    	StringBuffer str = new StringBuffer();

        str.append("\n");
        
        
	for (Entry<String, List<Integer>> entry : adjacencySensor.entrySet()) {
    		
    	    String key = entry.getKey();
    	    List<Integer> value = adjacencySensor.get(key);
    	    str.append("[" +  key + "\t");
        	
    	    if (value != null)
    	    {
    	    	if (value.get(0) == null)
            		str.append("-,");
            	else
            		str.append(value.get(0) + ",");
            	
            	if (value.get(1) == null)
            		str.append("-]\n");
            	else
            		str.append(value.get(1) + "]\n");
    	    }
        	
        }
    	
    
        return str.toString();
        
	}
}
