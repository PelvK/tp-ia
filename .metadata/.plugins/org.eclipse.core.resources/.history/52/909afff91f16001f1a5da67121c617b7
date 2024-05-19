package tp_ia.among.costo;

import frsf.cidisi.faia.solver.search.IEstimatedCostFunction;
import frsf.cidisi.faia.solver.search.NTree;

public class Heuristic implements IEstimatedCostFunction{

	@Override
	public double getEstimatedCost(NTree node) {
		// TODO Auto-generated method stub
		AmongAgentState amongState = (AmongAgentState) node.getAgentState();
		double nodos = amongState.getAirship().size();
		return nodos;
	}

}
