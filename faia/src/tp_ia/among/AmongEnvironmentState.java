package tp_ia.among;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import frsf.cidisi.faia.state.EnvironmentState;

public class AmongEnvironmentState extends EnvironmentState {

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
   
    private HashMap<String, List<Integer>> airship;						
    private HashMap<String, List<String>> movements;						
    private String agentPosition;												
    private int agentEnergy;													
    private int totalCrewMembers;
    


    public AmongEnvironmentState() {
        
        this.initState();
    }

    @Override
    public Object clone() {
    	
        return airship.clone();
    }

    @Override
    public void initState() {
    	
        //1 ==> MAPA COMPLETO
        //2 ==> MAPA REDUCIDO --> COMENTAR LAS ACCIONES QUE YA NO PUEDE HACER
    	
		airship = new HashMap<String, List<Integer>>();
		movements = new HashMap<String, List<String>>();
		
        this.initAirship(1);
        
    }

    @Override
    public boolean equals(Object obj) {
        return true;
    }
    
	
	public HashMap<String, List<Integer>>  getAirship() {
        return airship;
    }

	public String getAgentPosition() {
        return agentPosition;
    }

    
    public int getAgentEnergy() {
        return agentEnergy;
    }
    
    public int getTotalCrewMembers() {
    	return totalCrewMembers;
    }

    public int getTotalTasks() {
    	int n = 0;
   
    	for (Entry<String, List<Integer>> room : airship.entrySet())
    	{
    		n += room.getValue().get(1);
    	}
    	return n;
    }
    
  
    
    public void setAirship(HashMap<String, List<Integer>>  airship) {
        this.airship = airship;
    }
    
    public void setAgentPosition(String agentPosition) {
        this.agentPosition = agentPosition;
    }
    
    public void setAgentEnergy(int agentEnergy) {
        this.agentEnergy = agentEnergy;
    }
    
    public void setTotalCrewMembers(int n) {
    	this.totalCrewMembers = n;
    }

   
    public void setRoomValues(String position, List<Integer> room) {
    		
    	airship.put(position, room);
    }
    
    public List<Integer> getAirshipRoomValues(String room) {
    	
    	return airship.get(room);
   
   }
  
    private void initAirship(int type)
    {
    	
    	switch(type)
    	{
    	case 1:
    		
    		airship.put(ONE, Arrays.asList(1, 1));
			airship.put(TWO, Arrays.asList(0, 0));
			airship.put(THREE, Arrays.asList(1, 1));
			airship.put(FOUR, Arrays.asList(2, 0));
			airship.put(FIVE, Arrays.asList(0, 0));
			airship.put(SIX, Arrays.asList(0, 0));
			airship.put(SEVEN, Arrays.asList(1, 0));
			airship.put(EIGHT, Arrays.asList(0, 0));
			airship.put(NINE, Arrays.asList(0, 0));
			airship.put(TEN, Arrays.asList(1, 0));
			airship.put(ELEVEN, Arrays.asList(0, 0));
			airship.put(TWELVE, Arrays.asList(1, 0));
			airship.put(THIRTEEN, Arrays.asList(0, 1));
			airship.put(FOURTEEN, Arrays.asList(0, 0));
			break;
			
    	case 2:
    		airship.put(ONE, Arrays.asList(1, 1));
			airship.put(TWO, Arrays.asList(0, 0));
			airship.put(THREE, Arrays.asList(1, 1));
			airship.put(FOUR, Arrays.asList(2, 0));
			break;
    	}
    	
    	movements = successors();
    	totalCrewMembers = 4;
    	agentPosition = ONE;
    	agentEnergy = 50;
    	
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
    
    public HashMap<String, List<Integer>> getAdjacency(String position) {
    	
    	List<String> rooms = movements.get(position);
    	HashMap<String, List<Integer>> adjacentRooms = new HashMap<String, List<Integer>>();
    	adjacentRooms.put(position, airship.get(position));
    	
    	for(String room : rooms)
    		{
    		if (room == ONE || room == TWO || room == THREE || room == FOUR) // ESTE IF DESPUES SACARLOOOOOOOOOOOO
    		{
    			adjacentRooms.put(room, airship.get(room));
    		}
    		}
    	
    	return adjacentRooms;
    
    }
    
    @Override
	public String toString() {
		
		StringBuffer str = new StringBuffer();
		
        str.append("\n=============\nTotal de tripulanes: " + totalCrewMembers + "\n");
        
        	for (Entry<String, List<Integer>> entry : airship.entrySet()) {
    		
    	    String key = entry.getKey();
    	    List<Integer> value = airship.get(key);
    	    
    	    str.append("[" +  key + "\t");
        	
    	    if (value != null)
    	    {
    	    	if (value.get(0) == null)
            		str.append("-,");
            	else
            		str.append(value.get(0) + ",");
            	
            	if (value.get(1) == null)
            		str.append("-]\n");
            	else
            		str.append(value.get(1) + "]\n");
    	    }
        	
        }
    	
        return str.toString();
	}

}
