// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;
import com.kauailabs.navx.frc.*;

public class DriveStraight extends CommandBase {
  DriveSubsystem drive;
  double speed;
  double gyroOff;
  double gyroError;

  double speedL;
  double speedR;

  AHRS gyro;



  /** Creates a new DriveStraight. */
  public DriveStraight(DriveSubsystem driveSubsystem, double driveSpeed) {
    drive = driveSubsystem;
    speed = driveSpeed;
    gyro = driveSubsystem.gyro;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(driveSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    gyroOff = gyro.getYaw();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    // Angle Error to add offset speed 🙏
    gyroError = (gyro.getYaw() - gyroOff) / 20;
    drive.arcadeDrive(speed, -gyroError);
  }
  
  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {drive.tankDrive(0, 0);}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
