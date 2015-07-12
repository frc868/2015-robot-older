package org.usfirst.frc.team868.robot.commands.Elevator;

import org.usfirst.frc.team868.robot.subsystems.ElevatorSubsystem;
import org.usfirst.frc.team868.robot.subsystems.RobotFactory;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Down extends Command {
	
	private ElevatorSubsystem elevator;
	
	private boolean bool = false;

    public Down() {
    	elevator = RobotFactory.getInstance().getElevator();
    	requires(elevator);
    }

    protected void initialize() {
    	elevator.down();
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
