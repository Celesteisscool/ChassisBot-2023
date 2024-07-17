package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.AutoDrive;
import frc.robot.commands.DriveStraight;
import frc.robot.subsystems.DriveSubsystem;

public class Auto extends SequentialCommandGroup {
  public Auto(DriveSubsystem driveSubsystem) {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    
    addCommands(
      new DriveStraight(driveSubsystem, 0.3).withTimeout(2),
      new AutoDrive(driveSubsystem, 0.25, 0.3, 0, -90),
      new AutoDrive(driveSubsystem, 0.25, 0.3, 0, -90),
      new AutoDrive(driveSubsystem, 0, 0, 1, 0)
    );
  }
}
