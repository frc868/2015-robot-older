package org.usfirst.frc.team868.robot.commands.Elevator;

import org.usfirst.frc.team868.robot.subsystems.ElevatorSubsystem;
import org.usfirst.frc.team868.robot.subsystems.RobotFactory;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Up extends Command {
	
	private ElevatorSubsystem elevator;
	
	private boolean bool = false;

    public Up() {
    	elevator = RobotFactory.getInstance().getElevator();
    	requires(elevator);
    }

    protected void initialize() {
    	elevator.up();
    }

    protected void execute() {
    	if(elevator.isAtTop()) bool = true;
    }

    protected boolean isFinished() {
        return bool;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
