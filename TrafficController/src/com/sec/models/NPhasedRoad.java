package com.sec.models;

/**
 * This class can be used for the roads where road count is more than 4 on a traffic signal
 * @author Kiran
 * @date 28/06/2015
 */
public class NPhasedRoad extends AbstractRoad {

	/**
	 * 
	 * @param vehiclesPerSecond : number of vehicles arriving on the road per second
	 * @param vehicleIgnitionTime : time required for vehicle to move when red to green transition occures
	 * @param roadName : Represents name of the road
	 */
	public NPhasedRoad(int vehiclesPerSecond, int vehicleIgnitionTime, String roadName) {
		super(vehiclesPerSecond, roadName);
	}

}