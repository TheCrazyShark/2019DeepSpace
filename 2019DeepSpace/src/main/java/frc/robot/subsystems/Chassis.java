/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

/* This subsystem needs to be able to tell four sparks which directions to turn
the motors so we can actually move and turn our robot */

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class Chassis extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  private Spark masterLeft;
  private Spark driveLeft;
  private Spark masterRight;
  private Spark driveRight;

  public Chassis() {
    masterLeft = new Spark(RobotMap.MASTER_DRIVE_LEFT_SPARK);
    driveLeft = new Spark(RobotMap.DRIVE_LEFT_SPARK);
    masterRight = new Spark(RobotMap.MASTER_DRIVE_RIGHT_SPARK);
    driveRight = new Spark(RobotMap.DRIVE_RIGHT_SPARK);

    //follows the "master controller"
    driveRight.follow(masterRight, FollowerType.PercentOutput);
    driveLeft.follow(masterLeft, FollowerType.PercentOutput);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());

    setdefaultCommand(new DriveByJoystick());
  }
  public Spark getLeftSpark(){
    return driveLeft;
  }
  public Spark getRightSpark(){
    return driveRight;
  }
  public void driveByJoystick(double yDir, double xDir) {
    SmartDashboard.putString("driveByJoystick?", yDir + "," xDir);
    drive.arcadeDrive(yDir, xDir);
  }
  public void driveForward(){
    driveLeft.set(speed); //figure out how to "push" control speed
    driveRight.set(speed);
  }
  public void driveBackward(){
    driveLeft.set(-speed); //figure out how to "push" control speed
    driveRight.set(-speed);
  }
  public void stop() {
    drive.stopMoter();
  }
}