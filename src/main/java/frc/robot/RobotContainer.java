package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.subsystems.Hood;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.Storage;


public class RobotContainer {
  Hood hood = new Hood();
  Shooter shooter = new Shooter();
  Storage storage = new Storage();
  XboxController operator = new XboxController(0);
  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    JoystickButton hoodTest = new JoystickButton(operator, 1);
    hoodTest.whileHeld(new RunCommand(()->hood.hoodTest(), hood));
    hoodTest.whenReleased(new RunCommand(()->hood.stop(), hood));

    JoystickButton hoodTestUp = new JoystickButton(operator, 4);
    hoodTestUp.whileHeld(new RunCommand(()->hood.hoodTestUp(), hood));
    hoodTestUp.whenReleased(new RunCommand(()->hood.stop(), hood));

    JoystickButton shooterTest = new JoystickButton(operator, 2);
    shooterTest.whileHeld(new RunCommand(()->shooter.shootBall(), shooter));
    shooterTest.whenReleased(new RunCommand(()->shooter.stop(), shooter));

    JoystickButton storageTest = new JoystickButton(operator, 3);
    storageTest.whileHeld(new RunCommand(()->storage.storageForward(), storage));
    storageTest.whenReleased(new RunCommand(()->storage.stop()));
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return null;
  }
}