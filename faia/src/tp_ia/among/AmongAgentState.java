package tp_ia.among;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

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
	
	private Object[][] airship;
	String position;
	private int energy;
	private int remainingCrewMembers;
	private int remainingTasks;
	private HashMap<String, Collection<String>> movements;
	
	
	public AmongAgentState(Object[][] m, String start_position, int start_energy,  HashMap<String, Collection<String>> mov, int crewMembers, int tasks) {
        airship = m;
        position = start_position;
        energy = start_energy;
        movements = mov;
        remainingCrewMembers = crewMembers;
        remainingTasks = tasks;
    }
    

	
    public AmongAgentState() {
        airship = new Object[14][3];
        this.initState();
    }
    
    
    
    @Override
    public SearchBasedAgentState clone() {
    	
        Object[][] newAirship = new Object[14][3];
        
        
        for (int row = 0; row < airship.length; row++) {
            for (int col = 0; col < airship[row].length; col++) {
                newAirship[row][col] = airship[row][col];
            }
        }

        /*
         
        CREO QUE DE ANTEMANO NO FUNCIONARIOA PORQUE ESTAS SUPONIENDO QUE LA MATRIZ ES CUADRADA
        (POR LOS LIMITES SUPERIORES IGUALES)
        
        for (int row = 0; row < airship.length; row++) {
            for (int col = 0; col < airship.length; col++) {
                newAirship[row][col] = airship[row][col];
            }
        }
        
        */
        
        //String newPosition = position;
        //Integer newEnergy = energy;

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
    	
    	Object[][] aux = amongPerception.getAdjacencySensor();
    	
    	for (Object[] adjacencyRoom : aux) {
    		
    		for (int i=0; i<airship.length; i++){
    			
    			
    			if (airship[i][0] == adjacencyRoom[0]) {
    				airship[i] = adjacencyRoom;
    			}
    		}
    		
    	}
    	energy = this.getEnergy();
    	remainingTasks = this.getRemainingTasks();
    	remainingCrewMembers = this.getRemainingCrewMembers();
    
    }
    
    @Override
    public boolean equals(Object obj) {

        if (!(obj instanceof AmongAgentState)) {
            return false;
        }
        return position.equals(((AmongAgentState) obj).getPosition());
    }
    
    
    
    
    
    public Object[][] getAirship() {
        return airship;
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
    public void setAirshipPosition(int row, int[] values) {
    	
        this.airship[row][0] = values[0];
        this.airship[row][1] = values[1];
        this.airship[row][2] = values[2];
    }
    */
    
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
    	airship[0][0] = ONE;
    	airship[1][0] = TWO;
    	airship[2][0] = THREE;
    	airship[3][0] = FOUR;
    	airship[4][0] = FIVE;
    	airship[5][0] = SIX;
    	airship[6][0] = SEVEN;
    	airship[7][0] = EIGHT;
    	airship[8][0] = NINE;
    	airship[9][0] = TEN;
    	airship[10][0] = ELEVEN;
    	airship[11][0] = TWELVE;
    	airship[12][0] = THIRTEEN;
    	airship[13][0] = FOURTEEN;
    	
   
    	
    }
    
    
    public void setRoomValues(String position, Object[] room) {
    	
    	for (int i = 0; i < airship.length; i++) {
            if (airship[i].length > 0 && airship[i][0].equals(position)) {
                airship[i] = room;
             
            }
        }
    }
    
    public Collection<String> getPosibleMovements() {
    	
        return movements.get(position);
    }
    
    public Boolean isAlive() {
        return this.getEnergy() > 0;
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
        for (int i=0; i<this.airship.length;i++)
        {
        	str.append("[" +  airship[i][0] + "\t");
        	
        	if (airship[i][1] == null)
        		str.append("-,");
        	else
        		str.append(airship[i][1] + ",");
        	
        	if (airship[i][2] == null)
        		str.append("-]\n");
        	else
        		str.append(airship[i][2] + "]\n");
        }
        return str.toString();
    }
    
    
    /*
    public Boolean isNoMoreCrewmates() {
        
    	for(int i = 0; i < airship.length; i++)
    	{
    		if (airship[i][2] == null || (int)airship[i][1] != 0)
    			return false;
    	}
    	return true;   	
    }
    
    public Boolean allSabotagedTasks() {
    	
    	for(int i = 0; i < airship.length; i++)
    	{
    		if (airship[i][2] == null || (int)airship[i][2] == 1)
    			return false;
    	}
    	return true;
    }
*/

}