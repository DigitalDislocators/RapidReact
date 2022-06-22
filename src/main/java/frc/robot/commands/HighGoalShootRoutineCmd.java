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
import frc.robot.subsystems.IndexerSys;
// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import frc.robot.subsystems.ShooterSys;
import frc.robot.subsystems.TurretSys;

// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS


public class HighGoalShootRoutineCmd extends CommandBase {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS
    private final ShooterSys m_shooterSys;
    private final IndexerSys m_indexerSys;
    private final TurretSys m_turretSys;

    private final Timer m_timer;
 
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS

    /**
     * Constructs a new LaunchpadShootCmd.
     * 
     * <p>LaunchpadShootCmd runs the shooter at the power set to shoot from the launchpad.
     * 
     * <p>The command finishes once it is run.
     * 
     * @param subsystem The required ShooterSys
     */

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS

    public HighGoalShootRoutineCmd(ShooterSys subsystem1, IndexerSys subsystem2, TurretSys subsystem3) {


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING

        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES

        m_shooterSys = subsystem1;
        m_indexerSys = subsystem2;
        m_turretSys = subsystem3;

        m_timer = new Timer();

        addRequirements(m_shooterSys, m_indexerSys, m_turretSys);

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {

    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        m_turretSys.highGoalPower();
        if(m_shooterSys.isAtSpeed()) {
            m_indexerSys.feed();
        }
        else {
            m_indexerSys.prepareFeed();
        }
    }

    
    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {

    }

    
    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return m_shooterSys.isAtSpeed();
    }

    
    @Override
    public boolean runsWhenDisabled() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DISABLED
        return false;

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DISABLED
    }
}
