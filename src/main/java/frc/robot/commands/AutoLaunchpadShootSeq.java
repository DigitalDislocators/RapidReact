package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Constants;
import frc.robot.subsystems.IndexerSys;
import frc.robot.subsystems.ShooterSys;

public class AutoLaunchpadShootSeq extends SequentialCommandGroup {

    public AutoLaunchpadShootSeq(IndexerSys indexerSys, ShooterSys shooterSys) {
        super(
            new LaunchpadShootCmd(shooterSys),
            new PrepareFeedCmd(indexerSys),
            new WaitCmd(Constants.Power.spinUpTime),
            new FeedShooterCmd(indexerSys)
        );
    }
}
