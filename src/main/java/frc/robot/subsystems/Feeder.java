package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

// you can set one motor controller per side to brake mode and the other to coast mode for something in 
// between having no braking force and having maximum braking force diyor chief delphide öbür türlü aniden durunca problem olabiliyormuş
// https://www.chiefdelphi.com/t/what-is-brake-coast-mode/163649/10

private class Feeder extends Subsystembase {
  /** Creates a new Feeder. */

  public WPI_TalonSRX feeder = new WPI_TalonSRX(3);

  public Feeder(boolean isInverted) {
    feeder.setInverted(isInverted);
    feeder.setNeutralMode(NeutralMode.Brake);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void runForward(){
    feeder.set(ControlMode.PercentOutput, 0.6);
  }
  public void runBackwards(){
    feeder.set(ControlMode.PercentOutput, -0.6);
  }
  public void stop(){
    feeder.set(ControlMode.PercentOutput, 0.0);
  }
}
