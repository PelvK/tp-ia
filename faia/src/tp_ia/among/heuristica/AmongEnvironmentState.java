package tp_ia.among.heuristica;

import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import frsf.cidisi.faia.state.EnvironmentState;

public class AmongEnvironmentState extends EnvironmentState {

   
    private HashMap<String, List<Integer>> airship;						
    private HashMap<String, List<String>> movements;						
    private String agentPosition;												
    private int agentEnergy;													
    private int totalCrewMembers;
    private int totalTasks;
    


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
        //2 ==> MAPA REDUCIDO (SI PONES ESTE TENES QUE CAMBIAR EL IF DEL GETADJACENCY)
    	
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
    	return totalTasks;
    }

    /*
    public int getTotalTasks() {
    	int n = 0;
   
    	for (Entry<String, List<Integer>> room : airship.entrySet())
    	{
    		n += room.getValue().get(1);
    	}
    	return n;
    }
    */
    
  
    
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
    
    
    public void setTotalTasks(int n) {
    	this.totalTasks = n;
    }
   
    public void setRoomValues(String position, List<Integer> room) {
    		
    	airship.put(position, room);
    }
    
    public List<Integer> getAirshipRoomValues(String room) {
    	
    	return airship.get(room);
   
   }
  
    private void initAirship(int type)
    {
    	
    	airship = GlobalVars.airships(type);
    	movements = GlobalVars.movements(type);
    	totalCrewMembers = GlobalVars.totalCrewmembers;
    	agentPosition = GlobalVars.initialNode;
    	agentEnergy = GlobalVars.initalAmongEnergy;
    	totalTasks = GlobalVars.totalSabotageTask;
    	
    }
    
    public HashMap<String, List<Integer>> getAdjacency(String position) {
    	
    	List<String> rooms = movements.get(position);
    	HashMap<String, List<Integer>> adjacentRooms = new HashMap<String, List<Integer>>();
    	adjacentRooms.put(position, airship.get(position));
    	
    	for(String room : rooms)
    		{
    		if (true) // EN CASO DE LA HABITACION REDUCIDA PONER --> room == GlobalVars.ONE || room == GlobalVars.TWO || room == GlobalVars.THREE || room == GlobalVars.FOUR
    		{
    			adjacentRooms.put(room, airship.get(room));
    		}
    		}
    	
    	return adjacentRooms;
    
    }
    
    public HashMap<String, List<Integer>> getExtrasensory(){
    	return airship;
    }
    
    
    @Override
	public String toString() {
		
		StringBuffer str = new StringBuffer();
		
        str.append("\n=============\nTotal de tripulanes: " + totalCrewMembers + "\n");
        str.append("Total de tareas: " + totalTasks + "\n");
        str.append("Estado actual de la nave:\n");
        
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
