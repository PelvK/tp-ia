package tp_ia.among.actions;


import java.util.List;
import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;
import tp_ia.among.*;
import tp_ia.among.GlobalVars.SimulationMethod;
import ui.UpdateManager;
import ui.UpdateStep;

public class goto5 extends SearchAction{
    @Override
    public SearchBasedAgentState execute(SearchBasedAgentState s){
    	
        AmongAgentState state = (AmongAgentState) s;
        int energy = state.getEnergy();
        
        List<String> possibleMovements = state.getPosibleMovements();
        List<Integer> roomValues = state.getAirshipRoomValues(GlobalVars.FIVE);
        
        if (possibleMovements != null && energy > 0) {
            int index = possibleMovements.indexOf(GlobalVars.FIVE); 
            
            if (index >= 0) {
                state.setPosition(GlobalVars.FIVE);
                
                if (roomValues.get(0) == -1 && roomValues.get(1) == -1) {
                	state.setRoomValues(GlobalVars.FIVE, List.of(0,0));
                }
                state.setEnergy(energy-1);
                GlobalVars.extrasensoryCycle --;
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

    	if(possibleMovements != null && amongEnergy > 0)
    	{
    		int index = possibleMovements.indexOf(GlobalVars.FIVE);
    		
    		if (index >= 0) {
    			amongState.setPosition(GlobalVars.FIVE);
    			//amongState.setRoomValues(GlobalVars.FIVE, List.of(0,0));
    			amongState.setEnergy(amongEnergy-1);
    			airshipState.setAgentPosition(GlobalVars.FIVE);
    			airshipState.setAgentEnergy(amongEnergy - 1);
    			
    			if (GlobalVars.dynamicCrewmates) {
    				airshipState.setAirship(GlobalVars.updateCrewmatesPositions(airshipState.getAirship()));
    			}
    			if(GlobalVars.withInterface) {
    				UpdateManager.getInstance().update(new UpdateStep(amongState, airshipState, "goto5"), GlobalVars.timeStep);
    			}
    			GlobalVars.extrasensoryCycle --;
    			return airshipState;
    		}
    		
    	}    	
    	return null;
    }

    @Override
    public String toString() {
        return "ME MUEVO A 5\n=================================\n=================================\n\n";

    }

    @Override
    public Double getCost() {
    	
    	if (GlobalVars.simulationMethod == SimulationMethod.METHOD_1){
    		return 0.0;
    	}
    	else {
    		return 7.0;
    	}
    }
    
}
