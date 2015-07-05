package org.usfirst.frc.team868.robot.commands.Feeder;

import org.usfirst.frc.team868.robot.subsystems.FeederSubsystem;
import org.usfirst.frc.team868.robot.subsystems.RobotFactory;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class PushToteOut extends Command {

	private FeederSubsystem feeder;

	private boolean bool = false;

	public PushToteOut() {
		feeder = RobotFactory.getInstance().getFeeder();
		requires(feeder);
	}

	protected void initialize() {
		feeder.pushBothMotors();
	}

	protected void execute() {
		bool = !feeder.isToteIn();
	}

	protected boolean isFinished() {
		return bool;
	}

	protected void end() {
		feeder.stopMotors();
	}

	protected void interrupted() {

	}
}
