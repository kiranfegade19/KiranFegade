package com.sec.signalcontrollers;

import java.util.List;

import com.sec.roads.IRoadTwoPhaser;

/**
 * This traffic signal Controller is used when number of road blocks are more than 4
 * @author Kiran
 * @date 28/06/2015
 */
public class NPhasedTrafficController extends AbstractTrafficSignal {
	
	private List<IRoadTwoPhaser> roads;
	
	/**
	 * 
	 * @param roads : Number of road blocks joining on the trafic signal (generally more than 4)
	 * @param greenTime : time of green light for each road block
	 * @param yellowTime : time between each green to red transition
	 * @param numberOfCycles : number of cycles
	 */
	@Override
	public void initSignal(List<IRoadTwoPhaser> roads, int greenTime, int yellowTime, int numberOfCycles) {
		this.roads = roads;
		this.numberOfRoads = this.roads.size();
		
	}

	/**
	 *  starts the transitions of signals and vehicle counting on the roads
	 *  (more than 4 phases signals transitions should be implemented here)
	 */
	@Override
	public void startTraffic() {
		// TODO
	}

	/**
	 *  signal transitions like red to green or vice versa are handled by this method
	 *  (more than 4 phases signals swapping should be implemented here)
	 */
	@Override
	void swapPhase() {
		// TODO
	}

}
