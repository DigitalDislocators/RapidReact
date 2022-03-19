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
import edu.wpi.first.wpilibj2.command.RamseteCommand;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import java.util.List;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.controller.RamseteController;
import edu.wpi.first.math.controller.SimpleMotorFeedforward;
import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.trajectory.Trajectory;
import edu.wpi.first.math.trajectory.TrajectoryConfig;
import edu.wpi.first.math.trajectory.TrajectoryGenerator;
import edu.wpi.first.math.trajectory.constraint.DifferentialDriveKinematicsConstraint;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.RumbleType;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.subsystems.*;
import frc.robot.commands.*;

// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {

  private static RobotContainer m_robotContainer = new RobotContainer();

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    // The robot's subsystems
    public final ShooterSys m_shooterSys = new ShooterSys();
    public final LightsSys m_lightsSys = new LightsSys();
    public final IndexerSys m_indexerSys = new IndexerSys(m_lightsSys);
    public final ClimberSys m_climberSys = new ClimberSys();
    public final PropulsionSys m_propulsionSys = new PropulsionSys();
    public final TurretSys m_turretSys = new TurretSys();

    // Joysticks
    private final Joystick m_driverRightJoystick = new Joystick(1);
    private final Joystick m_driverLeftJoystick = new Joystick(0);
    private final Joystick m_operatorController = new  Joystick(2);

    // Buttons
    private final JoystickButton m_driverRightTrigger = new JoystickButton(m_driverRightJoystick, 1);
    private final JoystickButton m_driverRight3 = new JoystickButton(m_driverRightJoystick, 3);
    private final JoystickButton m_driverRight5 = new JoystickButton(m_driverRightJoystick, 5);

    private final JoystickButton m_operatorAButton = new JoystickButton(m_operatorController, 1);
    private final JoystickButton m_operatorBButton = new JoystickButton(m_operatorController, 2);
    private final JoystickButton m_operatorXButton = new JoystickButton(m_operatorController, 3);
    private final JoystickButton m_operatorYButton = new JoystickButton(m_operatorController, 4);

    private final JoystickButton m_operatorRightBumper = new JoystickButton(m_operatorController, 6);

    private final JoystickButton m_operatorWindowButton = new JoystickButton(m_operatorController, 7);
    private final JoystickButton m_operatorMenuButton = new JoystickButton(m_operatorController, 8);

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

    m_chooser.setDefaultOption("LowGoalBackUp", new AutoLowGoalBackUpPrgm(m_propulsionSys, m_indexerSys, m_shooterSys));
    m_chooser.addOption("HighGoal", new AutoHighGoalPrgm(m_propulsionSys, m_indexerSys, m_shooterSys, m_turretSys));

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS

    SmartDashboard.putData("Auto Mode", m_chooser);
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
    m_driverRight3.whileHeld(new AutoLaunchpadShootSeq(m_indexerSys, m_shooterSys)).whenReleased(new StopShooterCmd(m_shooterSys)).whenReleased(new StopIndexerCmd(m_indexerSys));
    m_driverRight5.whileHeld(new LowGoalShootCmd(m_shooterSys)).whileHeld(new FeedShooterCmd(m_indexerSys)).whenReleased(new StopShooterCmd(m_shooterSys)).whenReleased(new StopIndexerCmd(m_indexerSys));

    m_propulsionSys.setDefaultCommand(new RunCommand(
      () -> m_propulsionSys.mecanumDriveControl(m_driverLeftJoystick.getX(), -m_driverLeftJoystick.getY(), m_driverRightJoystick.getX(), m_driverRightJoystick.getZ(), false),
      m_propulsionSys)
    );

    m_lightsSys.setDefaultCommand(new RunCommand(
      () -> m_lightsSys.setPartyMode(m_driverRightJoystick.isConnected() && m_driverRightJoystick.getRawAxis(3) < 0.25),
      m_lightsSys)
    );
  }

  private void operatorBindingsBodi() {
    m_operatorAButton.whileHeld(new PrepareFeedCmd(m_indexerSys)).whenReleased(new StopIndexerCmd(m_indexerSys));
    m_operatorBButton.whileHeld(new LowGoalShootCmd(m_shooterSys)).whileHeld(new FeedShooterCmd(m_indexerSys)).whenReleased(new StopShooterCmd(m_shooterSys)).whenReleased(new StopIndexerCmd(m_indexerSys));
    m_operatorXButton.whileHeld(new LaunchpadShootRoutineCmd(m_shooterSys, m_indexerSys)).whenReleased(new StopIndexerCmd(m_indexerSys)).whenReleased(new StopShooterCmd(m_shooterSys));
    m_operatorYButton.whileHeld(new LaunchpadShootCmd(m_shooterSys)).whenReleased(new StopShooterCmd(m_shooterSys));

    m_operatorRightBumper.whileHeld(new ClimberRunCmd(m_climberSys)).whenReleased(new ClimberStopCmd(m_climberSys));

    m_operatorMenuButton.whenPressed(new ToggleTrackingCmd(m_turretSys));
    m_operatorWindowButton.whenPressed(new ZeroTurretCmd(m_turretSys));

    m_turretSys.setDefaultCommand(new RunCommand(
      () -> m_turretSys.joystickControl(m_operatorController.getRawAxis(4), -m_operatorController.getRawAxis(5)),
      // () -> m_turretSys.dPadControl(m_operatorController.getPOV()),
      m_turretSys));

    m_indexerSys.setDefaultCommand(new RunCommand(
      () -> m_indexerSys.operatorControl(m_operatorController.getRawAxis(1), m_operatorController.getRawAxis(3) > 0.5),
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

  public void setRumble(RumbleType type, double value) {
    m_operatorController.setRumble(type, value);
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
  */
  public Command getAutonomousCommand() {
    // The selected command will be run in autonomous
    // return m_chooser.getSelected();

     // Create a voltage constraint to ensure we don't accelerate too fast
     var autoVoltageConstraint = new DifferentialDriveKinematicsConstraint(Kinematics.kDriveKinematics, Kinematics.kMaxSpeedMetersPerSecond);

    // Create config for trajectory
    TrajectoryConfig config =
        new TrajectoryConfig(
            Kinematics.kMaxSpeedMetersPerSecond,
            Kinematics.kMaxAccelerationMetersPerSecondSquared
        )
        // Add kinematics to ensure max speed is actually obeyed
        .setKinematics(Kinematics.kDriveKinematics)
        // Apply the voltage constraint
        .addConstraint(autoVoltageConstraint);

    // An example trajectory to follow.  All units in meters.
    Trajectory exampleTrajectory =
        TrajectoryGenerator.generateTrajectory(
            // Start at the origin facing the +X direction
            new Pose2d(0, 0, new Rotation2d(0)),
            // Pass through these two interior waypoints, making an 's' curve path
            List.of(new Translation2d(1, 1), new Translation2d(2, -1)),
            // End 3 meters straight ahead of where we started, facing forward
            new Pose2d(3, 0, new Rotation2d(0)),
            // Pass config
            config
        );

    RamseteCommand ramseteCommand =
        new RamseteCommand(
            exampleTrajectory,
            m_propulsionSys::getPose,
            new RamseteController(Kinematics.kRamseteB, Kinematics.kRamseteZeta),
            new SimpleMotorFeedforward(Kinematics.ksVolts, Kinematics.kvVoltSecondsPerMeter), 
            Kinematics.kDriveKinematics, 
            m_propulsionSys::getDifferentialWheelSpeeds, 
            new PIDController(Kinematics.kPDriveVel, 0, 0),
            new PIDController(Kinematics.kPDriveVel, 0, 0),
            m_propulsionSys::tankDriveVolts,
            m_propulsionSys
        );

    // Reset odometry to the starting pose of the trajectory.
    m_propulsionSys.resetOdometry(exampleTrajectory.getInitialPose());

    // Run path following command, then stop at the end.
    return ramseteCommand.andThen(() -> m_propulsionSys.stop());
  }
}

