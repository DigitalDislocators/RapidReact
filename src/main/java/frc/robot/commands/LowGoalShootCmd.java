// RobotBuilder Version: 4.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

// ROBOTBUILDER TYPE: Command.

package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.IndexerSys;
// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import frc.robot.subsystems.ShooterSys;

// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS


public class LowGoalShootCmd extends CommandBase {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS
    private final IndexerSys m_indexerSys;
    private final ShooterSys m_shooterSys;
 
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS

    /**
     * Constructs a new LowGoalShootCmd.
     * 
     * <p>LowGoalShootCmd runs the shooter at the power set to shoot into the low goal.
     * 
     * <p>The command finishes once it is run.
     * 
     * @param subsystem The required ShooterSys
     */

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS

    public LowGoalShootCmd(IndexerSys subsystem1, ShooterSys subsystem2) {

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING

        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES

        m_indexerSys = subsystem1;
        m_shooterSys = subsystem2;
        addRequirements(m_shooterSys);

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        // m_turretSys.setTrackingEnabled(false);
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        m_indexerSys.lowGoalDump();
        m_shooterSys.set(Constants.Power.lowGoal);
    }

    
    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        // m_turretSys.setTrackingEnabled(before);
    }

    
    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return true;
    }

    
    @Override
    public boolean runsWhenDisabled() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DISABLED
        return false;

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DISABLED
    }
}
