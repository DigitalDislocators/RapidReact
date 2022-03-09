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
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.IndexerSys;
// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import frc.robot.subsystems.ShooterSys;

// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS


public class AutoLowGoalDump extends CommandBase {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS
    private final ShooterSys m_shooterSys;
    private final IndexerSys m_indexerSys;
    
    private Timer m_timer;
 
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

    public AutoLowGoalDump(ShooterSys subsystem1, IndexerSys subsystem2) {

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING

        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES

        m_shooterSys = subsystem1;
        m_indexerSys = subsystem2;

        addRequirements(m_shooterSys);
        addRequirements(m_indexerSys);

        m_timer = new Timer();

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        m_timer.start();
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        m_shooterSys.set(Constants.Power.lowGoal);
        m_indexerSys.set(Constants.Power.feed);
    }

    
    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        m_shooterSys.stop();
        m_indexerSys.stop();
    }

    
    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        if(m_timer.hasElapsed(1.5)) {
            return true;
        }
        else {
            return false;
        }
    }

    
    @Override
    public boolean runsWhenDisabled() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DISABLED
        return false;

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DISABLED
    }
}
