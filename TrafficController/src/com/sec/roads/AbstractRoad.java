package com.sec.roads;

import com.sec.signals.SignalOperations;

/**
 * This class represents the abstract road class
 * @author Kiran
 * @date 28/06/2015
 */
public abstract class AbstractRoad {

	protected int vehicleCount;
	protected int vehiclesPerSecondIn;
	protected int vehiclesPerSecondOut;
	protected int vehicleIgnitionTime;
	protected int vehicleIgnitionCurrentTime;
	protected String roadName;

	
	public abstract void initRoad(int roadPhase, int vehiclesPerSecondIn, int vehiclesPerSecondOut, int vehiclesIgnitionTime, String roadName);
	
	public int getVehiclesPerSecondIn() {
		return vehiclesPerSecondIn;
	}

	public void setVehiclesPerSecondIn(int vehiclesPerSecondIn) {
		this.vehiclesPerSecondIn = vehiclesPerSecondIn;
	}

	public int getVehiclesPerSecondOut() {
		return vehiclesPerSecondOut;
	}

	public void setVehiclesPerSecondOut(int vehiclesPerSecondOut) {
		this.vehiclesPerSecondOut = vehiclesPerSecondOut;
	}

	public int getVehicleIgnitionTime() {
		return vehicleIgnitionTime;
	}

	public void setVehicleIgnitionTime(int vehicleIgnitionTime) {
		this.vehicleIgnitionTime = vehicleIgnitionTime;
	}

	public int getVehicleIgnitionCurrentTime() {
		return vehicleIgnitionCurrentTime;
	}

	public void setVehicleIgnitionCurrentTime(int vehicleIgnitionCurrentTime) {
		this.vehicleIgnitionCurrentTime = vehicleIgnitionCurrentTime;
	}

	public void setRoadName(String roadName) {
		this.roadName = roadName;
	}

	/**
	 * 
	 * @return : returns current vehicle count on the road
	 */
	public int getVehicleCount() {
		return vehicleCount;
	}

	/**
	 * 
	 * @param vCount : sets current vehicle count on the road
	 */
	public void setVehicleCount(int vCount) {
		vehicleCount = vCount;
	}
	
	/**
	 *  increments the vehicle count
	 */
	public void incrementVehicleCount() {
		vehicleCount += this.vehiclesPerSecondIn;
	}
	
	/**
	 *  decrements the vehicle count
	 */
	public void decrementVihicle() {
		vehicleCount--;
	}
	
	/**
	 * 
	 * @return returns : returns the name of the road
	 */
	public String getRoadName() {
		return this.roadName;
	}
	
	public abstract void updateSignalStatus(SignalOperations operation);
}