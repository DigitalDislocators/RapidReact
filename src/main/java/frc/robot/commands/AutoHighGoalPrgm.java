package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.IndexerSys;
import frc.robot.subsystems.LimelightSys;
import frc.robot.subsystems.PropulsionSys;
import frc.robot.subsystems.ShooterSys;

public class AutoHighGoalPrgm extends SequentialCommandGroup {

    public AutoHighGoalPrgm(PropulsionSys propulsionsys, IndexerSys indexerSys, ShooterSys shooterSys, LimelightSys limelightSys) {
        super(
            new StartIntakeCmd(indexerSys),
            new AutoStraightHeadingCmd(4, 0, 0.3, propulsionsys),
            new StopIndexerCmd(indexerSys),
            new AutoTurnCmd(180, 0.5, propulsionsys),
            new AutoAimCmd(0.3, limelightSys, propulsionsys),
            new AutoLaunchpadShootSeq(indexerSys, shooterSys),
            new WaitCmd(2),
            new StopIndexerCmd(indexerSys),
            new StopShooterCmd(shooterSys)
        );
    }
}