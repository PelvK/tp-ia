package tp_ia.among.costo.actions;


import java.util.List;
import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;
import tp_ia.among.costo.*;
import tp_ia.among.heuristica.GlobalVars;

public class goto14 extends SearchAction{
	
	 @Override
	    public SearchBasedAgentState execute(SearchBasedAgentState s){
	    	
	        AmongAgentState state = (AmongAgentState) s;
	        state.incrementarCosto(this.getCost());
	        int energy = state.getEnergy();
	        
	        List<String> possibleMovements = state.getPosibleMovements();
	        List<Integer> roomValues = state.getAirshipRoomValues(GlobalVars.FOURTEEN);
	        
	        if (possibleMovements != null && energy > 0) {
	            int index = possibleMovements.indexOf(GlobalVars.FOURTEEN); 
	            
	            if (index >= 0) {
	                state.setPosition(GlobalVars.FOURTEEN);
	                if (roomValues.get(0) == -1 && roomValues.get(1) == -1)
	                {
	                	state.setRoomValues(GlobalVars.FOURTEEN, List.of(0,0));
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
	    	List<Integer> roomValues = amongState.getAirshipRoomValues(GlobalVars.FOURTEEN);

	    	if(possibleMovements != null && amongEnergy > 0)
	    	{
	    		int index = possibleMovements.indexOf(GlobalVars.FOURTEEN);
	    		
	    		if (index >= 0) {
	    			amongState.setPosition(GlobalVars.FOURTEEN);
	    			if (roomValues.get(0) == -1 && roomValues.get(1) == -1)
	                {
	                	amongState.setRoomValues(GlobalVars.FOURTEEN, List.of(0,0));
	                }
	    			amongState.setEnergy(amongEnergy-1);
	    			airshipState.setAgentPosition(GlobalVars.FOURTEEN);
	    			airshipState.setAgentEnergy(amongEnergy - 1);
	    			
	    			if (GlobalVars.dinamycCrewmaters) {
	    				airshipState.setAirship(GlobalVars.updateCrewmatesPositions(airshipState.getAirship()));
	    			}
	    			
	    			return airshipState;
	    		}
	    		
	    	}    	
	    	return null;
	    }
    @Override
    public String toString() {
    	return "ME VOY AL 14\n=================================\n=================================\n\n";
    }

    @Override
    public Double getCost() {
    	return 7.0;
    }
    
}
