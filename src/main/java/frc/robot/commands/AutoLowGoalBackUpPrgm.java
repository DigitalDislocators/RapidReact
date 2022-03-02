package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.IndexerSys;
import frc.robot.subsystems.PropulsionSys;
import frc.robot.subsystems.ShooterSys;

public class AutoLowGoalBackUpPrgm extends SequentialCommandGroup {

    public AutoLowGoalBackUpPrgm(PropulsionSys propulsionsys, IndexerSys indexerSys, ShooterSys shooterSys) {
        super(
            new AutoLowGoalDump(shooterSys, indexerSys),
            new AutoStraightHeadingCmd(-10, 0, 0.5, propulsionsys)
        );
    }
}
