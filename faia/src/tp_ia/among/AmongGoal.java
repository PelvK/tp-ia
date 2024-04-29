package tp_ia.among;

import frsf.cidisi.faia.agent.search.GoalTest;
import frsf.cidisi.faia.state.AgentState;

public class AmongGoal extends GoalTest {
	

	@Override
	public boolean isGoalState(AgentState agentState) {
		
		if (((AmongAgentState)agentState).isNoMoreCrewMembers() && 
				((AmongAgentState)agentState).allSabotagedTasks() &&
					((AmongAgentState)agentState).isAlive()) {
			return true;
		}
		return false;
	}
}