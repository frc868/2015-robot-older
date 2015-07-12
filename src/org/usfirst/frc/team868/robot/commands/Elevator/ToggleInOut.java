package org.usfirst.frc.team868.robot.commands.Elevator;

import org.usfirst.frc.team868.robot.subsystems.ElevatorSubsystem;
import org.usfirst.frc.team868.robot.subsystems.RobotFactory;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ToggleInOut extends Command {

	private ElevatorSubsystem elevator;

	public ToggleInOut() {
		elevator = RobotFactory.getInstance().getElevator();
		requires(elevator);
	}

	protected void initialize() {
		if (elevator.isIn())
			elevator.out();
		else
			elevator.in();
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
