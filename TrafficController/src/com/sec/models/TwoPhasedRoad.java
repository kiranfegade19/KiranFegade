package com.sec.models;

/**
 *  This class represents the road entity which is used for two phased traffic system
 * @author Kiran
 * @date 28/06/2015
 */
public class TwoPhasedRoad extends AbstractRoad implements IRoadTwoPhaser {

	private int roadPhase;

	/**
	 * 
	 * @param roadPhase : phase of the road (North and Sounth roads are under 1 phase, Similarly East and West roads are under another phase)
	 * @param vehiclesPerSecond : Number of vehicles per second on the road.
	 * @param roadName  : represents the name of road
	 */
	
	public TwoPhasedRoad(int roadPhase, int vehiclesPerSecond, String roadName) {
		super(vehiclesPerSecond, roadName);
		this.roadPhase = roadPhase;
	}

	/**
	 *   returns the Phase of the road
	 */
	@Override
	public int getType() {
		return this.roadPhase;
	}
	
}
