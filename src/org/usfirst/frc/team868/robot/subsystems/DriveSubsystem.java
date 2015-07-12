package org.usfirst.frc.team868.robot.subsystems;

import org.usfirst.frc.team868.robot.OI;
import org.usfirst.frc.team868.robot.commands.Drive.Drive;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.FeedbackDevice;
import edu.wpi.first.wpilibj.command.Subsystem;

/** This class makes the robot drive.
 *
 */
public class DriveSubsystem extends Subsystem {

	private CANTalon rightMotor1;
	private CANTalon rightMotor2;
	private CANTalon leftMotor1;
	private CANTalon leftMotor2;
	
	private double leftPower, rightPower;

	public DriveSubsystem(CANTalon userRightMotor1, CANTalon userRightMotor2, CANTalon userLeftMotor1, CANTalon userLeftMotor2) {
		rightMotor1 = userRightMotor1;
		rightMotor2 = userRightMotor2;
		leftMotor1 = userLeftMotor1;
		leftMotor2 = userLeftMotor2;

		leftMotor1.changeControlMode(CANTalon.ControlMode.PercentVbus);
		leftMotor1.setFeedbackDevice(FeedbackDevice.QuadEncoder);
		leftMotor1.enableBrakeMode(false);

		leftMotor2.changeControlMode(CANTalon.ControlMode.Follower);
		leftMotor2.set(leftMotor1.getDeviceID());

		rightMotor1.changeControlMode(CANTalon.ControlMode.PercentVbus);
		rightMotor1.setFeedbackDevice(FeedbackDevice.QuadEncoder);
		rightMotor1.enableBrakeMode(false);
		rightMotor1.reverseOutput(true);

		rightMotor2.changeControlMode(CANTalon.ControlMode.Follower);
		rightMotor2.set(rightMotor1.getDeviceID());

		setDefaultCommand(new Drive(this));
	}

	public void driveWithGamepad() {
		double dir = OI.getRightXAxis();
		double power = -OI.getLeftYAxis();

		final double maxDelta = 0.075;

		double currLeftPower = leftMotor1.get();
		double currRightPower = rightMotor1.get();

		leftPower = power + dir;
		rightPower = power - dir;

		if (leftPower > 1)
			leftPower = 1;
		else if (leftPower < -1)
			leftPower = -1;
		else
			leftPower = (leftPower * leftPower * leftPower);

		if (rightPower > 1)
			rightPower = 1;
		else if (rightPower < -1)
			rightPower = -1;
		else
			rightPower = -(rightPower * rightPower * rightPower);

		leftPower = Math.min(leftPower, currLeftPower + maxDelta);
		leftPower = Math.max(leftPower, currLeftPower - maxDelta);

		rightPower = Math.min(rightPower, currRightPower + maxDelta);
		rightPower = Math.max(rightPower, currRightPower - maxDelta);

		leftMotor1.set(leftPower);
		rightMotor1.set(rightPower);
	}

	public void stopMotors() {
		leftMotor1.set(0);
		rightMotor1.set(0);
	}
	
	public double getLeftSpeed(){
		return leftMotor1.get();
	}
	
	public double getRightSpeed(){
		return rightMotor1.get();
	}
	
	public double getLeftPower(){
		return leftPower;
	}
	
	public double getRightPower(){
		return rightPower;
	}

	public void initDefaultCommand() {

	}
}
