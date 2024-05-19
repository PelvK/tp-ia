package tp_ia.among.heuristica;

import frsf.cidisi.faia.solver.search.IStepCostFunction;
import frsf.cidisi.faia.solver.search.NTree;
import frsf.cidisi.faia.state.AgentState;

public class CostFunction implements IStepCostFunction {

	 public double calculateCost(AgentState agentState) {
	        return ((AmongAgentState) agentState).getCosto();
	    }
	 
	@Override
	public double calculateCost(NTree node) {
		return node.getAction().getCost();
	}
    
}