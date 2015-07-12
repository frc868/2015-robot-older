package org.usfirst.frc.team868.robot.commands.Drive;

import org.usfirst.frc.team868.robot.subsystems.DriveSubsystem;
import org.usfirst.frc.team868.robot.subsystems.RobotFactory;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Drive extends Command {

	private DriveSubsystem drive;

	public Drive() {
		drive = RobotFactory.getInstance().getDrive();
		requires(drive);
	}
	
	public Drive(DriveSubsystem userDrive){
		drive = userDrive;
		requires(userDrive);
	}

	protected void initialize() {
	}

	protected void execute() {
		drive.driveWithGamepad();
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
	}

	protected void interrupted() {
	}
}
