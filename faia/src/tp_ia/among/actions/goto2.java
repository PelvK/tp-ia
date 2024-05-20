package tp_ia.among.actions;


import java.util.HashMap;
import java.util.List;
import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;
import tp_ia.among.*;
import tp_ia.among.heuristica.GlobalVars;

public class goto2 extends SearchAction{
	
	 @Override
	    public SearchBasedAgentState execute(SearchBasedAgentState s){
	    	
	        AmongAgentState state = (AmongAgentState) s;
	        int energy = state.getEnergy();
	        
	        List<String> possibleMovements = state.getPosibleMovements();
	        List<Integer> roomValues = state.getAirshipRoomValues(GlobalVars.TWO);
	        
	        if (possibleMovements != null && energy > 0) {
	            int index = possibleMovements.indexOf(GlobalVars.TWO); 
	            
	            if (index >= 0) {
	                state.setPosition(GlobalVars.TWO);
	                if (roomValues.get(0) == -1 && roomValues.get(1) == -1)
	                {
	                	state.setRoomValues(GlobalVars.TWO, List.of(0,0));
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
	    	List<Integer> roomValues = amongState.getAirshipRoomValues(GlobalVars.TWO);

	    	if(possibleMovements != null && amongEnergy > 0)
	    	{
	    		int index = possibleMovements.indexOf(GlobalVars.TWO);
	    		
	    		if (index >= 0) {
	    			amongState.setPosition(GlobalVars.TWO);
	    			amongState.setEnergy(amongEnergy-1);
	    			if (roomValues.get(0) == -1 && roomValues.get(1) == -1)
	                {
	                	amongState.setRoomValues(GlobalVars.TWO, List.of(0,0));
	                }
	    			airshipState.setAgentPosition(GlobalVars.TWO);
	    			airshipState.setAgentEnergy(amongEnergy - 1);
	    			
	    			if (GlobalVars.dinamycCrewmaters) {
	    				airshipState.setAirship(GlobalVars.updateCrewmatesPositions(airshipState.getAirship()));
	    			}
	    			
	                GlobalVars.extrasensoryCycle --;

	    			return airshipState;
	    		}
	    		
	    	}    	
	    	return null;
	    }

    @Override
    public String toString() {
    	return "ME VOY AL 2\n=================================\n=================================\n\n";
    }

    @Override
    public Double getCost() {
    	return 0.0;
    }
    
}
