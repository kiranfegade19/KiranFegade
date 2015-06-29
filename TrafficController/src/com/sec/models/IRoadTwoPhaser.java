package com.sec.models;

/**
 *  This interface represents the Two Phaser behaviour for road class
 * @author Kiran
 * @date 28/06/2015
 */
public interface IRoadTwoPhaser {

	public static final int PHASEA = 1;
	public static final int PHASEB = 2;
	
	/**
	 * 
	 * @return returns the phase to which current road block belongs
	 */
	public int getType();
	
}
