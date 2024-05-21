package ui;
import frsf.cidisi.faia.simulator.SearchBasedAgentSimulator;
import javafx.concurrent.Task;

public class SimulationTask extends Task<Void> {
    private SearchBasedAgentSimulator simulator;

    public SimulationTask(SearchBasedAgentSimulator simulator) {
        this.simulator = simulator;
    }

    @Override
    protected Void call() throws Exception {
        simulator.start();
        return null;
    }
}