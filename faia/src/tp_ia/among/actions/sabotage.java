package tp_ia.among.actions;

import java.util.Collection;

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
        Collection<Integer> room = amongState.getAirshipRoomValues(position);
        
        if (room  == null) return null;
        
        if ((int)room.toArray()[1] == 1 && (amongState.getEnergy() > 0)) {
            
        	amongState.setEnergy(amongState.getEnergy() - 1);
        	room.toArray()[1] = (int)room.toArray()[1]  - 1;
        	amongState.setRoomValues(position, room);
        	amongState.setRemainingTasks(amongState.getRemainingTasks() - 1);
        	
            return amongState;
        }

        return null;
    }

    @Override
    public EnvironmentState execute(AgentState ast, EnvironmentState est) {

        AmongEnvironmentState airshipState = (AmongEnvironmentState) est;
        AmongAgentState amongState = ((AmongAgentState) ast);
        String position = airshipState.getAgentPosition();
        Collection<Integer> room = airshipState.getAirshipRoomValues(position);
        
        if ((int)room.toArray()[1]  == 1 && airshipState.getAgentEnergy() > 0) {
        	
        	room.toArray()[1]  = 0;
        	
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
        return 1.0;
    }
    
    @Override
    public String toString() {
        return "Sabotage";
    }
}
