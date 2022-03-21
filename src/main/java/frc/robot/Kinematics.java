package frc.robot;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.controller.RamseteController;
import edu.wpi.first.math.controller.SimpleMotorFeedforward;
import edu.wpi.first.math.kinematics.DifferentialDriveKinematics;
import edu.wpi.first.math.trajectory.Trajectory;
import edu.wpi.first.math.trajectory.TrajectoryConfig;
import edu.wpi.first.math.trajectory.constraint.DifferentialDriveVoltageConstraint;
import edu.wpi.first.wpilibj2.command.RamseteCommand;
import frc.robot.subsystems.PropulsionSys;

public class Kinematics {
    public static final double ksVolts = 0.48799;
    public static final double kvVoltSecondsPerMeter = 1.587;
    public static final double kaVoltSecondsSquaredPerMeter = 0.75387;

    public static final double kPDriveVel = 2.4457;

    public static final double kTrackwidthMeters = 0.61;
    public static final DifferentialDriveKinematics kDriveKinematics = new DifferentialDriveKinematics(kTrackwidthMeters);

    public static final double kMaxSpeedMetersPerSecond = 1;
    public static final double kMaxAccelerationMetersPerSecondSquared = 1;

    public static final double maxVolts = 8.0;

    // Reasonable baseline values for a RAMSETE follower in units of meters and seconds
    public static final double kRamseteB = 2;
    public static final double kRamseteZeta = 0.7;

    public static TrajectoryConfig config() {
        TrajectoryConfig r_config = new TrajectoryConfig(
            kMaxSpeedMetersPerSecond, 
            kMaxAccelerationMetersPerSecondSquared
        );
        r_config.setKinematics(kDriveKinematics).addConstraint(autoVoltageConstraint);
        return r_config;
    }

    private static final DifferentialDriveVoltageConstraint autoVoltageConstraint =
    new DifferentialDriveVoltageConstraint(
        new SimpleMotorFeedforward(ksVolts,
                                   kvVoltSecondsPerMeter,
                                   kaVoltSecondsSquaredPerMeter),
        kDriveKinematics,
        maxVolts);

    public static RamseteCommand ramseteCommand(PropulsionSys propulsionSys, Trajectory trajectory) {
        propulsionSys.resetOdometry(trajectory.getInitialPose());
        return new RamseteCommand(
            trajectory,
            propulsionSys::getPose,
            new RamseteController(Kinematics.kRamseteB, Kinematics.kRamseteZeta),
            new SimpleMotorFeedforward(Kinematics.ksVolts, Kinematics.kvVoltSecondsPerMeter), 
            Kinematics.kDriveKinematics, 
            propulsionSys::getDifferentialWheelSpeeds, 
            new PIDController(Kinematics.kPDriveVel, 0, 0),
            new PIDController(Kinematics.kPDriveVel, 0, 0),
            propulsionSys::tankDriveVolts,
            propulsionSys
        );

    }
}
