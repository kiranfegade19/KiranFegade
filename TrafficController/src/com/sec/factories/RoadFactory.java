package com.sec.factories;

import com.sec.roads.AbstractRoad;
import com.sec.roads.NPhasedRoad;
import com.sec.roads.TwoPhasedRoad;
import com.sec.signalcontrollers.AbstractTrafficSignal;
import com.sec.utils.Constants.ROAD_TYPE;
import com.sec.utils.Constants.SIGNAL_TYPE;

public class RoadFactory extends AbstractFactory {

	public AbstractRoad getRoad(ROAD_TYPE roadType) {
		if (roadType == ROAD_TYPE.ROAD_TWOPHASED) {
			return new TwoPhasedRoad();
		} else if (roadType == ROAD_TYPE.ROAD_NPHASED) {
			return new NPhasedRoad();
		} else {
			return null;
		}
	}

	@Override
	public AbstractTrafficSignal getSignal(SIGNAL_TYPE signalType) {
		return null;
	}

}
