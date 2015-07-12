package org.usfirst.frc.team868.robot.commands.Drive;

import org.usfirst.frc.team868.robot.subsystems.DriveSubsystem;
import org.usfirst.frc.team868.robot.subsystems.RobotFactory;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Stop extends Command {

	private DriveSubsystem drive;

	public Stop() {
		drive = RobotFactory.getInstance().getDrive();
		requires(drive);
	}

	protected void initialize() {
		drive.stopMotors();
	}

	protected void execute() {
	}

	protected boolean isFinished() {
		return true;
	}

	protected void end() {
	}

	protected void interrupted() {
	}
}
