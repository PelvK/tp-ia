package tp_ia.among;


import java.util.HashMap;
import java.util.List;

import frsf.cidisi.faia.agent.Action;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.environment.Environment;

public class AmongEnvironment extends Environment {

    public AmongEnvironment() {
   
        this.environmentState = new AmongEnvironmentState();
    }

    public AmongEnvironmentState getEnvironmentState() {
    	
    	return (AmongEnvironmentState) super.getEnvironmentState();
    }
    
    
    @Override
    public Perception getPercept() {
        
    	AmongPerception perception = new AmongPerception();
    	
    	perception.setAdjacencySensor(this.getAdjacency(this.getEnvironmentState().getAgentPosition()));
    	
    	return perception;
    }

    @Override
    public String toString() {
    	 return environmentState.toString();
    }
    
    public HashMap<String, List<Integer>> getAdjacency(String position) {
    	
    	return ((AmongEnvironmentState) this.environmentState).getAdjacency(position);
    }
    
    @Override
    public boolean agentFailed(Action actionReturned) {
        float agentEnergy = this.getEnvironmentState().getAgentEnergy();
        if (agentEnergy < 1)
            return true;
        return false;
    }	
   
}