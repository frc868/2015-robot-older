package org.usfirst.frc.team868.robot.commands.Feeder;

import org.usfirst.frc.team868.robot.subsystems.FeederSubsystem;
import org.usfirst.frc.team868.robot.subsystems.RobotFactory;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class PushRight extends Command {

	private FeederSubsystem feeder;

	public PushRight() {
		feeder = RobotFactory.getInstance().getFeeder();
		requires(feeder);
	}

	protected void initialize() {
		feeder.outRightWheel();
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
