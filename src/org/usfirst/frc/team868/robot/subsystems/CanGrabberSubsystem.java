package org.usfirst.frc.team868.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Subsystem that controls the can grabber.
 */
public class CanGrabberSubsystem extends Subsystem {

	public Solenoid sol;

	public CanGrabberSubsystem(Solenoid pnu1) {
		sol = pnu1;
	}

	public void initDefaultCommand() {

	}

	/**
	 * Opens can grabber.
	 */
	public void open() {
		sol.set(true);
	}

	/**
	 * Closes can grabber.
	 */
	public void close() {
		sol.set(false);
	}

	/**
	 * 
	 * @return true if the can grabber is open.
	 */
	public boolean isOpen() {
		return sol.get();
	}
}