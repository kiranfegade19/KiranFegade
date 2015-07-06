package com.sec.signals;

import com.sec.roads.AbstractRoad;

public class SignalGreenOperation implements SignalOperations {

	@Override
	public void sendSignalUpdate(AbstractRoad road) {

		road.setVehicleCount(road.getVehicleCount() + road.getVehiclesPerSecondIn());
		
		if (road.getVehicleIgnitionCurrentTime() >= road.getVehicleIgnitionTime()) {
			road.setVehicleCount(road.getVehicleCount() - road.getVehiclesPerSecondOut());
		}
		
		road.setVehicleIgnitionCurrentTime(road.getVehicleIgnitionCurrentTime() + 1);
	}
}