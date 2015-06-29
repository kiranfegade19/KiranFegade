package com.sec.traficcontroller;

import java.util.ArrayList;
import java.util.List;

import com.sec.models.AbstractTrafficSignal;
import com.sec.models.IRoadTwoPhaser;
import com.sec.models.TwoPhasedRoad;
import com.sec.models.TwoPhasedTrafficController;

/**
 * @author Kiran
 * @date 28/06/2015
 */
public class TrafficController {

	public static void main(String[] args) {

		List<IRoadTwoPhaser> aPhased = new ArrayList<IRoadTwoPhaser>(); //  list of North-South roads
		List<IRoadTwoPhaser> bPhased = new ArrayList<IRoadTwoPhaser>(); //  list of East-West roads

		TwoPhasedRoad road1 = new TwoPhasedRoad(IRoadTwoPhaser.PHASEA, 1, "N"); // North Road
		TwoPhasedRoad road2 = new TwoPhasedRoad(IRoadTwoPhaser.PHASEA, 1, "S"); // Sount Road
		aPhased.add(road1);
		aPhased.add(road2);

		TwoPhasedRoad road3 = new TwoPhasedRoad(IRoadTwoPhaser.PHASEB, 1, "E"); // East Road
		TwoPhasedRoad road4 = new TwoPhasedRoad(IRoadTwoPhaser.PHASEB, 1, "W"); // West Road
		bPhased.add(road3);
		bPhased.add(road4);

		try {
			AbstractTrafficSignal controller = new TwoPhasedTrafficController(aPhased, bPhased, 3, 1, 2, 30); // Traffic controller for 2 Phased signal operating
			controller.start();   //  start the traffic on the roads and get results on console
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
		
	}

}
