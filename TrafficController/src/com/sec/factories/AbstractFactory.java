package com.sec.factories;

import com.sec.roads.AbstractRoad;
import com.sec.signalcontrollers.AbstractTrafficSignal;
import com.sec.utils.Constants.FACTORY_TYPE;
import com.sec.utils.Constants.ROAD_TYPE;
import com.sec.utils.Constants.SIGNAL_TYPE;

public abstract class AbstractFactory {

	public static AbstractFactory getFactory(FACTORY_TYPE factory_type) {

		if (factory_type == FACTORY_TYPE.FACTORY_ROAD) {
			return new RoadFactory();
		} else if (factory_type == FACTORY_TYPE.FACTORY_SIGNAL) {
			return new SignalFactory();
		} else {
			return null;
		}
	}
	
	public abstract AbstractRoad getRoad(ROAD_TYPE roadType);
	public abstract AbstractTrafficSignal getSignal(SIGNAL_TYPE signalType);

}
