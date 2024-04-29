package tp_ia.among;


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
    
    
    
    
    public Object[][] getAdjacency(String position) {
    	
    	return ((AmongEnvironmentState) this.environmentState).getAdjacency(position);
    }
    
   
}