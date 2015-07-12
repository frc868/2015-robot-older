package org.usfirst.frc.team868.robot;

import org.usfirst.frc.team868.robot.commands.CanGrabber.GrabCan;
import org.usfirst.frc.team868.robot.commands.CanGrabber.ReleaseCan;
import org.usfirst.frc.team868.robot.commands.Elevator.Down;
import org.usfirst.frc.team868.robot.commands.Elevator.StopElevator;
import org.usfirst.frc.team868.robot.commands.Elevator.ToggleInOut;
import org.usfirst.frc.team868.robot.commands.Elevator.Up;
import org.usfirst.frc.team868.robot.commands.Feeder.BringToteIn;
import org.usfirst.frc.team868.robot.commands.Feeder.PullLeft;
import org.usfirst.frc.team868.robot.commands.Feeder.PullRight;
import org.usfirst.frc.team868.robot.commands.Feeder.PushLeft;
import org.usfirst.frc.team868.robot.commands.Feeder.PushRight;
import org.usfirst.frc.team868.robot.commands.Feeder.PushToteOut;
import org.usfirst.frc.team868.robot.commands.Feeder.StopLeft;
import org.usfirst.frc.team868.robot.commands.Feeder.StopRight;
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

	static Joystick driver = new Joystick(0);

	// static Joystick operator = new Joystick(1);

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
		// SmartDashboard.putData("Grab Can", new GrabCan());
		// SmartDashboard.putData("Release Can", new ReleaseCan());

		// SmartDashboard.putData("Bring Tote In", new BringToteIn());
		// SmartDashboard.putData("Push Tote Out", new PushToteOut());
	}

	private void setUpDriver() {
		Button button1 = new JoystickButton(driver, 1);
		button1.whenPressed(new ToggleInOut());

		Button button2 = new JoystickButton(driver, 2);
		button2.whenPressed(new Down());
		button2.whenReleased(new StopElevator());

		Button button3 = new JoystickButton(driver, 3);
		button3.whenPressed(new ToggleInOut());

		Button button4 = new JoystickButton(driver, 4);
		button4.whenPressed(new Up());
		button4.whenReleased(new StopElevator());

		Button button5 = new JoystickButton(driver, 5);
		button5.whenPressed(new PullLeft());
		button5.whenReleased(new StopLeft());

		Button button6 = new JoystickButton(driver, 6);
		button6.whenPressed(new PullRight());
		button6.whenReleased(new StopRight());

		Button button7 = new JoystickButton(driver, 7);
		button7.whenPressed(new PushLeft());
		button7.whenReleased(new StopLeft());

		Button button8 = new JoystickButton(driver, 8);
		button8.whenPressed(new PushRight());
		button8.whenReleased(new StopRight());
	}

	public void initialize() {
		setUpSmartDashboard();
		setUpDriver();
	}

	public static double getLeftXAxis() {
		return driver.getRawAxis(0);
	}

	public static double getLeftYAxis() {
		return driver.getRawAxis(1);
	}

	public static double getRightXAxis() {
		return driver.getRawAxis(2);
	}

	public static double getRightYAxis() {
		return driver.getRawAxis(3);
	}
}
