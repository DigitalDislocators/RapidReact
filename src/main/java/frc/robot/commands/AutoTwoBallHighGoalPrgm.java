package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.IndexerSys;
import frc.robot.subsystems.TurretSys;
import frc.robot.subsystems.PropulsionSys;
import frc.robot.subsystems.ShooterSys;

public class AutoTwoBallHighGoalPrgm extends SequentialCommandGroup {

    public AutoTwoBallHighGoalPrgm(PropulsionSys propulsionsys, IndexerSys indexerSys, ShooterSys shooterSys, TurretSys turretSys) {
        super(
            new TrackingOffCmd(turretSys),
            new StartIntakeCmd(indexerSys),
            new AutoStraightHeadingCmd(4, 0, 0.3, propulsionsys),
            new StopIndexerCmd(indexerSys),
            new AutoTurnCmd(-90, 0.5, propulsionsys).alongWith(new AutoSetTurretAngleCmd(-90, turretSys)),
            new AutoHighGoalShootSeq(indexerSys, shooterSys, turretSys),
            new StopIndexerCmd(indexerSys),
            new StopShooterCmd(shooterSys)
        );
    }
}
