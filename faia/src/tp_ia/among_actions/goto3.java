package tp_ia.among.actions;

import java.util.ArrayList;

import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;
import tp_ia.among.*;

public class goto3 extends SearchAction{
	
	
	//SACAR
	
    @Override
    public SearchBasedAgentState execute(SearchBasedAgentState s){
        AmongAgentState agentState = (AmongAgentState) s; // trata a s del tipo AmongAgentState
        int energy = agentState.getEnergy();

        ArrayList<String> possibleMovments = new ArrayList<String>(); // para ver a donde se puede mover
        possibleMovments.addAll(agentState.getPosibleMovements());


        if (possibleMovments != null && energy > 0) {
            int index = possibleMovments.indexOf(AmongAgentState.THREE); // si ONE esta en la lista, establece la posicion del agente en ONE
            if (index >= 0) {
                agentState.setPosition(AmongAgentState.THREE);
                agentState.setEnergy(energy-1);

                return agentState;
            }

        }

        return null;
    }

   
    @Override
    public EnvironmentState execute(AgentState ast, EnvironmentState est) {
    	
    	/*
    	AmongEnvironmentState environmentState = (AmongEnvironmentState) est;
    	AmongAgentState amongState = ((AmongAgentState) ast);
    	
    	amongState.setPosition(AmongAgentState.THREE);
    	amongState.setEnergy(amongState.getEnergy() - 1);
    	
    	
    	environmentState.setAgentEnergy(environmentState.getAgentEnergy() - 1);
    	environmentState.setAgentPosition(AmongAgentState.THREE);

        return environmentState;
        */
    	
    	AmongEnvironmentState environmentState = (AmongEnvironmentState) est;
    	 
    	environmentState.setAgentEnergy(environmentState.getAgentEnergy() - 1);
    	environmentState.setAgentPosition(AmongAgentState.THREE);

    	this.execute((SearchBasedAgentState) ast);
    	
    	return null;
    }

    @Override
    public String toString() {
        return "GoTo2";
    }

    @Override
    public Double getCost() {
    	
    	return 0.0;
    }
    
}