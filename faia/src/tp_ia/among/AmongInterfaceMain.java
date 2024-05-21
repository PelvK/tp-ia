package tp_ia.among;

import frsf.cidisi.faia.exceptions.PrologConnectorException;
import frsf.cidisi.faia.simulator.SearchBasedAgentSimulator;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import ui.PantallaJuego;
import ui.SimulationTask;
import ui.UpdateManager;

public class AmongInterfaceMain extends Application  {
	
		private static long startTime;
		private static long endTime;
	
	public static void main(String[] args) throws PrologConnectorException {
	
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		GlobalVars.withInterface = true;
		Pane root = new Pane();
        PantallaJuego pantallaJuego = new PantallaJuego(root);

        pantallaJuego.inicializarJuego();

        Scene scene = new Scene(root, 1000, 415);
        root.setStyle("-fx-background-color: black;");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        AmongAgent amongAgent = new AmongAgent();
		AmongEnvironment amongEnvironment = new AmongEnvironment();
		
		if (amongAgent.getAgentState() instanceof AmongAgentState) {
	        ((AmongAgentState) amongAgent.getAgentState()).setSimulacionListener(pantallaJuego);
	       
	    }
		
		SearchBasedAgentSimulator simulator = new SearchBasedAgentSimulator(amongEnvironment, amongAgent);
		
		
		UpdateManager.getInstance().setListener(pantallaJuego);
		
		startTime = System.currentTimeMillis();
		
		
		SimulationTask task = new SimulationTask(simulator);
	    task.setOnSucceeded(event -> {
	        endTime = System.currentTimeMillis();
	        printTotalTime();
	        printMemoryUsage();
	    });

	    new Thread(task).start();
	 
        
    
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