package org.usfirst.frc.team868.robot.commands.Feeder;

import org.usfirst.frc.team868.robot.subsystems.FeederSubsystem;
import org.usfirst.frc.team868.robot.subsystems.RobotFactory;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class PullRight extends Command {

	private FeederSubsystem feeder;

	public PullRight() {
		feeder = RobotFactory.getInstance().getFeeder();
		requires(feeder);
	}

	protected void initialize() {
		feeder.inRightWheel();
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
