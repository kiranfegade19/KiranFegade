package com.sec.roads;

import com.sec.signals.SignalGreenOperation;
import com.sec.signals.SignalOperations;

/**
 *  This class represents the road entity which is used for two phased traffic system
 * @author Kiran
 * @date 28/06/2015
 */
public class TwoPhasedRoad extends AbstractRoad implements IRoadTwoPhaser {

	private int roadPhase;

	/**
	 * Initializes the road object
	 */
	@Override
	public void initRoad(int roadPhase, int vehiclesPerSecondIn, int vehiclesPerSecondOut, int vehiclesIgnitionTime, String roadName) {
		this.vehiclesPerSecondIn = vehiclesPerSecondIn;
		this.vehiclesPerSecondOut = vehiclesPerSecondOut;
		this.vehicleIgnitionTime = vehiclesIgnitionTime;
		this.roadName = roadName;
		this.roadPhase = roadPhase;
		this.vehicleIgnitionCurrentTime = this.vehicleIgnitionTime + 1;
	}

	/**
	 *   returns the Phase of the road
	 */
	@Override
	public int getType() {
		return this.roadPhase;
	}

	@Override
	public void updateSignalStatus(SignalOperations operation) {
		
		if(!(operation instanceof SignalGreenOperation)) {
			this.vehicleIgnitionCurrentTime = 1;
		}
			
		operation.sendSignalUpdate(this);
	}

}
