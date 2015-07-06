package com.sec.factories;

import com.sec.roads.AbstractRoad;
import com.sec.signalcontrollers.AbstractTrafficSignal;
import com.sec.signalcontrollers.NPhasedTrafficController;
import com.sec.signalcontrollers.TwoPhasedTrafficController;
import com.sec.utils.Constants.ROAD_TYPE;
import com.sec.utils.Constants.SIGNAL_TYPE;

public class SignalFactory extends AbstractFactory {

	public AbstractTrafficSignal getSignal(SIGNAL_TYPE signalType) {
		if (signalType == SIGNAL_TYPE.SIGNAL_TWOPHASED) {
			return new TwoPhasedTrafficController();
		} else if (signalType == SIGNAL_TYPE.SIGNAL_NPHASED) {
			return new NPhasedTrafficController();
		} else {
			return null;
		}
	}

	@Override
	public AbstractRoad getRoad(ROAD_TYPE roadType) {
		return null;
	}

}
