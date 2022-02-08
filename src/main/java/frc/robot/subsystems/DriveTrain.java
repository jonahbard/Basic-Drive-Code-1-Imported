// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.Constants;

public class DriveTrain extends SubsystemBase {
  /** Creates a new DriveTrain. */
  Spark left;
  Spark right;
  MotorControllerGroup leftMotors;
  MotorControllerGroup rightMotors;
  DifferentialDrive drive;

  public DriveTrain() {
    left = new Spark(Constants.LEFT);
    //right.setInverted(false);
    right = new Spark(Constants.RIGHT);
    //right.setInverted(false);

    leftMotors = new MotorControllerGroup(left);
    rightMotors = new MotorControllerGroup(right);

    drive = new DifferentialDrive(leftMotors, rightMotors);
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }


  public void driveWithJoysticks(XboxController controller, double speed){
    drive.arcadeDrive(controller.getRawAxis(Constants.XBOX_LEFT_Y)*speed, controller.getRawAxis(Constants.XBOX_LEFT_X)*speed);
  }

  public void driveForward(double speed){
    drive.tankDrive(speed, speed);
  }

  public void stop(){
    drive.stopMotor();
  }
}
