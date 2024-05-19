package tp_ia.among.costo;


import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class GlobalVars {
	
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
    
    public static String initialNode = ONE;
    public static int totalCrewmembers = 3;
    public static int totalSabotageTask = 3;
    public static int initalAmongEnergy = 50;
    
    public static List<String> successorNodesONE = List.of(TWO, THREE, FOUR);
    public static List<String> successorNodesTWO = List.of(ONE, THREE, FOUR, FIVE, SEVEN);
    public static List<String> successorNodesTHREE = List.of(ONE, TWO, FOUR, SIX, EIGHT);
    public static List<String> successorNodesFOUR = List.of(TWO, THREE, ONE);
    public static List<String> successorNodesFIVE = List.of(TWO, SEVEN);
    public static List<String> successorNodesSIX = List.of(THREE, EIGHT);
    public static List<String> successorNodesSEVEN = List.of(TWO, NINE, FIVE, TEN);
    public static List<String> successorNodesEIGHT = List.of(TEN, SIX, THREE, ELEVEN, TWELVE);
    public static List<String> successorNodesNINE = List.of(SEVEN, THIRTEEN, FOURTEEN, TWELVE);
    public static List<String> successorNodesTEN = List.of(SEVEN, EIGHT);
    public static List<String> successorNodesELEVEN = List.of(EIGHT, TWELVE);
    public static List<String> successorNodesTWELVE = List.of(THIRTEEN, NINE, FOURTEEN, EIGHT, ELEVEN);
    public static List<String> successorNodesTHIRTEEN = List.of(NINE, TWELVE, FOURTEEN);
    public static List<String> successorNodesFOURTEEN = List.of(NINE, THIRTEEN, TWELVE);
    
    private static HashMap<String, List<String>> movements = movements(0);
    
    
    /*
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
    
    */
    
    public static HashMap<String, List<Integer>> emptyAirship(Integer type){
    	
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
    		
    	case 3:
    		s.put(ONE,Arrays.asList(-1, -1));
        	s.put(TWO, Arrays.asList(-1, -1));
        	s.put(THREE, Arrays.asList(-1, -1));
        	s.put(FOUR, Arrays.asList(-1, -1));
        	s.put(FIVE, Arrays.asList(-1, -1));
        	s.put(SIX, Arrays.asList(-1, -1));
    		s.put(SEVEN, Arrays.asList(-1, -1));
    		s.put(EIGHT, Arrays.asList(-1, -1));
    		s.put(NINE, Arrays.asList(-1, -1));
    		s.put(TEN, Arrays.asList(-1, -1));
    		s.put(ELEVEN, Arrays.asList(-1, -1));
    		s.put(TWELVE, Arrays.asList(-1, -1));
    		s.put(THIRTEEN, Arrays.asList(-1, -1));
    		s.put(FOURTEEN, Arrays.asList(-1, -1));
    		break;
    		
    	case 4: 
    		s.put(ONE,Arrays.asList(0, 0));
        	s.put(TWO, Arrays.asList(0, 0));
        	s.put(THREE, Arrays.asList(0, 0));
        	s.put(FOUR, Arrays.asList(0, 0));
        	s.put(FIVE, Arrays.asList(0, 0));
        	s.put(SIX, Arrays.asList(0, 0));
    		s.put(SEVEN, Arrays.asList(0, 0));
    		s.put(EIGHT, Arrays.asList(0, 0));
    		s.put(NINE, Arrays.asList(0, 0));
    		s.put(TEN, Arrays.asList(0, 0));
    		s.put(ELEVEN, Arrays.asList(0, 0));
    		s.put(TWELVE, Arrays.asList(0, 0));
    		s.put(THIRTEEN, Arrays.asList(0, 0));
    		s.put(FOURTEEN, Arrays.asList(0, 0));
    		break;
    	}
    	
		
		return s;
    }
    
    
    public static HashMap<String, List<String>> successors(){
    	
    	HashMap<String, List<String>> s = new HashMap<>();
		
    	s.put(ONE, GlobalVars.successorNodesONE);
    	s.put(TWO, GlobalVars.successorNodesTWO);
    	s.put(THREE, GlobalVars.successorNodesTHREE);
    	s.put(FOUR, GlobalVars.successorNodesFOUR);
    	s.put(FIVE, GlobalVars.successorNodesFIVE);
    	s.put(SIX, GlobalVars.successorNodesSIX);
		s.put(SEVEN, GlobalVars.successorNodesSEVEN);
		s.put(EIGHT, GlobalVars.successorNodesEIGHT);
		s.put(NINE, GlobalVars.successorNodesNINE);
		s.put(TEN, GlobalVars.successorNodesTEN);
		s.put(ELEVEN, GlobalVars.successorNodesELEVEN);
		s.put(TWELVE, GlobalVars.successorNodesTWELVE);
		s.put(THIRTEEN, GlobalVars.successorNodesTHIRTEEN);
		s.put(FOURTEEN, GlobalVars.successorNodesFOURTEEN);
		
		return s;
    }
    
    public static boolean AllTheWorldIsVisited() {
    	return false;
    }
    
    
    public static HashMap<String, List<Integer>> updateCrewmatesPositions(HashMap<String, List<Integer>> airship) {
    	
    	
    		HashMap<String, List<Integer>> newAirship = emptyAirship(4);
    		
    		for (Entry<String, List<Integer>> entry : airship.entrySet()) {
    		
    	    String key = entry.getKey();
    	    List<Integer> value = airship.get(key);
    	    
    	    int crewmates = value.get(0);
    	    
    	    if (crewmates > 0)
    	    {
    	    	List<String> connections = movements.get(key);
    	    	int cantAdjacency = connections.size();
    	    	
    	    	for (int i = 0; i<crewmates; i++)
        	    {
        	    	int moveProbability = getRandom(1,3);
        	    	
        	    	if (moveProbability == 1)
        	    	{
        	    		int roomProbability = getRandom(0, cantAdjacency-1);
        	    		String selectedRoom = connections.get(roomProbability);
        	    		
        	    		List<Integer> selectedRoomValues = airship.get(selectedRoom);
        	    		newAirship.put(selectedRoom, List.of(selectedRoomValues.get(0) + 1, selectedRoomValues.get(1)));
        	    		newAirship.put(key, List.of(value.get(0) - 1, value.get(1)));
        	    	
        	    	}
        	    	else
        	    	{
        	    		newAirship.put(key, value);
        	    	}
        	    }
    	    }
    	    
 
    		}
    	
    	
    	return newAirship;
    }
    
    public static HashMap<String, List<Integer>> airships(int type){
    	
    	HashMap<String, List<Integer>> airship = new HashMap<>();
    	
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
			airship.put(TWELVE, Arrays.asList(0, 0));
			airship.put(THIRTEEN, Arrays.asList(0, 1));
			airship.put(FOURTEEN, Arrays.asList(0, 0));
			break;
			
    	case 2:
    		airship.put(ONE, Arrays.asList(1, 1));
			airship.put(TWO, Arrays.asList(0, 0));
			airship.put(THREE, Arrays.asList(1, 1));
			airship.put(FOUR, Arrays.asList(2, 0));
			break;
			
    	case 3:
    		airship.put(ONE, Arrays.asList(0, 0));
			airship.put(TWO, Arrays.asList(0, 0));
			airship.put(THREE, Arrays.asList(0, 0));
			airship.put(FOUR, Arrays.asList(1, 1));
			airship.put(FIVE, Arrays.asList(1, 0));
			airship.put(SIX, Arrays.asList(1, 1));
			airship.put(SEVEN, Arrays.asList(0, 0));
			airship.put(EIGHT, Arrays.asList(0, 0));
			airship.put(NINE, Arrays.asList(0, 0));
			airship.put(TEN, Arrays.asList(0, 0));
			airship.put(ELEVEN, Arrays.asList(0, 0));
			airship.put(TWELVE, Arrays.asList(0, 1));
			airship.put(THIRTEEN, Arrays.asList(0, 0));
			airship.put(FOURTEEN, Arrays.asList(0, 0));
    		;
    	}
    	
    	return airship;
    }
    
    
    	public static HashMap<String, List<String>> movements(int type){
    	
    	return successors();
    	
    	//por el momento retornamos eso, pero al acortar el mapa habria que reducir caminos, por eso el type
    	
    	/*
    	HashMap<String, List<String>> movements = new HashMap<>();
    	
    	switch(type)
    	{
    	case 1:
    		
    		for (int i = 0; i < POSITIONS.length; i++) {
	            ArrayList<String> successors = new ArrayList<String>();
	            for (int j = 1; j < POSITIONS[i].length; j++) {
	                successors.add(POSITIONS[i][j]);
	            }
	            movements.put(POSITIONS[i][0], successors);
	        }
    		
    	break;
    	}
    	*/
    }
    	
    	private static int getRandom(int p, int t)
        {
        	return (int)(Math.random()*(t-p+1)+p);
        	
        }
}