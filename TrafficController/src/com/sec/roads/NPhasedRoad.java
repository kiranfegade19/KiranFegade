package com.sec.roads;

import com.sec.signals.SignalOperations;

/**
 * This class can be used for the roads where road count is more than 4 on a traffic signal
 * @author Kiran
 * @date 28/06/2015
 */
public class NPhasedRoad extends AbstractRoad {

	@Override
	public void initRoad(int roadPhase, int vehiclesPerSecondIn, int vehiclesPerSecondOut, int vehiclesIgnitionTime, String roadName) {
		this.vehiclesPerSecondIn = vehiclesPerSecondIn;
		this.vehiclesPerSecondOut = vehiclesPerSecondOut;
		this.vehicleIgnitionTime = vehiclesIgnitionTime;
		this.roadName = roadName;
//		this.roadPhase = roadPhase;
	}

	@Override
	public void updateSignalStatus(SignalOperations operation) {
//		this.vehicleCount = operation.getVehicleCount(this.roadPhase, this.vehiclesPerSecondIn, this.vehiclesPerSecondOut, this.vehicleIgnitionTime, this.vehicleIgnitionCurrentTime);
	}

	

}