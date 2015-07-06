package com.sec.traficcontroller;

import java.util.ArrayList;
import java.util.List;

import com.sec.factories.AbstractFactory;
import com.sec.roads.IRoadTwoPhaser;
import com.sec.roads.TwoPhasedRoad;
import com.sec.signalcontrollers.AbstractTrafficSignal;
import com.sec.utils.Constants.FACTORY_TYPE;
import com.sec.utils.Constants.ROAD_TYPE;
import com.sec.utils.Constants.SIGNAL_TYPE;

/**
 * @author Kiran
 * @date 28/06/2015
 */
public class TrafficController {

	public static void main(String[] args) {

		List<IRoadTwoPhaser> roads = new ArrayList<IRoadTwoPhaser>(); //  list of roads

		TwoPhasedRoad road1 = (TwoPhasedRoad) AbstractFactory.getFactory(FACTORY_TYPE.FACTORY_ROAD).getRoad(ROAD_TYPE.ROAD_TWOPHASED); // North Road
		road1.initRoad(IRoadTwoPhaser.PHASEA, 1, 1, 2, "N");
		TwoPhasedRoad road2 = (TwoPhasedRoad) AbstractFactory.getFactory(FACTORY_TYPE.FACTORY_ROAD).getRoad(ROAD_TYPE.ROAD_TWOPHASED); // Sount Road
		road2.initRoad(IRoadTwoPhaser.PHASEA, 1, 1, 2, "S");
		TwoPhasedRoad road3 = (TwoPhasedRoad) AbstractFactory.getFactory(FACTORY_TYPE.FACTORY_ROAD).getRoad(ROAD_TYPE.ROAD_TWOPHASED); // East Road
		road3.initRoad(IRoadTwoPhaser.PHASEB, 1, 1, 2, "E");
		TwoPhasedRoad road4 = (TwoPhasedRoad) AbstractFactory.getFactory(FACTORY_TYPE.FACTORY_ROAD).getRoad(ROAD_TYPE.ROAD_TWOPHASED); // West Road
		road4.initRoad(IRoadTwoPhaser.PHASEB, 1, 1, 2, "W");
		
		roads.add(road1);
		roads.add(road2);
		roads.add(road3);
		roads.add(road4);

		try {
			AbstractTrafficSignal controller = AbstractFactory.getFactory(FACTORY_TYPE.FACTORY_SIGNAL).getSignal(SIGNAL_TYPE.SIGNAL_TWOPHASED);
			controller.initSignal(roads, 3, 1, 30);
			controller.startTraffic();   //  start the traffic on the roads and get results on console
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
	}

}
