// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;

public class AutoDrive extends CommandBase {
  DriveSubsystem drive;
  double x;
  double rot;
  double time;
  double angle;
  Timer timer = new Timer();
  AHRS gyro;
  double gyroOff;
  Boolean finished;

  

  /** Creates a new AutoDrive. */
  public AutoDrive(DriveSubsystem driveSubsystem, double driveX, double driveRot, double driveTime, double driveAngle) {
    // Use addRequirements() here to declare subsystem dependencies.
    drive = driveSubsystem;
    rot = driveX;
    x = driveRot;
    time = driveTime;
    angle = driveAngle;
    finished = false;

    gyro = driveSubsystem.gyro;

    addRequirements(driveSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    timer.restart();
    gyro.reset();
    drive.arcadeDrive(0, 0);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    drive.arcadeDrive(x, rot);
    if (angle == 0 && timer.get() > time) {
        end(false);
      }
    else if (Math.abs(gyro.getYaw()) >= Math.abs(angle)) {
      end(false);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    finished = true;
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return finished;
  }
}
