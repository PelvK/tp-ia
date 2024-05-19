package tp_ia.among;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;

public class AmongAgentState extends SearchBasedAgentState {
	


	String position;
	private int energy;
	private int remainingCrewmembers;
	private int remainingTasks;
    private HashMap<String, List<Integer>> airship;
	private HashMap<String, List<String>> movements;
	
	
	
	public AmongAgentState(HashMap<String, List<Integer>> m, String initial_position, int inital_energy,  HashMap<String, List<String>> mov, int crewmembers, int sabotage_tasks) {
        this.airship = m;
        this.position = initial_position;
        this.energy = inital_energy;
        this.movements = mov;
        this.remainingCrewmembers = crewmembers;
        this.remainingTasks = sabotage_tasks;
    }
    

	
    public AmongAgentState() {
        this.initState();
    }
    
    
    @Override
    public void initState() {
    	
    	//airship = GlobalVars.airships(3);
    	airship = GlobalVars.emptyAirship(3);
    	movements = GlobalVars.successors();
        position = GlobalVars.initialNode;
        energy = GlobalVars.initalAmongEnergy;
        remainingCrewmembers = GlobalVars.totalCrewmembers;
        remainingTasks = GlobalVars.totalSabotageTask;        
        
    }
    
    
    @Override
    public SearchBasedAgentState clone() {
    	
    	HashMap<String, List<Integer>>  newAirship = new HashMap<String, List<Integer>>();
    	
    	
    	for (Entry<String, List<Integer>> entry : airship.entrySet()) {
            newAirship.put(entry.getKey(), entry.getValue());
        }
    	
        AmongAgentState newState = new AmongAgentState(
        		newAirship, 
        		this.getPosition(), 
        		this.getEnergy(), 
        		this.movements, 
        		this.getRemainingCrewMembers(), 
        		this.getRemainingTasks());

        return newState;
    }
    

    @Override
    public void updateState(Perception p) {
    	
    	AmongPerception amongPerception = (AmongPerception) p;
    	HashMap<String, List<Integer>> aux = new HashMap<String, List<Integer>>();
    	
    	if(GlobalVars.extrasensoryCycle == 0) {
    		aux = amongPerception.getExtrasensorySensor();
    	}
    	else {
    		aux = amongPerception.getAdjacencySensor();
    	}
    	
    	for (Entry<String, List<Integer>> entry : aux.entrySet()) {
   
    	    String key = entry.getKey();
    	    airship.put(key, aux.get(key));
    	   
    	}
    }
    
    
    @Override
    public boolean equals(Object obj) {
    	
        if (this == obj) return true;
        
        if (obj == null || getClass() != obj.getClass()) return false;

        AmongAgentState compare = (AmongAgentState) obj;

        //boolean sameEnergy = compare.getEnergy() == this.energy;
        boolean sameRoom = compare.getPosition() == this.position;
        boolean sameRemainingCrewmembers = compare.getRemainingCrewMembers() == this.remainingCrewmembers;
        boolean sameRemainingTask = compare.getRemainingTasks() == this.remainingTasks;
        boolean sameAirship = compare.getAirship().equals(this.airship);

        return /*sameEnergy &&*/ sameRoom && sameRemainingCrewmembers && sameRemainingTask && sameAirship;
    }
    
    
    
    public HashMap<String, List<Integer>>  getAirship() {
        return airship;
    }

    public List<Integer> getAirshipRoomValues(String room) {
    	
    	return airship.get(room);
   
    }
    
    public String getPosition() {
        return position;
    }

    public int getEnergy() {
        return energy;
    }

    public int getRemainingCrewMembers() {
        return remainingCrewmembers;
    }

    public int getRemainingTasks() {
        return remainingTasks;
    }
    
    public List<String> getPosibleMovements() {
    	
        return movements.get(position);
    }
    
    
    
    public void setPosition(String position) {
        this.position = position;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public void setRemainingCrewMembers(int crewMembers) {
        this.remainingCrewmembers = crewMembers;
    }

    public void setRemainingTasks(int tasks) {
        this.remainingTasks = tasks;
    }

    public void setRoomValues(String position, List<Integer> room) {
    	
    	airship.put(position, room);
    	
    } 
    
    public Boolean isAlive() {
        return this.getEnergy() >= 0;
    }

    public Boolean isInTheFinal() {
    	return position == GlobalVars.FOURTEEN;
    }
    public Boolean isNoMoreCrewMembers() {
    	
    	/*
    	for (Entry<String, List<Integer>> entry : airship.entrySet()) {
    		
    	    String key = entry.getKey();
    	    List<Integer> value = new ArrayList<>(airship.get(key));
        	
    	    if (value.get(0) != 0)
				return false;
        }
        */
    	
    	return remainingCrewmembers == 0;
    	 	
    	//return true;
    }
    
    public Boolean allSabotagedTasks() {
    	
    	/*
    	for (Entry<String, List<Integer>> entry : airship.entrySet()) {
    		
    	    String key = entry.getKey();
    	    List<Integer> value = new ArrayList<>(airship.get(key));
        	
    	    if (value.get(1) != 0)
				return false;
        }
        */
    	return remainingTasks == 0;
  
    }
    
    public Boolean knowAllTheAirship() {
    	
    	for (Entry<String, List<Integer>> entry : airship.entrySet()) {
    		
    	    String key = entry.getKey();
    	    List<Integer> value = new ArrayList<>(airship.get(key));
        	
    	    if (value.get(0) == -1)
				return false;
			
			if (value.get(1) == -1)
				return false;
        }
    	
    	return true;
    }
    
    @Override
    public String toString() {
    	
    	StringBuffer str = new StringBuffer();
        str.append("\n=============\n--Posicion: " + position + " \n");
        str.append("--Tareas Restantes: " + remainingTasks + " \n");
        str.append("--Tipulantes Restantes: "+remainingCrewmembers+"\n");
        str.append("--Energia: " + energy + " \n");
        str.append("--Conocimiento del Mapa: (POR EL MOMENTO MIREMOS EL AMBIENTE)\n");
        
        
    	/*
    	for (Entry<String, List<Integer>> entry : airship.entrySet()) {
    		
    	    String key = entry.getKey();
    	    List<Integer> value = new ArrayList<>(airship.get(key));
    	   
    	    str.append("[" +  key + "\t");
        	
    	    if (value.get(0) == -1)
				str.append("-,");
			else
				str.append(value.get(0) + ",");
			
			if (value.get(1) == -1)
				str.append("-]");
			else
				str.append(value.get(1) + "]");
			
    	    str.append("\n");
        }
    	*/
        return str.toString();
    }



	
  

}