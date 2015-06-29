package com.sec.models;

/**
 * This class represents the abstract road class
 * @author Kiran
 * @date 28/06/2015
 */
public abstract class AbstractRoad {

	protected int vehicleCount;
	protected int vehiclesPerSecond;
	protected String roadName;

	/**
	 * 
	 * @param vehiclesPerSecond : vehicles per second arriving on the road
	 */
	public AbstractRoad(int vehiclesPerSecond, String roadName) {
		this.vehiclesPerSecond = vehiclesPerSecond;
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
		vehicleCount += this.vehiclesPerSecond;
	}
	
	/**
	 * 
	 * @return returns : returns the name of the road
	 */
	public String getRoadName() {
		return this.roadName;
	}
}