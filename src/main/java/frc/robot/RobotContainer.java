// RobotBuilder Version: 4.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

// ROBOTBUILDER TYPE: RobotContainer.

package frc.robot;

// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.POVButton;
import frc.robot.subsystems.*;
import oi.limelightvision.limelight.frc.Limelight;
import oi.limelightvision.limelight.frc.ControlMode.StreamType;
import frc.robot.commands.*;

// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  private boolean m_partyModeToggle = false;
  private static byte m_winchCombo = 0;

  private static RobotContainer m_robotContainer = new RobotContainer();

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    // The robot's subsystems
    public final ShooterSys m_shooterSys = new ShooterSys();
    public final LightsSys m_lightsSys = new LightsSys();
    public final IndexerSys m_indexerSys = new IndexerSys(m_lightsSys);
    public final ClimberSys m_climberSys = new ClimberSys();
    public final PropulsionSys m_propulsionSys = new PropulsionSys();
    public final LimelightSys m_limelightSys = new LimelightSys();

    // Joysticks
    private final Joystick m_driverRightJoystick = new Joystick(1);
    private final Joystick m_driverLeftJoystick = new Joystick(0);
    private final Joystick m_operatorController = new  Joystick(2);

    // Buttons
    private final JoystickButton m_driverRightTrigger = new JoystickButton(m_driverRightJoystick, 1);
    private final JoystickButton m_driverRight3 = new JoystickButton(m_driverRightJoystick, 3);
    private final JoystickButton m_driverRight5 = new JoystickButton(m_driverRightJoystick, 5);
    private final JoystickButton m_driverRight11 = new JoystickButton(m_driverRightJoystick, 11);

    private final JoystickButton m_operatorAButton = new JoystickButton(m_operatorController, 1);
    private final JoystickButton m_operatorYButton = new JoystickButton(m_operatorController, 4);
    private final POVButton m_operatorDPadUp = new POVButton(m_operatorController, 0);
    private final POVButton m_operatorDPadDown = new POVButton(m_operatorController, 180);
    private final JoystickButton m_operatorLeftBumper = new JoystickButton(m_operatorController, 5);
    private final JoystickButton m_operatorRightBumper = new JoystickButton(m_operatorController, 6);

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
  
    // A chooser for autonomous commands
    SendableChooser<Command> m_chooser = new SendableChooser<>();

  /**
  * The container for the robot.  Contains subsystems, OI devices, and commands.
  */
  private RobotContainer() {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=SMARTDASHBOARD

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=SMARTDASHBOARD

    // Configure the button bindings
    driverBindingsLogan();
    operatorBindingsBodi();

    // Configure default commands
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=SUBSYSTEM_DEFAULT_COMMAND


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=SUBSYSTEM_DEFAULT_COMMAND

    // Configure autonomous sendable chooser
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS

    // m_chooser.setDefaultOption("Autonomous Command", new AutonomousCommand());
    // m_chooser.addOption("Autonomous Command 2", new AutonomousCommand());

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS

    // SmartDashboard.putData("Auto Mode", m_chooser);
  }

  public static RobotContainer getInstance() {
    return m_robotContainer;
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void driverBindingsLogan() {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=BUTTONS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=BUTTONS

    m_driverRightTrigger.whileHeld(new StartIntakeCmd(m_indexerSys)).whenReleased(new StopIndexerCmd(m_indexerSys));
    m_driverRight3.whileHeld(new LaunchpadShootRoutineCmd(m_shooterSys, m_indexerSys)).whenReleased(new StopShooterCmd(m_shooterSys)).whenReleased(new StopIndexerCmd(m_indexerSys));
    m_driverRight5.whileHeld(new LowGoalShootCmd(m_shooterSys)).whileHeld(new FeedShooterCmd(m_indexerSys)).whenReleased(new StopShooterCmd(m_shooterSys)).whenReleased(new StopIndexerCmd(m_indexerSys));
    m_driverRight11.whenPressed(new RunCommand(() -> m_partyModeToggle = !m_partyModeToggle));

    m_propulsionSys.setDefaultCommand(new RunCommand(
      () -> m_propulsionSys.mecanumDriveControlNonlinear(m_driverLeftJoystick.getX(), -m_driverLeftJoystick.getY(), m_driverRightJoystick.getX(), m_driverRightJoystick.getZ(), false),
      m_propulsionSys)
    );
    m_lightsSys.setDefaultCommand(new RunCommand(
      () -> m_lightsSys.setPartyMode(m_partyModeToggle), m_lightsSys));
  }

  private void operatorBindingsBodi() {
    m_operatorAButton.whileHeld(new LowGoalShootCmd(m_shooterSys)).whenReleased(new StopShooterCmd(m_shooterSys));
    m_operatorYButton.whileHeld(new LaunchpadShootCmd(m_shooterSys)).whenReleased(new StopShooterCmd(m_shooterSys));
    m_operatorDPadUp.whileHeld(new HookUpCmd(m_climberSys)).whenReleased(new HookStopCmd(m_climberSys));
    m_operatorDPadDown.whileHeld(new HookDownCmd(m_climberSys)).whenReleased(new HookStopCmd(m_climberSys));
    m_operatorLeftBumper.whenPressed(new RunCommand(() -> m_winchCombo++)).whenReleased(new RunCommand(() -> m_winchCombo--));
    m_operatorRightBumper.whenPressed(new RunCommand(() -> m_winchCombo++)).whenReleased(new RunCommand(() -> m_winchCombo--));

    m_indexerSys.setDefaultCommand(new RunCommand(
      () -> m_indexerSys.set(m_operatorController.getY()),
      m_indexerSys)
    );
  }

  // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
  public Joystick getLeftJoystick() {
      return m_driverLeftJoystick;
  }

  public Joystick getRightJoystick() {
      return m_driverRightJoystick;
  }

  // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS

  public static byte getWinchCombo() {
    return m_winchCombo;
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
  */
  public Command getAutonomousCommand() {
    // The selected command will be run in autonomous
    // return m_chooser.getSelected();
    return new AutoStraightHeadingCmd(10, 0, 0.5, m_propulsionSys);
  }
}

