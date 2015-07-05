package org.usfirst.frc.team868.robot.commands.CanGrabber;

import org.usfirst.frc.team868.robot.subsystems.CanGrabberSubsystem;
import org.usfirst.frc.team868.robot.subsystems.RobotFactory;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ReleaseCan extends Command {

	private CanGrabberSubsystem canGrabber;

	public ReleaseCan() {
		canGrabber = RobotFactory.getInstance().getCanGrabber();
		requires(canGrabber);
	}

	protected void initialize() {
		canGrabber.open();
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