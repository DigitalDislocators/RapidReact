package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Constants;
import frc.robot.subsystems.IndexerSys;
import frc.robot.subsystems.ShooterSys;
import frc.robot.subsystems.TurretSys;

public class AutoHighGoalShootSeq extends SequentialCommandGroup {

    public AutoHighGoalShootSeq(IndexerSys indexerSys, ShooterSys shooterSys, TurretSys turretSys) {
        super(
            new HighGoalShootCmd(shooterSys, turretSys),
            // new PrepareFeedCmd(indexerSys),
            new WaitCmd(Constants.Power.spinUpTime),
            new FeedShooterCmd(indexerSys),
            new WaitCmd(2),
            new StopIndexerCmd(indexerSys),
            new StopShooterCmd(shooterSys)
        );
    }
}
