package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.IndexerSys;
import frc.robot.subsystems.TurretSys;
import frc.robot.subsystems.PropulsionSys;
import frc.robot.subsystems.ShooterSys;

public class AutoFourBallPrgm extends SequentialCommandGroup {

    public AutoFourBallPrgm(PropulsionSys propulsionsys, IndexerSys indexerSys, ShooterSys shooterSys, TurretSys turretSys) {
        super(
            new StartIntakeCmd(indexerSys),
            new LaunchpadShootCmd(shooterSys),
            new TrackingOnCmd(turretSys),
            new AutoStraightHeadingCmd(6, 6, 0, 0.45, propulsionsys).alongWith(new AutoSetTurretAngleCmd(165, turretSys)),
            new StopIndexerCmd(indexerSys),
            new StopIndexerCmd(indexerSys),
            new AutoHighGoalShootSeq(indexerSys, shooterSys, turretSys),
            new TrackingOffCmd(turretSys),
            new StartIntakeCmd(indexerSys),
            new AutoStraightHeadingCmd(11, 0, 0, 0.65, propulsionsys),
            new WaitCmd(1.5),
            new StopIndexerCmd(indexerSys),
            new TrackingOnCmd(turretSys),
            new AutoStraightHeadingCmd(-6, 0, 0, 0.75, propulsionsys).alongWith(new AutoSetTurretAngleCmd(165, turretSys)),
            new AutoHighGoalShootSeq(indexerSys, shooterSys, turretSys),
            new TrackingOffCmd(turretSys),
            new StopIndexerCmd(indexerSys),
            new StopShooterCmd(shooterSys),
            new AutoSetTurretAngleCmd(0, turretSys)
        );
    }
}
