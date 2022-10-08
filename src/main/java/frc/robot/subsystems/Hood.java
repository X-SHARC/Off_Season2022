// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.TalonFXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Hood extends SubsystemBase {

  //!Device Number Will be set
  //!Add gearbox calc to the angle calc

  TalonFX hoodMotor = new TalonFX(7);
  DigitalInput topSwitch = new DigitalInput(0);
  DigitalInput bottomSwitch = new DigitalInput(1);

  private double kP,kI,kD = 0.0;

  PIDController hoodPID = new PIDController(kP, kI, kD);

  public double angle;
  //!Measure the max value and enter
  double angleMax = 60;



  /** Creates a new Hood. */
  public Hood() {}

  public double getCurrentAngle(){
    //!ADD GEARBOX RATIO
    angle = hoodMotor.getSelectedSensorPosition() / 4096.0;
    angle*=360;
    return angle;
  }

  public void stop(){
    hoodMotor.set(TalonFXControlMode.PercentOutput,0.0);
  }

  public void resetAngle(){
    //! Measure the Bottom position of the angle and enter the value
    angle = 0.0;
  }

  public void setHoodAngle(double setpointAngle){
    double pidOutput = hoodPID.calculate(getCurrentAngle(), setpointAngle);
    hoodMotor.set(TalonFXControlMode.PercentOutput, pidOutput);
  }

  public void hoodTest(){
    hoodMotor.set(TalonFXControlMode.PercentOutput,0.1);
  }


  
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("Current Hood Angle", getCurrentAngle());
    SmartDashboard.putBoolean("Top Switch Value", topSwitch.get());
    SmartDashboard.putBoolean("Bottom Switch Value", bottomSwitch.get());

    if(bottomSwitch.get()){
      resetAngle();
      stop();
    }
    if(topSwitch.get()){
      angle = angleMax;
      stop();
    }
  }



}
