package frc.robot;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.AutoDrive;
import frc.robot.subsystems.DriveSubsystem;

public class Auto extends SequentialCommandGroup {
  public Auto(DriveSubsystem driveSubsystem) {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    int sides = 4;

    for (int i = 1; i <= sides; i++) {
      addCommands(new AutoDrive(driveSubsystem, 0, 0.25, 0, 360/sides));
      addCommands(new AutoDrive(driveSubsystem, 0.25, 0, 1, 0));
    }
  }
}
