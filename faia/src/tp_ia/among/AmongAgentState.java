package tp_ia.among;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;

public class AmongAgentState extends SearchBasedAgentState {
	


	String position;
	private int energy;
	private int remainingCrewMembers;
	private int remainingTasks;
    private HashMap<String, List<Integer>> airship;
	private HashMap<String, List<String>> movements;
	
	public static final String ONE = "Reactor(1)-----------";
    public static final String TWO = "Upper Engine(2)------";
    public static final String THREE = "Lower Engine(3)----";
    public static final String FOUR = "Security(4)---------";
    public static final String FIVE = "Medbay(5)-----------";
    public static final String SIX = "Electrical(6)--------";
    public static final String SEVEN = "Cafeteria(7)-------";
    public static final String EIGHT = "Storage(8)---------";
    public static final String NINE = "Weapons(9)----------";
    public static final String TEN = "Admin(10)------------";
    public static final String ELEVEN = "Communication(11)-";
    public static final String TWELVE = "Shields(12)-------";
    public static final String THIRTEEN = "02(13)----------";
    public static final String FOURTEEN = "Navigation(14)--";
	
	
	public AmongAgentState(HashMap<String, List<Integer>> m, String initial_position, int inital_energy,  HashMap<String, List<String>> mov, int crewmembers, int sabotage_tasks) {
        this.airship = m;
        this.position = initial_position;
        this.energy = inital_energy;
        this.movements = mov;
        this.remainingCrewMembers = crewmembers;
        this.remainingTasks = sabotage_tasks;
    }
    

	
    public AmongAgentState() {
        this.initState();
    }
    
    
    @Override
    public void initState() {
    	
    	airship = emptyAirship(1);
    	movements = successors();
        position = ONE;
        energy = 50;
        remainingCrewMembers = 4;
        remainingTasks = 2;        
        
    }
    
    public static List<String> successorNodesONE = List.of(TWO, THREE, FOUR);
    public static List<String> successorNodesTWO = List.of(ONE, THREE, FOUR, FIVE, SEVEN);
    public static List<String> successorNodesTHREE = List.of(ONE, TWO, FOUR, SIX, EIGHT);
    public static List<String> successorNodesFOUR = List.of(TWO, THREE);
    public static List<String> successorNodesFIVE = List.of(TWO, SEVEN);
    public static List<String> successorNodesSIX = List.of(THREE, EIGHT);
    public static List<String> successorNodesSEVEN = List.of(TWO, NINE, FIVE);
    public static List<String> successorNodesEIGHT = List.of(TEN, SIX, THREE, ELEVEN, TWELVE);
    public static List<String> successorNodesNINE = List.of(SEVEN, THIRTEEN, FOURTEEN, ELEVEN);
    public static List<String> successorNodesTEN = List.of(SEVEN, EIGHT);
    public static List<String> successorNodesELEVEN = List.of(EIGHT, TWELVE);
    public static List<String> successorNodesTWELVE = List.of(THIRTEEN, NINE, FOURTEEN);
    public static List<String> successorNodesTHIRTEEN = List.of(THIRTEEN, NINE, TWELVE, FOURTEEN);
    public static List<String> successorNodesFOURTEEN = List.of(FOURTEEN, NINE, THIRTEEN, TWELVE);
    
    public HashMap<String, List<String>> successors(){
    	
    	HashMap<String, List<String>> s = new HashMap<>();
		
    	s.put(ONE, successorNodesONE);
    	s.put(TWO, successorNodesTWO);
    	s.put(THREE, successorNodesTHREE);
    	s.put(FOUR, successorNodesFOUR);
    	s.put(FIVE, successorNodesFIVE);
    	s.put(SIX, successorNodesSIX);
		s.put(SEVEN, successorNodesSEVEN);
		s.put(EIGHT, successorNodesEIGHT);
		s.put(NINE, successorNodesNINE);
		s.put(TEN, successorNodesTEN);
		s.put(ELEVEN, successorNodesELEVEN);
		s.put(TWELVE, successorNodesTWELVE);
		s.put(THIRTEEN, successorNodesTHIRTEEN);
		s.put(FOURTEEN, successorNodesFOURTEEN);
		
		return s;
    }
    
    public  HashMap<String, List<Integer>> emptyAirship(Integer type){
    	
    	HashMap<String, List<Integer>> s = new HashMap<>();
		
    	switch(type)
    	{
    	case 1:
    		s.put(ONE,null);
        	s.put(TWO, null);
        	s.put(THREE, null);
        	s.put(FOUR, null);
        	s.put(FIVE, null);
        	s.put(SIX, null);
    		s.put(SEVEN, null);
    		s.put(EIGHT, null);
    		s.put(NINE, null);
    		s.put(TEN, null);
    		s.put(ELEVEN, null);
    		s.put(TWELVE, null);
    		s.put(THIRTEEN, null);
    		s.put(FOURTEEN, null);
    		break;
    		
    	case 2:
    		s.put(ONE,null);
        	s.put(TWO, null);
        	s.put(THREE, null);
        	s.put(FOUR, null);
    		break;	
    	}
    	
		
		return s;
    }
    
    @Override
    public SearchBasedAgentState clone() {
    	
    	HashMap<String, List<Integer>>  newAirship = new HashMap<String, List<Integer>>();
    	
    	
    	for (Entry<String, List<Integer>> entry : airship.entrySet()) {
            newAirship.put(entry.getKey(), entry.getValue());
        }

    	Integer i = remainingCrewMembers;
    	
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
    	
    	HashMap<String, List<Integer>> aux = amongPerception.getAdjacencySensor();
    	
    	for (Entry<String, List<Integer>> entry : aux.entrySet()) {
   
    	    String key = entry.getKey();
    	    airship.put(key, aux.get(key));
    	   
    	}
    }
    
    /*
    
    @Override
    public boolean equals(Object obj) {
    	
    	AmongAgentState compare = (AmongAgentState) obj;
    	
    	boolean sameEnergy = compare.getEnergy() == this.getEnergy();
    	boolean sameRoom = compare.getPosition() == this.getPosition();
    	boolean sameRemainingCrewmembers = compare.getRemainingCrewMembers() == this.getRemainingCrewMembers();
    	boolean sameRemainingTask = compare.getRemainingTasks() == this.getRemainingTasks();
    	
    	return (sameEnergy && sameRoom && sameRemainingCrewmembers && sameRemainingTask);

     
    } */
    
    
    @Override
    public boolean equals(Object obj) {
    	
        if (this == obj) return true;
        
        if (obj == null || getClass() != obj.getClass()) return false;

        AmongAgentState compare = (AmongAgentState) obj;

        boolean sameEnergy = compare.getEnergy() == this.energy;
        boolean sameRoom = compare.getPosition() == this.position;
        boolean sameRemainingCrewmembers = compare.getRemainingCrewMembers() == this.remainingCrewMembers;
        boolean sameRemainingTask = compare.getRemainingTasks() == this.remainingTasks;
        boolean sameAirship = compare.getAirship().equals(this.airship);

        return sameEnergy && sameRoom && sameRemainingCrewmembers && sameRemainingTask && sameAirship;
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
        return remainingCrewMembers;
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
        this.remainingCrewMembers = crewMembers;
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

    public Boolean isNoMoreCrewMembers() {
    	return remainingCrewMembers == 0;
    }
    
    public Boolean allSabotagedTasks() {
    	return remainingTasks == 0;
    }
    
    @Override
    public String toString() {
    	
    	StringBuffer str = new StringBuffer();
        str.append("\n=============\n--Posicion: " + position + " \n");
        str.append("--Tareas Restantes: " + remainingTasks + " \n");
        str.append("--Tipulantes Restantes: "+remainingCrewMembers+"\n");
        str.append("--Energia: " + energy + " \n");
        str.append("--Conocimiento del Mapa:\n");
        
        
    	
    	for (Entry<String, List<Integer>> entry : airship.entrySet()) {
    		
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
    	    else
    	    {
    	    	str.append("-,-]");
    	    }
    	    str.append("\n");
        }
    	
        return str.toString();
    }
  

}