package tp_ia.among;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import frsf.cidisi.faia.state.EnvironmentState;

public class AmongEnvironmentState extends EnvironmentState {


	public static final String ONE = "Reactor";
    public static final String TWO = "Upper Engine";
    public static final String THREE = "Lower Engine";
    public static final String FOUR = "Security";
    public static final String FIVE = "Medbay";
    public static final String SIX = "Electrical";
    public static final String SEVEN = "Cafeteria";
    public static final String EIGHT = "Storage";
    public static final String NINE = "Weapons";
    public static final String TEN = "Admin";
    public static final String ELEVEN = "Communication";
    public static final String TWELVE = "Shields";
    public static final String THIRTEEN = "02";
    public static final String FOURTEEN = "Navigation";
    
    
    public static final String[][] POSITIONS = new String[][]{
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

   
    private Object[][] airship;									//LA NAVE CON LOS DATOS POR HABITACION
    private HashMap<String, Collection<String>> movements;		//LOS MOVIMIENTOS POSIBLES DESDE CADA HABITACION
    private String agentPosition;								//LA POSICION
    private int agentEnergy;									//LA ENERGIA
    private int totalCrewMembers;
    


    public AmongEnvironmentState() {
        movements = new HashMap<String, Collection<String>>();
        this.initState();
    }

    @Override
    public Object clone() {
        return movements.clone();
    }

    @Override
    public void initState() {
        
    	//INICIALIZA LOS MOVIMIENTOS DEL AGENTE
        for (int i = 0; i < POSITIONS.length; i++) {
            ArrayList<String> successors = new ArrayList<String>();
            for (int j = 1; j < POSITIONS[i].length; j++) {
                successors.add(POSITIONS[i][j]);
            }
            movements.put(POSITIONS[i][0], successors);
        }
        
        //INICIALIZA LA NAVE
        this.initAirship(1);
        this.setAgentPosition(ONE);
        this.setAgentEnergy(50);
        
    }

    @Override
    public boolean equals(Object obj) {
        return true;
    }
    
	@Override
	public String toString() {
		
		return "";
	}
	
	
	
	public Object[][]  getAirship() {
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
   
    	for (Object[] fila : airship) {
            n += (int)fila[2];
        }
    	return n;
    }
    
  
    
    public void setAirship(Object[][] airship) {
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

   
    public void setRoomValues(String position, Object[] room) {
    	
    	for (int i = 0; i < airship.length; i++) {
            if (airship[i].length > 0 && airship[i][0].equals(position)) {
                airship[i] = room;
                return;
            }
        }
    }
    
    public Object[] getAirshipRoomValues(String room) {
    	
   	 for (Object[] row : airship) {
   		 if (row[0].toString().equals(room)) {
   	            return row;
   	        }
   		 
   	 }
       return null;
   }
    
    /*
    public void setWorld(int row, int col, int value) {
        this.world[row][col] = value;
    }
    
    public int getTopCell(int row, int col) {
        if (row == 0) {
            return world[3][col];
        }
        return world[row - 1][col];
    }
    
    public int getLeftCell(int row, int col) {
        if (col == 0) {
            return world[row][3];
        }
        return world[row][col - 1];
    }

    public int getRightCell(int row, int col) {
        if (col == 3) {
            return world[row][0];
        }
        return world[row][col + 1];
    }

    public int getBottomCell(int row, int col) {
        if (row == 3) {
            return world[0][col];
        }
        return world[row + 1][col];
    }
    */


    
    
    
    //PARA CONFIGURAR DIFERENTES ESCENARIOS
    private void initAirship(int id)
    {
    	switch(id)
    	{
    		case 1:
    			
    			airship = new Object[14][3];
    			
    			airship[0] = new Object[]{ONE, 1, 1};
    	        airship[1] = new Object[]{TWO, 0, 0};
    	        airship[2] = new Object[]{THREE, 1, 1};
    	        airship[3] = new Object[]{FOUR, 2, 0};
    	        airship[4] = new Object[]{FIVE, 0, 0};
    	        airship[5] = new Object[]{SIX, 0, 0};
    	        airship[6] = new Object[]{SEVEN, 1, 0};
    	        airship[7] = new Object[]{EIGHT, 0, 0};
    	        airship[8] = new Object[]{NINE, 0, 0};
    	        airship[9] = new Object[]{TEN, 1, 0};
    	        airship[10] = new Object[]{ELEVEN, 0, 0};
    	        airship[11] = new Object[]{TWELVE, 1, 0};
    	        airship[12] = new Object[]{THIRTEEN, 0, };
    	        airship[13] = new Object[]{FOURTEEN, 0, 0};
    			
    			/*
    			airship.put("ONE", Arrays.asList(1, 1));      
    	        airship.put("TWO", Arrays.asList(0, 0));       
    	        airship.put("THREE", Arrays.asList(1, 1));     
    	        airship.put("FOUR", Arrays.asList(2, 0));      
    	        airship.put("FIVE", Arrays.asList(0, 0));      
    	        airship.put("SIX", Arrays.asList(0, 0));       
    	        airship.put("SEVEN", Arrays.asList(1, 0));     
    	        airship.put("EIGHT", Arrays.asList(0, 0));     
    	        airship.put("NINE", Arrays.asList(0, 0));     
    	        airship.put("TEN", Arrays.asList(1, 0));       
    	        airship.put("ELEVEN", Arrays.asList(0, 0));    
    	        airship.put("TWELVE", Arrays.asList(1, 0));   
    	        airship.put("THIRTEEN", Arrays.asList(0, 0));  
    	        airship.put("FOURTEEN", Arrays.asList(0, 1));
    	        
    	        */
    	        
    	
    	        int members = 0;
    	        
    	        for (Object[] fila : airship) {
    	            members += (int)fila[1];
    	        }
    	        
    	        this.setTotalCrewMembers(members);
    			
    		break;
    		
    	}
    }
    
    public Object[][] getAdjacency(String position) {
    	
    	Collection<String> rooms = movements.get(position);
    	Object[][] adjacentRooms = new Object[rooms.size()][3];
    	int n=0;
    	for (int i = 0; i<airship.length; i++)
    	{
    		if (rooms.contains((String)airship[i][0]))
    		{
    			adjacentRooms[n] = airship[i];
    			n++;
    		}
    	}
    	return adjacentRooms;
    
    }
    

}
