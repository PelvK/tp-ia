package ui;

import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import tp_ia.among.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

public class PantallaJuego implements SimulacionListener {

	private Pane contenedor;
    static private Cuadrado cuadrado;
    private Label room;
    private Label tripulantes;
    private Label tareas;
    private Label energia;
    private Label accion;
    
    static private Cuadrado ONE;
    static private Cuadrado TWO;
    static private Cuadrado THREE;
    static private Cuadrado FOUR;
    static private Cuadrado FIVE;
    static private Cuadrado SIX;
    static private Cuadrado SEVEN;
    static private Cuadrado EIGHT;
    static private Cuadrado NINE;
    static private Cuadrado TEN;
    static private Cuadrado ELEVEN;
    static private Cuadrado TWELVE;
    static private Cuadrado THIRTEEN;
    static private Cuadrado FOURTEEN;
    
    private static List<Cuadrado> cuadradosEspeciales = new ArrayList<>();
    
    static private ImageView fondo;
    private String imageTask;
    private String imageImpostor;
    //private String imageWin;
    //private String imageLose;
    
    
    static HashMap<String, List<Double>> points = new HashMap<String, List<Double>>();
    
    
    
    private static List<Double> ONEPoint = List.of((double)80, (double)180);
    private static List<Double> TWOPoint = List.of((double)160, (double)80);
    private static List<Double> THREEPoint = List.of((double)160, (double)280);
    private static List<Double> FOURPoint = List.of((double)220, (double)180);
    private static List<Double> FIVEPoint = List.of((double)280, (double)150);
    private static List<Double> SIXPoint = List.of((double)280, (double)250);
    private static List<Double> SEVENPoint = List.of((double)410, (double)80);
    private static List<Double> EIGHTPoint = List.of((double)395, (double)295);
    private static List<Double> NINEPoint = List.of((double)565, (double)65);
    private static List<Double> TENPoint = List.of((double)490, (double)230);
    private static List<Double> ELEVENPoint = List.of((double)485, (double)335);
    private static List<Double> TWELVEPoint = List.of((double)565, (double)285);
    private static List<Double> THIRTEENPoint = List.of((double)520, (double)150);
    private static List<Double> FOURTEENPoint = List.of((double)685, (double)165);
    
    static {
    	points.put(GlobalVars.ONE, ONEPoint);
    	points.put(GlobalVars.TWO, TWOPoint);
    	points.put(GlobalVars.THREE, THREEPoint);
    	points.put(GlobalVars.FOUR, FOURPoint);
    	points.put(GlobalVars.FIVE, FIVEPoint);
    	points.put(GlobalVars.SIX, SIXPoint);
    	points.put(GlobalVars.SEVEN, SEVENPoint);
    	points.put(GlobalVars.EIGHT, EIGHTPoint);
    	points.put(GlobalVars.NINE, NINEPoint);
    	points.put(GlobalVars.TEN, TENPoint);
    	points.put(GlobalVars.ELEVEN, ELEVENPoint);
    	points.put(GlobalVars.TWELVE, TWELVEPoint);
    	points.put(GlobalVars.THIRTEEN, THIRTEENPoint);
    	points.put(GlobalVars.FOURTEEN, FOURTEENPoint);
    }
  

    public PantallaJuego(Pane contenedor) {
        this.contenedor = contenedor;
    }

    public void inicializarJuego() {
    	
    	
    	 String directorioPath = "media";
         File directorio = new File(directorioPath);
         
         
         String rutaImagen = directorio.getAbsolutePath() + File.separator + "airship_pro.png";
         fondo = new ImageView(new Image(new File(rutaImagen).toURI().toString()));
         
         fondo.setFitWidth(contenedor.getWidth());
         fondo.setFitHeight(contenedor.getHeight());
         contenedor.getChildren().add(0, fondo);
         
         imageImpostor = directorio.getAbsolutePath() + File.separator + "impostor.png";
         imageTask = directorio.getAbsolutePath() + File.separator + "task.png";
         //imageWin = directorio.getAbsolutePath() + File.separator + "win.png";
         //imageLose = directorio.getAbsolutePath() + File.separator + "lose.png";
         
         cuadrado = new Cuadrado(50, 50, 30, imageImpostor);
        
         ONE = new Cuadrado(80, 180, 10, imageImpostor);
         TWO = new Cuadrado(160, 80, 10, imageImpostor);
         THREE = new Cuadrado(160, 280, 10, imageImpostor);
         FOUR = new Cuadrado(220, 180, 10, imageImpostor);
         FIVE = new Cuadrado(280, 150, 10, imageImpostor);  
         SIX = new Cuadrado(280, 250, 10, imageImpostor);
         SEVEN = new Cuadrado(410, 80, 10, imageImpostor);
         EIGHT = new Cuadrado(395, 295, 10, imageImpostor);
         NINE = new Cuadrado(565, 65, 10, imageImpostor);
         TEN = new Cuadrado(490, 230, 10, imageImpostor);
         ELEVEN = new Cuadrado(485, 335, 10, imageImpostor);
         TWELVE = new Cuadrado(565, 285, 10, imageImpostor);
         THIRTEEN = new Cuadrado(520, 150, 10, imageImpostor);
         FOURTEEN = new Cuadrado(685, 165, 10, imageImpostor);
         
         
         
         cuadradosEspeciales.add(cuadrado);
         cuadradosEspeciales.add(ONE);
         cuadradosEspeciales.add(TWO);
         cuadradosEspeciales.add(THREE);
         cuadradosEspeciales.add(FOUR);
         cuadradosEspeciales.add(FIVE);
         cuadradosEspeciales.add(SIX);
         cuadradosEspeciales.add(SEVEN);
         cuadradosEspeciales.add(EIGHT);
         cuadradosEspeciales.add(NINE);
         cuadradosEspeciales.add(TEN);
         cuadradosEspeciales.add(ELEVEN);
         cuadradosEspeciales.add(TWELVE);
         cuadradosEspeciales.add(THIRTEEN);
         cuadradosEspeciales.add(FOURTEEN);
         
         ONE.getForma().setVisible(false);
         TWO.getForma().setVisible(false);
         THREE.getForma().setVisible(false);
         FOUR.getForma().setVisible(false);
         FIVE.getForma().setVisible(false);
         SIX.getForma().setVisible(false);
         SEVEN.getForma().setVisible(false);
         EIGHT.getForma().setVisible(false);
         NINE.getForma().setVisible(false);
         TEN.getForma().setVisible(false);
         ELEVEN.getForma().setVisible(false);
         TWELVE.getForma().setVisible(false);
         THIRTEEN.getForma().setVisible(false);
         FOURTEEN.getForma().setVisible(false);
        
        room = new Label("Iniciando simulación...");
        tripulantes = new Label();
        tareas = new Label();  
        energia = new Label();
        accion = new Label();
        
        room.setText("Room: " + GlobalVars.initialNode);
        tripulantes.setText("Tripulantes: " + GlobalVars.totalCrewmembers);
        energia.setText("Energía: " + GlobalVars.initalAmongEnergy);
        tareas.setText("Tareas: " + GlobalVars.totalSabotageTask);
        
        contenedor.getChildren().add(cuadrado.getForma());
        contenedor.getChildren().add(ONE.getForma());
        contenedor.getChildren().add(TWO.getForma());
        contenedor.getChildren().add(THREE.getForma());
        contenedor.getChildren().add(FOUR.getForma());
        contenedor.getChildren().add(FIVE.getForma());
        contenedor.getChildren().add(SIX.getForma());
        contenedor.getChildren().add(SEVEN.getForma());
        contenedor.getChildren().add(EIGHT.getForma());
        contenedor.getChildren().add(NINE.getForma());
        contenedor.getChildren().add(TEN.getForma());
        contenedor.getChildren().add(ELEVEN.getForma());
        contenedor.getChildren().add(TWELVE.getForma());
        contenedor.getChildren().add(THIRTEEN.getForma());
        contenedor.getChildren().add(FOURTEEN.getForma());
        
        
        contenedor.getChildren().add(room);
        contenedor.getChildren().add(tripulantes);
        contenedor.getChildren().add(tareas);
        contenedor.getChildren().add(energia);
        contenedor.getChildren().add(accion); 
        
        room.setLayoutX(780);
        room.setLayoutY(140);
       
        tripulantes.setLayoutX(780);
        tripulantes.setLayoutY(200);
        
        tareas.setLayoutX(780);
        tareas.setLayoutY(230);
        
        accion.setLayoutX(780);
        accion.setLayoutY(290);
        
        energia.setLayoutX(780);
        energia.setLayoutY(260);
        
        String estilo = "-fx-text-fill: white; -fx-font-size: 16px; -fx-font-weight: bold;";
        room.setStyle(estilo);
        tripulantes.setStyle(estilo);
        tareas.setStyle(estilo);
        energia.setStyle(estilo);
        accion.setStyle(estilo);
        
        List<Double> initialPoint = points.get(GlobalVars.initialNode);
        cuadrado.setX(initialPoint.get(0));
        cuadrado.setY(initialPoint.get(1));
        
    }


    @Override
    public void onUpdate(UpdateStep updateStep) {
        Platform.runLater(() -> {
            AmongAgentState agentState = updateStep.getAgentState();
            AmongEnvironmentState environmentState = updateStep.getEnvironmentState();
            
            
            limpiarContenedor(contenedor, cuadradosEspeciales, fondo);
            renderTareas(updateStep);
            renderTripulantes(updateStep);
            
            room.setText("Room: " + agentState.getPosition());
            tripulantes.setText("Tripulantes: " + environmentState.getTotalCrewMembers());
            energia.setText("Energía: " + agentState.getEnergy());
            tareas.setText("Tareas: " + environmentState.getTotalTasks());
            accion.setText("Acción: " + updateStep.getAction());
            
            /*
            if (environmentState.getTotalTasks() == 0 &&  environmentState.getTotalCrewMembers() == 0) {
            	if(GlobalVars.withInterface) {
    				UpdateManager.getInstance().update(new UpdateStep(agentState, environmentState, "win"), GlobalVars.timeStep);
    			}
            }
            else if (agentState.getEnergy() == 0) {
            	if(GlobalVars.withInterface) {
    				UpdateManager.getInstance().update(new UpdateStep(agentState, environmentState, "lose"), GlobalVars.timeStep);
    			}
            }
            */
            double desfasaje = 15;
            
            Cuadrado targetCuadrado = null;

            switch (updateStep.getAction()) {
                case "goto1":
                    targetCuadrado = ONE;
                    break;
                case "goto2":
                    targetCuadrado = TWO;
                    break;
                case "goto3":
                    targetCuadrado = THREE;
                    break;
                case "goto4":
                    targetCuadrado = FOUR;
                    break;
                case "goto5":
                    targetCuadrado = FIVE;
                    break;
                case "goto6":
                    targetCuadrado = SIX;
                    break;
                case "goto7":
                    targetCuadrado = SEVEN;
                    break;
                case "goto8":
                    targetCuadrado = EIGHT;
                    break;
                case "goto9":
                    targetCuadrado = NINE;
                    break;
                case "goto10":
                    targetCuadrado = TEN;
                    break;
                case "goto11":
                    targetCuadrado = ELEVEN;
                    break;
                case "goto12":
                    targetCuadrado = TWELVE;
                    break;
                case "goto13":
                    targetCuadrado = THIRTEEN;
                    break;
                case "goto14":
                    targetCuadrado = FOURTEEN;
                    break;
                case "win":
                    win();
                    break;
                case "lose":
                	lose();
                    break;
            }

            if (targetCuadrado != null) {
                TranslateTransition transition = new TranslateTransition(Duration.seconds(0.5), cuadrado.getForma());
                double targetX = targetCuadrado.getX();
                double targetY = targetCuadrado.getY();
                transition.setToX(targetX - desfasaje);
                transition.setToY(targetY - desfasaje);
            
                
                transition.setOnFinished(event -> {
                    cuadrado.setX(targetX - desfasaje);
                    cuadrado.setY(targetY - desfasaje);
                    
                });

                transition.play();
            }
        });
    }
    
    
    private void renderTareas(UpdateStep updateStep) {
    	
    	HashMap <String, List<Integer>> airship = updateStep.getAgentState().getAirship();
    
    	for (Entry<String, List<Integer>> entry : airship.entrySet()) {
        	
        	String key = entry.getKey();
            List<Integer> value = entry.getValue();
            
            if (value.get(1) == 1)
            {
            	List<Double> point = points.get(key);
         
                Cuadrado tarea = new Cuadrado(point.get(0), point.get(1), 20, imageTask);
                contenedor.getChildren().add(tarea.getForma());
            }
        }
    }
    
    private void renderTripulantes(UpdateStep updateStep) {
    	
    	HashMap <String, List<Integer>> airship = updateStep.getAgentState().getAirship();
    	
    	for (Entry<String, List<Integer>> entry : airship.entrySet()) {
        	
        	String key = entry.getKey();
            List<Integer> value = entry.getValue();
            
            
            if (value.get(0) > 0)
            {
            	int desfasaje = 10;
            	int cantCrewmates = value.get(0);
            	
            	for (int i = 0; i<cantCrewmates; i++)
            	{
            		List<Double> point = points.get(key);
                    Cuadrado tarea = new Cuadrado(point.get(0) - desfasaje, point.get(1) - desfasaje, 20, imageImpostor);
                    contenedor.getChildren().add(tarea.getForma());
                    desfasaje += 10;
            	}
            	
            }
        }
    }
    
    
    private void limpiarContenedor(Pane contenedor, List<Cuadrado> cuadradosEspeciales, ImageView fondo) {
        Iterator<Node> iterator = contenedor.getChildren().iterator();

        List<Node> formasEspeciales = new ArrayList<>();
        for (Cuadrado especial : cuadradosEspeciales) {
            formasEspeciales.add(especial.getForma());
        }

        while (iterator.hasNext()) {
            Node node = iterator.next();
            if (node != fondo && node != room && node != tareas && node != tripulantes && node != energia && node != accion && !formasEspeciales.contains(node)) {
                iterator.remove();
            }
        }
    }
    
    private void win() {
        showResultScreen("G");
    }

    private void lose() {
        showResultScreen("P");
    }

    private void showResultScreen(String message) {
        Platform.runLater(() -> {
            Stage resultStage = new Stage();
            StackPane root = new StackPane();
            Label label = new Label(message);
            label.setStyle("-fx-font-size: 24px; -fx-text-fill: white; -fx-background-color: black; -fx-padding: 20px;");
            root.getChildren().add(label);

            Scene scene = new Scene(root, 300, 200);
            resultStage.setScene(scene);
            resultStage.setTitle(message);
            resultStage.show();
        });
    }
}

