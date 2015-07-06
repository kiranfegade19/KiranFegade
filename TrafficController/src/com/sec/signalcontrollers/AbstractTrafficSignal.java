package com.sec.signalcontrollers;

import java.util.List;

import com.sec.roads.IRoadTwoPhaser;
import com.sec.signals.SignalOperations;

/**
 * This class represents the abstract Traffic Signal
 * @author Kiran
 * @date 28/06/2015
 */
public abstract class AbstractTrafficSignal {

	protected int numberOfRoads;
	protected int greenTime;
	protected int yellowTime;
	protected int redTime;
	protected int numberOfCycles;
	protected SignalOperations greenSignal;
	protected SignalOperations yellowSignal;
	protected SignalOperations redSignal;

	public abstract void initSignal(List<IRoadTwoPhaser> roads, int greenTime, int yellowTime, int numberOfCycles);
	
	/**
	 *  starts the transitions of signals and vehicle counting on the roads
	 */
	public abstract void startTraffic();
	
	/**
	 *  signal transitions like red to green or vice versa are handled by this method
	 */
	abstract void swapPhase();
}
