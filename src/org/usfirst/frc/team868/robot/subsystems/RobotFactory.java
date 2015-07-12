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
	
	private DriveSubsystem drive;
	private final int DRIVE_RIGHT_MOTOR1 = 18;
	private final int DRIVE_RIGHT_MOTOR2 = 14;
	private final int DRIVE_LEFT_MOTOR1 = 12;
	private final int DRIVE_LEFT_MOTOR_2 = 19;
	
	private ElevatorSubsystem elevator;
	private final int ELEVATOR_MOTOR1 = 20;
	private final int ELEVATOR_MOTOR2 = 15;
	private final int ELEVATOR_SOL = 7;
	
	public static RobotFactory getInstance() {
		return instance;
	}

	private RobotFactory() {
		canGrabber = new CanGrabberSubsystem(new Solenoid(CAN_GRABBER_SOL));
		feeder = new FeederSubsystem(new Solenoid(FEEDER_SOL), new CANTalon(FEEDER_LEFT_MOTOR), new CANTalon(FEEDER_RIGHT_MOTOR), new AnalogInput(FEEDER_LEFT_SENSOR), new AnalogInput(FEEDER_RIGHT_SENSOR));
		drive = new DriveSubsystem(new CANTalon(DRIVE_RIGHT_MOTOR1), new CANTalon(DRIVE_RIGHT_MOTOR2), new CANTalon(DRIVE_LEFT_MOTOR1), new CANTalon(DRIVE_LEFT_MOTOR_2));
		elevator = new ElevatorSubsystem(new CANTalon(ELEVATOR_MOTOR1), new CANTalon(ELEVATOR_MOTOR2), new Solenoid(ELEVATOR_SOL));
	}

	public CanGrabberSubsystem getCanGrabber() {
		return canGrabber;
	}

	public FeederSubsystem getFeeder() {
		return feeder;
	}
	
	public DriveSubsystem getDrive(){
		return drive;
	}
	
	public ElevatorSubsystem getElevator(){
		return elevator;
	}
}