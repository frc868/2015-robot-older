package org.usfirst.frc.team868.robot.subsystems;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.CANTalon.FeedbackDevice;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ElevatorSubsystem extends Subsystem {
	
	private CANTalon motor1, motor2;
	private Solenoid sol;
	
	public ElevatorSubsystem(CANTalon userMotor1, CANTalon userMotor2, Solenoid userSol){
		motor1 = userMotor1;
		motor2 = userMotor2;
		sol = userSol;
		
		motor1.changeControlMode(CANTalon.ControlMode.PercentVbus);
		motor1.setFeedbackDevice(FeedbackDevice.QuadEncoder);
		motor1.enableBrakeMode(true);
		motor1.reverseSensor(true);
		motor1.enableLimitSwitch(true, true);
		
		motor2.changeControlMode(CANTalon.ControlMode.Follower);
		motor2.set(motor1.getDeviceID());
	}
	
	public void in(){
		sol.set(true);
	}
	
	public void out(){
		sol.set(false);
	}
	
	public void up(){
		motor1.set(-0.5);
	}
	
	public void down(){
		motor1.set(0.5);
	}
	
	public void stop(){
		motor1.set(0);
	}
	
	public boolean isAtTop(){
		return motor1.isRevLimitSwitchClosed();
	}
	
	public boolean isAtBottom(){
		return motor1.isFwdLimitSwitchClosed();
	}
	
	public boolean isIn(){
		return sol.get();
	}
	
	public double getEncDistance(){
		return motor1.getEncPosition();
	}
        
    public void initDefaultCommand() {
       
    }
}

