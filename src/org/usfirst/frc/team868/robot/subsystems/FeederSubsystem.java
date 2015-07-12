package org.usfirst.frc.team868.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Subsystem that controls the feeder.
 */
public class FeederSubsystem extends Subsystem {

	private Solenoid sol;
	private CANTalon leftMotor;
	private CANTalon rightMotor;
	private AnalogInput leftSensor;
	private AnalogInput rightSensor;

	public void initDefaultCommand() {

	}

	public FeederSubsystem(Solenoid userSol, CANTalon userLeftMotor, CANTalon userRightMotor, AnalogInput userLeftSensor, AnalogInput userRightSensor) {
		sol = userSol;
		leftMotor = userLeftMotor;
		rightMotor = userRightMotor;
		leftSensor = userLeftSensor;
		rightSensor = userRightSensor;

		leftMotor.enableBrakeMode(true);
		leftMotor.reverseOutput(false);

		rightMotor.enableBrakeMode(true);
		rightMotor.reverseOutput(false);
	}

	public void setLeftWheelSpeed(double speed) {
		leftMotor.set(speed);
	}

	public void setRightWheelSpeed(double speed) {
		rightMotor.set(speed);
	}
	
	public void setWheelSpeeds(double speed){
		leftMotor.set(speed);
		rightMotor.set(speed);
	}

	public void inLeftWheel() {
		leftMotor.set(0.5);
	}

	public void outLeftWheel() {
		leftMotor.set(-0.5);
	}

	public void inRightWheel() {
		rightMotor.set(-0.5);
	}

	public void outRightWheel() {
		rightMotor.set(0.5);
	}
	
	public void stopLeftWheel(){
		leftMotor.set(0);
	}
	
	public void stopRightWheel(){
		rightMotor.set(0);
	}

	public void pullBothMotors() {
		leftMotor.set(0.5);
		rightMotor.set(-0.5);
	}

	public void pushBothMotors() {
		leftMotor.set(-0.5);
		rightMotor.set(0.5);
	}

	public void stopMotors() {
		leftMotor.set(0);
		rightMotor.set(0);
	}

	public double getLeftSensor() {
		return leftSensor.getVoltage();
	}

	public double getRightSensor() {
		return rightSensor.getVoltage();
	}

	public double getMinimumEncoderDistance() {
		if (getLeftSensor() < getRightSensor())
			return getLeftSensor();
		else
			return getRightSensor();
	}

	public void putFeedersIn() {
		sol.set(true);
	}

	public void putFeedersOut() {
		sol.set(false);
	}

	public boolean isFeederIn() {
		return sol.get();
	}

	public boolean isSpinning() {
		return rightMotor.get() != 0 && leftMotor.get() != 0;
	}

	public boolean isToteIn() {
		return getMinimumEncoderDistance() >= 1.75;
	}
	
	public double getLeftSpeed(){
		return leftMotor.get();
	}
	
	public double getRightSpeed(){
		return rightMotor.get();
	}
}
