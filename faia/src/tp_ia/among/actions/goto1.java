package tp_ia.among.actions;

import java.util.ArrayList;
import java.util.Collection;

import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;
import tp_ia.among.*;

public class goto1 extends SearchAction{
    @Override
    public SearchBasedAgentState execute(SearchBasedAgentState s){
    	
        AmongAgentState state = (AmongAgentState) s;
        int energy = state.getEnergy();
        ArrayList<String> possibleMovements = new ArrayList<String>();
        
        Collection<String> aux = state.getPosibleMovements();
        
        possibleMovements.addAll(aux);

        if (possibleMovements != null && energy > 0) {
            int index = possibleMovements.indexOf(AmongAgentState.ONE); 
            if (index >= 0) {
                state.setPosition(AmongAgentState.ONE);
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
    	ArrayList<String> possibleMovements = new ArrayList<String>();
    	Collection<String> aux = amongState.getPosibleMovements();
    	
    	possibleMovements.addAll(aux);
    	
    	if(possibleMovements != null && amongEnergy > 0)
    	{
    		int index = possibleMovements.indexOf(AmongAgentState.ONE);
    		if (index >= 0) {
    			amongState.setPosition(AmongAgentState.ONE);
    			amongState.setEnergy(amongEnergy-1);
    			airshipState.setAgentPosition(AmongAgentState.ONE);
    			airshipState.setAgentEnergy(amongEnergy - 1);
    			
    			return airshipState;
    		}
    		
    	}    	
    	return null;
    }

    @Override
    public String toString() {
        return "GoTo1";
    }

    @Override
    public Double getCost() {
    	return 1.0;
    }
    
}
