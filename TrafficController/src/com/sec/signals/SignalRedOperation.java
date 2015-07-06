package com.sec.signals;

import com.sec.roads.AbstractRoad;

public class SignalRedOperation implements SignalOperations {

	@Override
	public void sendSignalUpdate(AbstractRoad road) {
		road.setVehicleCount(road.getVehicleCount() + road.getVehiclesPerSecondIn());
	}
}
