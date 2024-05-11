package tp_ia.among.actions;

import java.util.ArrayList;
import java.util.Collection;

import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;
import tp_ia.among.*;

public class goto9 extends SearchAction{
	
    @Override
    public SearchBasedAgentState execute(SearchBasedAgentState s){
        AmongAgentState agentState = (AmongAgentState) s; // trata a s del tipo AmongAgentState
        int energy = agentState.getEnergy();

        ArrayList<String> possibleMovments = new ArrayList<String>(); // para ver a donde se puede mover
        possibleMovments.addAll(agentState.getPosibleMovements());


        if (possibleMovments != null && energy > 0) {
            int index = possibleMovments.indexOf(AmongAgentState.NINE); // si ONE esta en la lista, establece la posicion del agente en ONE
            if (index >= 0) {
                agentState.setPosition(AmongAgentState.NINE);
                agentState.setEnergy(energy-1);

                return agentState;
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
    		int index = possibleMovements.indexOf(AmongAgentState.NINE);
    		if (index >= 0) {
    			amongState.setPosition(AmongAgentState.NINE);
    			amongState.setEnergy(amongEnergy-1);
    			airshipState.setAgentPosition(AmongAgentState.NINE);
    			airshipState.setAgentEnergy(amongEnergy - 1);
    			
    			return airshipState;
    		}
    		
    	}    	
    	return null;
    }

    @Override
    public String toString() {
        return "GoTo2";
    }

    @Override
    public Double getCost() {
    	return 1.0;
    }
    
}
