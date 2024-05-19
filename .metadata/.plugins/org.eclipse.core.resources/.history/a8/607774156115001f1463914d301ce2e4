package tp_ia.among;

import frsf.cidisi.faia.exceptions.PrologConnectorException;
import frsf.cidisi.faia.simulator.SearchBasedAgentSimulator;

public class AmongMain {
	
	public static void main(String[] args) throws PrologConnectorException {
	
		AmongAgent amongAgent = new AmongAgent();
		AmongEnvironment amongEnvironment = new AmongEnvironment();
		SearchBasedAgentSimulator simulator = new SearchBasedAgentSimulator(amongEnvironment, amongAgent);
		
		printMemoryUsage();
		
		simulator.start();
	}
	
	private static void printMemoryUsage() {
        Runtime runtime = Runtime.getRuntime();
        long totalMemory = runtime.totalMemory();
        long freeMemory = runtime.freeMemory();
        long usedMemory = totalMemory - freeMemory;
        long maxMemory = runtime.maxMemory();

        System.out.println("Total Memory: " + (totalMemory / 1024 / 1024) + " MB");
        System.out.println("Free Memory: " + (freeMemory / 1024 / 1024) + " MB");
        System.out.println("Used Memory: " + (usedMemory / 1024 / 1024) + " MB");
        System.out.println("Max Memory: " + (maxMemory / 1024 / 1024) + " MB");
    }
}