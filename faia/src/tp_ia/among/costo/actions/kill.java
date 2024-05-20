package tp_ia.among.costo.actions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;
import tp_ia.among.costo.*;
import tp_ia.among.heuristica.GlobalVars;

public class kill extends SearchAction {
	
	@Override
	public SearchBasedAgentState execute(SearchBasedAgentState s) {
	    AmongAgentState amongState = (AmongAgentState) s;

	    String position = amongState.getPosition();
	    amongState.incrementarCosto(this.getCost());
	    Collection<Integer> room = amongState.getAirshipRoomValues(position);

	    if (room == null) return null;

	    List<Integer> roomList = new ArrayList<>(room);

	    if (roomList.get(0) > 0 && (amongState.getEnergy() > 0)) {
	        amongState.setEnergy(amongState.getEnergy() - 1);
	        roomList.set(0, roomList.get(0) - 1);
	        amongState.setRoomValues(position, roomList); 
	        amongState.setRemainingCrewMembers(amongState.getRemainingCrewMembers() - 1);

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
        
        List<Integer> roomList = new ArrayList<>(room);
        
        if (roomList.get(0) > 0 && airshipState.getAgentEnergy() > 0) {
        	
        	roomList.set(0, roomList.get(0) - 1);
        	
        	airshipState.setRoomValues(position, roomList);
        	airshipState.setAgentEnergy(airshipState.getAgentEnergy() - 1);
        	airshipState.setTotalCrewMembers(airshipState.getTotalCrewMembers() - 1);
        	
        	amongState.setRoomValues(position, roomList);
        	amongState.setEnergy(amongState.getEnergy() - 1);
        	amongState.setRemainingCrewMembers(amongState.getRemainingCrewMembers() - 1);
   
        	if (GlobalVars.dinamycCrewmaters) {
				airshipState.setAirship(GlobalVars.updateCrewmatesPositions(airshipState.getAirship()));
			}
			
            return airshipState;
        }
        return null;
    }

    @Override
    public Double getCost() {
        return 2.0;
    }
    
    @Override
    public String toString() {
    	return "ELIMINO\n=================================\n=================================\n\n";
    }
}
