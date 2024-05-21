package ui;

import javafx.application.Platform;

public class UpdateManager {
    private static UpdateManager instance;
    private SimulacionListener listener;
    private boolean updatePending;
    private final Object lock = new Object();

    private UpdateManager() {
        updatePending = false;
    }

    public static synchronized UpdateManager getInstance() {
        if (instance == null) {
            instance = new UpdateManager();
        }
        return instance;
    }

    public void setListener(SimulacionListener listener) {
        this.listener = listener;
    }

    public void update(UpdateStep updateStep, long delayMillis) {
        if (listener == null) {
            throw new IllegalStateException("SimulacionListener no está configurado");
        }

        synchronized (lock) {
            if (updatePending) {
                return;
            }
            updatePending = true;
        }

    
        try {
            Thread.sleep(delayMillis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Platform.runLater(() -> {
            listener.onUpdate(updateStep);
            synchronized (lock) {
                updatePending = false;
            }
        });
        updateStep.getAgentState().notifySimulacionListener(updateStep.getAgentState(), updateStep.getEnvironmentState(), updateStep.getAction());
    }
}