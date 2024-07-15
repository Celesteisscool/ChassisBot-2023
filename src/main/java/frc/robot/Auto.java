package frc.robot;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.AutoDrive;
import frc.robot.subsystems.DriveSubsystem;

public class Auto extends SequentialCommandGroup {
  public Auto(DriveSubsystem driveSubsystem) {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    
    addCommands(
      new AutoDrive(driveSubsystem, 0.25, -0.02, 11.5, 0),
      new AutoDrive(driveSubsystem, -0.25, 0.02, 11.5, 0)
    );
  }
}
