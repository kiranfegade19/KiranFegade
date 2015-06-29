package com.sec.models;


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
	protected int vehicleIgnitionTime;
	protected int numberOfCycles;

	/**
	 * 
	 * @param greenTime : time of green light
	 * @param yellowTime : time of yellow light
	 * @param vehicleIgnitionTime : time required for vehicle to move after red to green signal transition
	 * @param numberOfCycles : number of cycles
	 */
	public AbstractTrafficSignal(int greenTime, int yellowTime, int vehicleIgnitionTime, int numberOfCycles) {
		this.greenTime = greenTime;
		this.yellowTime = yellowTime;
		this.vehicleIgnitionTime = vehicleIgnitionTime;
		this.numberOfCycles = numberOfCycles;
	}

	/**
	 *  starts the transitions of signals and vehicle counting on the roads
	 */
	public abstract void start();
	
	/**
	 *  signal transitions like red to green or vice versa are handled by this method
	 */
	abstract void swapPhase();
}
