package tp_ia.among.actions;

import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;
import tp_ia.among.*;

public class sabotage extends SearchAction {
	
	@Override
    public SearchBasedAgentState execute(SearchBasedAgentState s) {
        AmongAgentState amongState = (AmongAgentState) s;

        String position = amongState.getPosition();
        Object[] room = amongState.getAirshipRoomValues(position);
        
        if (room[2] == null) return null;
        
        if ((int)room[2] == 1 && (amongState.getEnergy() > 0)) {
            
        	amongState.setEnergy(amongState.getEnergy() - 1);
        	room[2] = (int)room[2] - 1;
        	amongState.setRoomValues(position, room);
        	
            return amongState;
        }

        return null;
    }

    @Override
    public EnvironmentState execute(AgentState ast, EnvironmentState est) {

        AmongEnvironmentState airshipState = (AmongEnvironmentState) est;
        AmongAgentState amongState = ((AmongAgentState) ast);
        
        String position = airshipState.getAgentPosition();
        Object[] room = airshipState.getAirshipRoomValues(position);
        
        
        if ((int)room[1] > 0 && airshipState.getAgentEnergy() > 0) {
        	
        	room[2] = (int)room[2] - 1;
        	
        	 // Update the real world state
        	airshipState.setRoomValues(position, room);
        	airshipState.setAgentEnergy(airshipState.getAgentEnergy() - 1);
           
        	amongState.setRoomValues(position, room);
        	amongState.setEnergy(amongState.getEnergy() - 1);

            
            return airshipState;
        }
        

        return null;
    }

    @Override
    public Double getCost() {
        return 0.0;
    }
    
    @Override
    public String toString() {
        return "Sabotage";
    }
}
