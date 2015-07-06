package com.sec.signalcontrollers;

import java.util.List;

import com.sec.roads.AbstractRoad;
import com.sec.roads.IRoadTwoPhaser;
import com.sec.signals.SignalGreenOperation;
import com.sec.signals.SignalRedOperation;
import com.sec.signals.SignalYellowOperation;

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
	private int stepCounter;
	private StringBuilder strBuilder = new StringBuilder();
	
	/**
	 * 
	 * @param phaseARoads : roads that belongs to phase A. (roads for which green and red light will operate exactly same)
	 * @param phaseBRoads : roads that belongs to phase B. (roads for which green and red light will operate exactly same)
	 * @param greenTime : time of green light for each road block
	 * @param yellowTime : time between green to red light transition for each road block
	 * @param numberOfCycles : number of cycles
	 * @throws IllegalArgumentException : if number of roads are not 3 or 4 OR timings provided are not valid then IllegalArgumentException is thrown
	 */
	@Override
	public void initSignal(List<IRoadTwoPhaser> roads, int greenTime, int yellowTime, int numberOfCycles) throws IllegalArgumentException {
		this.greenTime = greenTime;
		this.yellowTime = yellowTime;
		this.numberOfCycles = numberOfCycles;
		if( (roads == null) || (roads.size() > 4 || roads.size() < 3) ) {
			throw new IllegalArgumentException("Two Phased Traffic Controller need 3 or 4 roads !");
		}
		
		if(greenTime < 1 || yellowTime < 0 ||  numberOfCycles < 1) {
			throw new IllegalArgumentException("Invalid timings entered !");
		}
		
		this.roads = roads;
		this.numberOfRoads = this.roads.size();
		
		greenSignal = new SignalGreenOperation();
		yellowSignal = new SignalYellowOperation();
		redSignal = new SignalRedOperation();
	}
	
	/**
	 *  starts the transitions of signals and vehicle counting on the roads
	 */
	@Override
	public void startTraffic() {
		while(true) {
			
			strBuilder.setLength(0);
			for(int i = 0; i < numberOfRoads; i++) {
				if(i == 0)
					strBuilder.append(stepCounter +": " + ((AbstractRoad)roads.get(i)).getRoadName() + " = " + ((AbstractRoad)roads.get(i)).getVehicleCount());
				else if(i == 1)
					strBuilder.append("; " + ((AbstractRoad)roads.get(i)).getRoadName() + " = " + ((AbstractRoad)roads.get(i)).getVehicleCount());
				else if(i == 2)
					strBuilder.append("; " + ((AbstractRoad)roads.get(i)).getRoadName() + " = " + ((AbstractRoad)roads.get(i)).getVehicleCount());
				else if(i == 3)
					strBuilder.append("; " + ((AbstractRoad)roads.get(i)).getRoadName() + " = " + ((AbstractRoad)roads.get(i)).getVehicleCount());
			}
			System.out.println(strBuilder);
			
			
			if((currentGreenPhase == IRoadTwoPhaser.PHASEA) && (yelloCounter < 1)) {   //   phase A is Green
				
				for(IRoadTwoPhaser road : roads) {
					if(road.getType() == IRoadTwoPhaser.PHASEB) {
						((AbstractRoad)road).updateSignalStatus(redSignal);
					} else {
						((AbstractRoad)road).updateSignalStatus(greenSignal);
					}
				}
				greenCounter++;
				
			} else if((currentGreenPhase == IRoadTwoPhaser.PHASEB) && (yelloCounter < 1)) {    //  phase B is Green
				
				for(IRoadTwoPhaser road : roads) {
					if(road.getType() == IRoadTwoPhaser.PHASEA) {
						((AbstractRoad)road).updateSignalStatus(redSignal);
					} else {
						((AbstractRoad)road).updateSignalStatus(greenSignal);
					}
				}
				greenCounter++;
			} else if(yelloCounter > 0) {
				for(IRoadTwoPhaser road : roads) {
						((AbstractRoad)road).updateSignalStatus(yellowSignal);
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
		greenCounter = yelloCounter = 0;
	}

}
