/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

// Tells a spark to either go speed or -speed to intake or release a ball

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Command;

public class Intake extends Command {

  private Spark intake;

  public static final double SPEED = 0.5;

  public Intake() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    intake = new Spark(RobotMap.INTAKE);
  }

  public void collector() {
    intake.set(SPEED);
  }
  public void release() {
    intake.set(-SPEED);
  }
  public void stop() {
    intake.stopMotor();
    System.out.println("intake has stopped");
  }
  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
