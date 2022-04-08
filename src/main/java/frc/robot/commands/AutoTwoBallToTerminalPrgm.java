package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.IndexerSys;
import frc.robot.subsystems.TurretSys;
import frc.robot.subsystems.PropulsionSys;
import frc.robot.subsystems.ShooterSys;

public class AutoTwoBallToTerminalPrgm extends SequentialCommandGroup {

    public AutoTwoBallToTerminalPrgm(PropulsionSys propulsionsys, IndexerSys indexerSys, ShooterSys shooterSys, TurretSys turretSys) {
        super(
            new TrackingOnCmd(turretSys),
            new LaunchpadShootCmd(shooterSys),
            new AutoTurnToHeadingCmd(7, 0.5, propulsionsys),
            new StartIntakeCmd(indexerSys),
            new AutoStraightHeadingCmd(3, 6, 7, 0.3, propulsionsys),
            new StopIndexerCmd(indexerSys),
            new AutoTurnToHeadingCmd(92, 0.5, propulsionsys),
            new TrackingOnCmd(turretSys),
            new AutoSetTurretAngleCmd(90, turretSys),
            new AutoHighGoalShootSeq(indexerSys, shooterSys, turretSys),
            new StopIndexerCmd(indexerSys),
            new StopShooterCmd(shooterSys),
            new StartIntakeCmd(indexerSys),
            new AutoStraightHeadingCmd(20, 0, 92, 0.6, propulsionsys),
            new StopIndexerCmd(indexerSys),
            new StopShooterCmd(shooterSys),
            new AutoSetTurretAngleCmd(0, turretSys)
        );
    }
}
