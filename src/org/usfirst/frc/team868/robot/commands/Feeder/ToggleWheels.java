package org.usfirst.frc.team868.robot.commands.Feeder;

import org.usfirst.frc.team868.robot.subsystems.FeederSubsystem;
import org.usfirst.frc.team868.robot.subsystems.RobotFactory;

import edu.wpi.first.wpilibj.command.Command;

/**
 * 7 is left trigger 8 is right trigger
 */
public class ToggleWheels extends Command {

	private FeederSubsystem feeder;

	private boolean bool = false;

	public ToggleWheels() {
		feeder = RobotFactory.getInstance().getFeeder();
		requires(feeder);
	}

	protected void initialize() {
		if (feeder.isSpinning())
			feeder.stopMotors();
		else
			feeder.pullBothMotors();
	}

	protected void execute() {

	}

	protected boolean isFinished() {
		return bool;
	}

	protected void end() {

	}

	protected void interrupted() {

	}
}
