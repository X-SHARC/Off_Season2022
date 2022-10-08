package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import com.ctre.phoenix.motorcontrol.ControlMode;

public class Storage extends SubsystemBase {
  /** Creates a new Storage. */
  public WPI_TalonSRX storage = new WPI_TalonSRX(2);
  public Storage() {
    storage.setInverted(false);
  }

  public void storageForward(){
    storage.set(ControlMode.PercentOutput, 0.5);
  }

  public void storageBackwards(){
    storage.set(ControlMode.PercentOutput, -1 * 0.5);
  }

  public void stop(){
    storage.set(0.0);
  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
