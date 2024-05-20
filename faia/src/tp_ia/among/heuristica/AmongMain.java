package tp_ia.among.heuristica;

import frsf.cidisi.faia.exceptions.PrologConnectorException;
import frsf.cidisi.faia.simulator.SearchBasedAgentSimulator;

public class AmongMain {
	
		private static long startTime;
		private static long endTime;
	
	public static void main(String[] args) throws PrologConnectorException {
	
		AmongAgent amongAgent = new AmongAgent();
		AmongEnvironment amongEnvironment = new AmongEnvironment();
		SearchBasedAgentSimulator simulator = new SearchBasedAgentSimulator(amongEnvironment, amongAgent);
		
		printMemoryUsage();
		startTime = System.currentTimeMillis();
		simulator.start();
		endTime = System.currentTimeMillis();
		printTotalTime();
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
	
	private static void printTotalTime() {
		long totalTime = endTime - startTime;
		long totalSeconds = totalTime / 1000;
        long minutes = totalSeconds / 60;
        long seconds = totalSeconds % 60;
        long milliseconds = totalTime % 1000;

        System.out.println("Tiempo total de ejecución: " + minutes + " minutos, " + seconds + " segundos y " + milliseconds + " milisegundos.");

	}
	
}