package org.usfirst.frc.team868.robot;

import org.usfirst.frc.team868.robot.commands.CanGrabber.GrabCan;
import org.usfirst.frc.team868.robot.commands.CanGrabber.ReleaseCan;
import org.usfirst.frc.team868.robot.commands.Feeder.BringToteIn;
import org.usfirst.frc.team868.robot.commands.Feeder.FeederIn;
import org.usfirst.frc.team868.robot.commands.Feeder.FeederOut;
import org.usfirst.frc.team868.robot.commands.Feeder.PushToteOut;
import org.usfirst.frc.team868.robot.commands.Feeder.ToggleFeeder;
import org.usfirst.frc.team868.robot.commands.Feeder.ToggleWheels;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	// // CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	Joystick operator = new Joystick(0);

	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	// // TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());

	private void setUpSmartDashboard() {
		SmartDashboard.putData("Grab Can", new GrabCan());
		SmartDashboard.putData("Release Can", new ReleaseCan());

		SmartDashboard.putData("Put Feeder Arms In", new FeederIn());
		SmartDashboard.putData("Put Feeder Arms Out", new FeederOut());
		SmartDashboard.putData("Bring Tote In", new BringToteIn());
		SmartDashboard.putData("Push Tote Out", new PushToteOut());
	}

	private void setUpOperator() {
		Button button1 = new JoystickButton(operator, 1);
		button1.whenPressed(new ToggleFeeder());

		Button button2 = new JoystickButton(operator, 2);
		button2.whenPressed(new ToggleWheels());
	}

	public void initialize() {
		setUpSmartDashboard();
		setUpOperator();
	}
}
