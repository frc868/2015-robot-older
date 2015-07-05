package org.usfirst.frc.team868.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Solenoid;

public class RobotFactory {

	private static RobotFactory instance = new RobotFactory();
	
	private CanGrabberSubsystem canGrabber;
	private final int CAN_GRABBER_SOL = 6;
	
	private FeederSubsystem feeder;
	private final int FEEDER_SOL = 4;
	private final int FEEDER_LEFT_MOTOR = 10;
	private final int FEEDER_RIGHT_MOTOR = 13;
	private final int FEEDER_LEFT_SENSOR = 2;
	private final int FEEDER_RIGHT_SENSOR = 1;

	public static RobotFactory getInstance() {
		return instance;
	}

	private RobotFactory() {
		canGrabber = new CanGrabberSubsystem(new Solenoid(CAN_GRABBER_SOL));
		feeder = new FeederSubsystem(new Solenoid(FEEDER_SOL), new CANTalon(FEEDER_LEFT_MOTOR), new CANTalon(FEEDER_RIGHT_MOTOR), new AnalogInput(FEEDER_LEFT_SENSOR), new AnalogInput(FEEDER_RIGHT_SENSOR));
	}

	public CanGrabberSubsystem getCanGrabber() {
		return canGrabber;
	}

	public FeederSubsystem getFeeder() {
		return feeder;
	}
}