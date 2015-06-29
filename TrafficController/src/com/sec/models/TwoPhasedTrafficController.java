package com.sec.models;

import java.util.List;

/**
 * This class represents two phased traffic control system
 * @author Kiran
 * @date 28/06/2015
 */
public class TwoPhasedTrafficController extends AbstractTrafficSignal {

	private List<IRoadTwoPhaser> roads;
	private int currentGreenPhase = IRoadTwoPhaser.PHASEA;
	private int greenCounter;
	private int yelloCounter;
	private int ignitionCounter = this.vehicleIgnitionTime + 1;
	private int stepCounter;
	
	/**
	 * 
	 * @param phaseARoads : roads that belongs to phase A. (roads for which green and red light will operate exactly same)
	 * @param phaseBRoads : roads that belongs to phase B. (roads for which green and red light will operate exactly same)
	 * @param greenTime : time of green light for each road block
	 * @param yellowTime : time between green to red light transition for each road block
	 * @param vehicleIgnitionTime : time required for vehicle to move after red to green signal transition
	 * @param numberOfCycles : number of cycles
	 * @throws IllegalArgumentException : if number of roads are not 3 or 4 OR timings provided are not valid then IllegalArgumentException is thrown
	 */
	public TwoPhasedTrafficController(List<IRoadTwoPhaser> phaseARoads, List<IRoadTwoPhaser> phaseBRoads, int greenTime, int yellowTime, int vehicleIgnitionTime, int numberOfCycles) throws IllegalArgumentException {
		super(greenTime, yellowTime, vehicleIgnitionTime, numberOfCycles);
		
		if( ((phaseARoads == null) || (phaseBRoads == null)) || ((phaseARoads.size() > 2) || (phaseBRoads.size() > 2)) || ((phaseARoads.size() == 0) || (phaseBRoads.size() == 0)) ) {
			throw new IllegalArgumentException("Two Phased Traffic Controller need 3 or 4 roads !");
		}
		
		if(greenTime < 1 || yellowTime < 0 || vehicleIgnitionTime < 0 || numberOfCycles < 1) {
			throw new IllegalArgumentException("Invalid timings entered !");
		}
		
		this.roads = phaseARoads;
		this.roads.addAll(phaseBRoads);
		this.numberOfRoads = this.roads.size();
	}

	/**
	 *  starts the transitions of signals and vehicle counting on the roads
	 */
	@Override
	public void start() {
		while(true) {
			ignitionCounter++;
			
			for(int i = 0; i < numberOfRoads; i++) {
				if(i == 0)
					System.out.print(String.format("#%02d", stepCounter) +" " + ((AbstractRoad)roads.get(i)).getRoadName() + " : " + String.format("%02d", ((AbstractRoad)roads.get(i)).getVehicleCount()));
				else if(i == 1)
					System.out.print(String.format(", " + ((AbstractRoad)roads.get(i)).getRoadName() + " : " + String.format("%02d", ((AbstractRoad)roads.get(i)).getVehicleCount())));
				else if(i == 2)
					System.out.print(String.format(", " + ((AbstractRoad)roads.get(i)).getRoadName() + " : " + String.format("%02d", ((AbstractRoad)roads.get(i)).getVehicleCount())));
				else if(i == 3)
					System.out.print(String.format(", " + ((AbstractRoad)roads.get(i)).getRoadName() + " : " + String.format("%02d", ((AbstractRoad)roads.get(i)).getVehicleCount())));
			
			}
			System.out.println();
			
			
			if((currentGreenPhase == IRoadTwoPhaser.PHASEA) && (yelloCounter < 1)) {   //   phase A is Green
				
				for(IRoadTwoPhaser road : roads) {
					if((road.getType() == IRoadTwoPhaser.PHASEB) || (ignitionCounter < this.vehicleIgnitionTime)) {
						((AbstractRoad)road).incrementVehicleCount();   //  increment vehicles of phase B
					}
				}
				greenCounter++;
				
			} else if((currentGreenPhase == IRoadTwoPhaser.PHASEB) && (yelloCounter < 1)) {    //  phase B is Green
				for(IRoadTwoPhaser road : roads) {
					if((road.getType() == IRoadTwoPhaser.PHASEA) || (ignitionCounter < this.vehicleIgnitionTime)) {
						((AbstractRoad)road).incrementVehicleCount();   //   increment vehicle of phase A
					}
				}
				greenCounter++;
			} else if(yelloCounter > 0) {
				for(IRoadTwoPhaser road : roads) {
						((AbstractRoad)road).incrementVehicleCount();
				}
			}
			
			if((currentGreenPhase == IRoadTwoPhaser.PHASEA) || (currentGreenPhase == IRoadTwoPhaser.PHASEB)) {
				if((greenCounter >= this.greenTime) && (yelloCounter >= this.yellowTime)) {
					swapPhase();
				}
				if(greenCounter >= this.greenTime) {
					yelloCounter++;
				}
			}
			
			
			stepCounter++;
			if(stepCounter > this.numberOfCycles) {
				break;
			}
		}
	}

	/**
	 *  signal transitions like red to green or vice versa are handled by this method
	 */
	@Override		
	void swapPhase() {
		if(currentGreenPhase == IRoadTwoPhaser.PHASEA) {
			currentGreenPhase = IRoadTwoPhaser.PHASEB;
		} else {
			currentGreenPhase = IRoadTwoPhaser.PHASEA;
		}
		greenCounter = yelloCounter = ignitionCounter = 0;
	}
}
