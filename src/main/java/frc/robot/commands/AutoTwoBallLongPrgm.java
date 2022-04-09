package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.IndexerSys;
import frc.robot.subsystems.TurretSys;
import frc.robot.subsystems.PropulsionSys;
import frc.robot.subsystems.ShooterSys;

public class AutoTwoBallLongPrgm extends SequentialCommandGroup {

    public AutoTwoBallLongPrgm(PropulsionSys propulsionsys, IndexerSys indexerSys, ShooterSys shooterSys, TurretSys turretSys) {
        super(
            new TrackingOffCmd(turretSys),
            new LaunchpadShootCmd(shooterSys),
            new StartIntakeCmd(indexerSys),
            new AutoStraightHeadingCmd(6, 6, 0, 0.3, propulsionsys),
            new StopIndexerCmd(indexerSys),
            new TrackingOnCmd(turretSys),
            new AutoTurnToHeadingCmd(90, 0.5, propulsionsys).alongWith(new AutoSetTurretAngleCmd(90, turretSys)),
            new WaitCmd(1.0),
            new AutoHighGoalShootSeq(indexerSys, shooterSys, turretSys),
            new StopIndexerCmd(indexerSys),
            new StopShooterCmd(shooterSys)
        );
    }
}
