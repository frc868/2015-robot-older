package org.usfirst.frc.team868.robot.commands.Elevator;

import org.usfirst.frc.team868.robot.subsystems.ElevatorSubsystem;
import org.usfirst.frc.team868.robot.subsystems.RobotFactory;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class StopElevator extends Command {
	
	private ElevatorSubsystem elevator;

    public StopElevator() {
    	elevator = RobotFactory.getInstance().getElevator();
    	requires(elevator);
    }

    protected void initialize() {
    	elevator.stop();
    }

    protected void execute() {
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
