package tp_ia.among;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map.Entry;

import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;

public class AmongAgentState extends SearchBasedAgentState {
	
	
	public static final String ONE = "Reactor ";
    public static final String TWO = "Upper Engine";
    public static final String THREE = "Lower Engine";
    public static final String FOUR = "Security";
    public static final String FIVE = "Medbay ";
    public static final String SIX = "Electrical";
    public static final String SEVEN = "Cafeteria";
    public static final String EIGHT = "Storage";
    public static final String NINE = "Weapons";
    public static final String TEN = "Admin   ";
    public static final String ELEVEN = "Communication";
    public static final String TWELVE = "Shields";
    public static final String THIRTEEN = "02     ";
    public static final String FOURTEEN = "Navigation";


	String position;
	private int energy;
	private int remainingCrewMembers;
	private int remainingTasks;
    private HashMap<String, Collection<Integer>> airship;
	private HashMap<String, Collection<String>> movements;
	
	
	public AmongAgentState(HashMap<String, Collection<Integer>> m, String start_position, int start_energy,  HashMap<String, Collection<String>> mov, int crewMembers, int tasks) {
        airship = m;
        position = start_position;
        energy = start_energy;
        movements = mov;
        remainingCrewMembers = crewMembers;
        remainingTasks = tasks;
    }
    

	
    public AmongAgentState() {
        airship = new HashMap<String, Collection<Integer>>();
        this.initState();
    }
    
    
    
    @Override
    public SearchBasedAgentState clone() {
    	
    	HashMap<String, Collection<Integer>>  newAirship = new HashMap<String, Collection<Integer>>();
    	
    	for (Entry<String, Collection<Integer>> entry : newAirship.entrySet()) {
            newAirship.put(entry.getKey(), entry.getValue());
        }
        
        String newPosition = position;
        Integer newEnergy = energy;

        AmongAgentState newState = new AmongAgentState(newAirship, this.getPosition(), this.energy, this.movements, this.remainingCrewMembers, this.remainingTasks);

        return newState;
    }
    
    
    @Override
    public void initState() {
        position = ONE;
        
        String[][] positions = new String[][]{
            {ONE, TWO,THREE, FOUR},
            {TWO, ONE, THREE, FOUR, FIVE, SEVEN},
            {THREE, ONE, TWO, FOUR, SIX, EIGHT},
            {FOUR, TWO, THREE},
            {FIVE, TWO, SEVEN},
            {SIX, THREE, EIGHT},
            {SEVEN, TWO, NINE, FIVE},
            {EIGHT, TEN, SIX, THREE, ELEVEN, TWELVE},
            {NINE, SEVEN, THIRTEEN, FOURTEEN, ELEVEN},
            {TEN, SEVEN, EIGHT},
            {ELEVEN, EIGHT, TWELVE},
            {TWELVE, THIRTEEN, NINE, FOURTEEN},
            {THIRTEEN, NINE, TWELVE, FOURTEEN},
            {FOURTEEN, NINE, THIRTEEN, TWELVE}
        };

        movements = new HashMap<String, Collection<String>>();
        for (int i = 0; i < positions.length; i++) {
            ArrayList<String> successors = new ArrayList<String>();
            for (int j = 1; j < positions[i].length; j++) {
                successors.add(positions[i][j]);
            }
            movements.put(positions[i][0], successors);

        }
        
        this.setFirtsValues();
        this.setPosition(ONE);
        this.setEnergy(50);
        this.setRemainingCrewMembers(7);
        this.setRemainingTasks(3);
        
        
    }

    @Override
    public void updateState(Perception p) {
    	
    	AmongPerception amongPerception = (AmongPerception) p;
    	
    	HashMap<String, Collection<Integer>> aux = amongPerception.getAdjacencySensor();
    	
    	for (Entry<String, Collection<Integer>> entry : aux.entrySet()) {
    		
    	    String key = entry.getKey();
    	    Collection<Integer> value = aux.get(key);
    	    airship.put(key, value);
    	   
    	}
    	
    	energy = this.getEnergy();
    	remainingTasks = this.getRemainingTasks();
    	remainingCrewMembers = this.getRemainingCrewMembers();
    	position = this.getPosition();
    
    }
    
    @Override
    public boolean equals(Object obj) {

        if (!(obj instanceof AmongAgentState)) {
            return false;
        }
        return position.equals(((AmongAgentState) obj).getPosition());
    }
    
    
    
    
    
    public HashMap<String, Collection<Integer>>  getAirship() {
        return airship;
    }

    public Collection<Integer> getAirshipRoomValues(String room) {
    	
    	return airship.get(room);
   
    }
    
    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
    
    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }
    
    public int getRemainingCrewMembers() {
        return remainingCrewMembers;
    }

    public void setRemainingCrewMembers(int crewMembers) {
        this.remainingCrewMembers = crewMembers;
    }

    public int getRemainingTasks() {
        return remainingTasks;
    }

    public void setRemainingTasks(int tasks) {
        this.remainingTasks = tasks;
    }

    
    public void setFirtsValues()
    {
    	airship.put(ONE, null);
    	airship.put(TWO, null);
    	airship.put(THREE, null);
    	airship.put(FOUR, null);
    	airship.put(FIVE, null);
    	airship.put(SIX, null);
    	airship.put(SEVEN, null);
    	airship.put(EIGHT, null);
    	airship.put(NINE, null);
    	airship.put(TEN, null);
    	airship.put(ELEVEN, null);
    	airship.put(TWELVE, null);
    	airship.put(THIRTEEN, null);
    	airship.put(FOURTEEN, null);
 	
    }
    
    
    public void setRoomValues(String position, Collection<Integer> room) {
    	
    	airship.put(position, room);
    	
    }
    
    public Collection<String> getPosibleMovements() {
    	
        return movements.get(position);
    }
    
    public Boolean isAlive() {
        return this.getEnergy() >= 0;
    }

    public Boolean isNoMoreCrewMembers() {
    	return remainingCrewMembers == 0;
    }
    
    public Boolean allSabotagedTasks() {
    	return remainingTasks == 0;
    }
    
    @Override
    public String toString() {
    	
    	StringBuffer str = new StringBuffer();
        str.append("\n--Posicion: " + position + " \n");
        str.append("--Tareas Restantes: " + remainingTasks + " \n");
        str.append("--Tipulantes Restantes: "+remainingCrewMembers+"\n");
        str.append("--Energia: " + energy + " \n");
        str.append("--Conocimiento del Mapa:\n");
        
        
    	
    	for (Entry<String, Collection<Integer>> entry : airship.entrySet()) {
    		
    	    String key = entry.getKey();
    	    Collection<Integer> value = airship.get(key);
    	   
    	    str.append("[" +  key + "\t");
        	
    	    if (value != null)
    	    {
    	    	if (value.toArray()[0] == null)
            		str.append("-,");
            	else
            		str.append(value.toArray()[0] + ",");
            	
            	if (value.toArray()[1] == null)
            		str.append("-]\n");
            	else
            		str.append(value.toArray()[1] + "]");
    	    }
    	    str.append("\n");
        }
    	
        return str.toString();
    }
  

}