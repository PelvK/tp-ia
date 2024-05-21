package ui;

import tp_ia.among.*;

//UpdateStep.java
public class UpdateStep {
 private AmongAgentState agentState;
 private AmongEnvironmentState environmentState;
 private String action;

 public UpdateStep(AmongAgentState agentState, AmongEnvironmentState environmentState, String action) {
     this.agentState = agentState;
     this.environmentState = environmentState;
     this.action = action;
 }

 public UpdateStep(AmongAgentState agentState2, Object environmentState2, String action2) {
	 this.agentState = agentState2;
     this.action = action2;
}

public AmongAgentState getAgentState() {
     return agentState;
 }

 public AmongEnvironmentState getEnvironmentState() {
     return environmentState;
 }
 
 public String getAction() {
	 return action;
 }
}
