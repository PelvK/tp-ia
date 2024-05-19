package tp_ia.among.heuristica.actions;


import java.util.List;
import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;
import tp_ia.among.heuristica.*;

public class goto4 extends SearchAction{
	
	 @Override
	    public SearchBasedAgentState execute(SearchBasedAgentState s){
	    	
	        AmongAgentState state = (AmongAgentState) s;
	        state.incrementarCosto(this.getCost());
	        int energy = state.getEnergy();
	        
	        List<String> possibleMovements = state.getPosibleMovements();
	        List<Integer> roomValues = state.getAirshipRoomValues(GlobalVars.FOUR);
	        
	        if (possibleMovements != null && energy > 0) {
	            int index = possibleMovements.indexOf(GlobalVars.FOUR); 
	            
	            if (index >= 0) {
	                state.setPosition(GlobalVars.FOUR);
	                if (roomValues.get(0) == -1 && roomValues.get(1) == -1)
	                {
	                	state.setRoomValues(GlobalVars.FOUR, List.of(0,0));
	                }
	                state.setEnergy(energy-1);
	                
	                return state;
	            }
	        }
	        return null;
	    }

	   
	    @Override
	    public EnvironmentState execute(AgentState ast, EnvironmentState est) {
	    	
	    	
	    	
	    	AmongAgentState amongState = (AmongAgentState) ast;
	    	AmongEnvironmentState airshipState = (AmongEnvironmentState) est;
	    	
	    
	    	int amongEnergy = airshipState.getAgentEnergy();
	    	List<String> possibleMovements = amongState.getPosibleMovements();
	    	List<Integer> roomValues = amongState.getAirshipRoomValues(GlobalVars.FOUR);

	    	if(possibleMovements != null && amongEnergy > 0)
	    	{
	    		int index = possibleMovements.indexOf(GlobalVars.FOUR);
	    		
	    		if (index >= 0) {
	    			amongState.setPosition(GlobalVars.FOUR);
	    			if (roomValues.get(0) == -1 && roomValues.get(1) == -1)
	                {
	                	amongState.setRoomValues(GlobalVars.FOUR, List.of(0,0));
	                }
	    			amongState.setEnergy(amongEnergy-1);
	    			airshipState.setAgentPosition(GlobalVars.FOUR);
	    			airshipState.setAgentEnergy(amongEnergy - 1);
	    			
	    			//Para actualizar el movimiento de los tripulantes//
	    			airshipState.setAirship(GlobalVars.updateCrewmatesPositions(airshipState.getAirship()));
	    			
	    			return airshipState;
	    		}
	    		
	    	}    	
	    	return null;
	    }

    @Override
    public String toString() {
    	return "ME VOY AL 4\n=================================\n=================================\n\n";
    }

    @Override
    public Double getCost() {
    	return 7.0;
    }
    
}
