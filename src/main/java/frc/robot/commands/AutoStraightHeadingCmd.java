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
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import frc.robot.subsystems.PropulsionSys;

// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS


public class AutoStraightHeadingCmd extends CommandBase {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS
    private final PropulsionSys m_propulsionSys;
 
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS

        private double m_counts;
        private double m_heading;
        private double m_power;
        private double m_turnPush = 0;
        private double m_drivePush = 0;
        private boolean m_driveIsFinished = false;
        private boolean m_turnIsFinished = false;

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS

    /**
     * Constructs a new AutoStraightHeadingCmd with a target heading other than the robot's current heading.
     * 
     * <p>AutoStraightHeadingCmd uses the encoders in the drivebase motors to command it to drive a certain distance, in feet 
     * and inches, as well as the gyro/IMU of the robot to constantly adjust the heading.
     * 
     * <p>This command is based off of a proportional controller, which means that the speed the robot drives turns will decrease 
     * as it approaches its target distance and the speed the robot turns will decrease as it approaches its target heading. This 
     * command features "push" variables that increases when the robot nearly stops outside of its targets, which adds power to 
     * the driving and turning until the robot moves to prevent it from not having enough power to reach the target distance and 
     * heading.
     * 
     * <p>The command finishes when the robot is within one inch of its target and nearly stopped.
     * 
     * @param feet The number of feet of the target distance
     * @param inches The number of inches of the target distance
     * @param heading The target heading of the robot in degrees
     * @param power The maximum power delivered to the drive base, which controls the speed of the turn
     * @param subsystem The required PropulsionSys
     * 
     */
    public AutoStraightHeadingCmd(int feet, int inches, double heading, double power, PropulsionSys subsystem) {


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING

        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES

        m_propulsionSys = subsystem;
        addRequirements(m_propulsionSys);

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES

        // Adding feet and inches together and multiplying by the number of encoder counts in one inch of wheel rotation
        // plus the current encoder counts of the drivebase to obtain the target encoder counts of the drivebase motors
        m_counts = ((feet * 12) + inches) * Constants.Encoder.countsPerInch + m_propulsionSys.getAverageEncoderCounts();

        m_heading = heading;

        // Making sure power is positive for continuity
        m_power = Math.abs(power);

    }


    /**
     * Constructs a new AutoStraightHeadingCmd that uses the current heading of the robot as the target heading.
     * 
     * <p>AutoStraightHeadingCmd uses the encoders in the drivebase motors to command it to drive a certain distance, in feet 
     * and inches, as well as the gyro/IMU of the robot to constantly adjust the heading.
     * 
     * <p>This command is based off of a proportional controller, which means that the speed the robot drives turns will decrease 
     * as it approaches its target distance and the speed the robot turns will decrease as it approaches its target heading. This 
     * command features "push" variables that increases when the robot nearly stops outside of its targets, which adds power to 
     * the driving and turning until the robot moves to prevent it from not having enough power to reach the target distance and 
     * heading.
     * 
     * <p>The command finishes when the robot is within one inch of its target and nearly stopped.
     * 
     * @param feet The number of feet of the target distance
     * @param inches The number of inches of the target distance
     * @param power The maximum power delivered to the drive base, which controls the speed of the turn
     * @param subsystem The required PropulsionSys
     */
    public AutoStraightHeadingCmd(int feet, int inches, double power, PropulsionSys subsystem) {


        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
            // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
    
            // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
    
            // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    
            m_propulsionSys = subsystem;
            addRequirements(m_propulsionSys);
    
            // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    
            // Adding feet and inches together and multiplying by the number of encoder counts in one inch of wheel rotation
            // plus the current encoder counts of the drivebase to obtain the target encoder counts of the drivebase motors
            m_counts = ((feet * 12) + inches) * Constants.Encoder.countsPerInch + m_propulsionSys.getAverageEncoderCounts();
    
            m_heading = m_propulsionSys.getHeading();
    
            // Making sure power is positive for continuity
            m_power = Math.abs(power);
    
        }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {

        //Making sure the robot doesn't do donuts (turn more than 360 degrees)
        while(m_heading - m_propulsionSys.getHeading() > 180) {
            m_heading -= 360;
        }
        while(m_heading - m_propulsionSys.getHeading() < -180) {
            m_heading += 360;
        }

    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        // Proportional controller for turning
        double turnPower = ((m_heading - m_propulsionSys.getHeading()) * Constants.Kp.turnWhileDriving) + m_turnPush;

        // Using rotation rate for m_turnPush
        if(Math.abs(m_propulsionSys.getAngleRate()) < 20) {
            if(m_propulsionSys.getHeading() > m_heading - 0.5 && m_propulsionSys.getHeading() < m_heading + 0.5) {
                if(m_driveIsFinished) {
                    m_turnIsFinished = true;
                }
                m_turnPush = 0;
            }
            else {
                if(turnPower < 0) {
                    m_turnPush -= Constants.Kp.turnWhileDriving * 0.5;
                }
                else {
                    m_turnPush += Constants.Kp.turnWhileDriving * 0.5;
                }
            }
        }
        else {
            m_turnPush = 0;
        }

        // Proportional controller for driving
        double drivePower = ((m_counts - m_propulsionSys.getAverageEncoderCounts()) * Constants.Kp.drive) + m_drivePush;

        // Factoring in power input
        if(drivePower < -m_power) {
            drivePower = -m_power;
        }
        else if(drivePower > m_power) {
            drivePower = m_power;
        }

        // Using speed for m_push and m_isFinished
        if(Math.abs(m_propulsionSys.getInchesPerSecond()) < 1) {
            if(m_propulsionSys.getAverageEncoderCounts() > m_counts - (Constants.Encoder.countsPerInch * 0.5) && m_propulsionSys.getAverageEncoderCounts() < m_counts + (Constants.Encoder.countsPerInch * 0.5)) {
                m_drivePush = 0;
                m_driveIsFinished = true;
            }
            else {
                m_driveIsFinished = false;
                if(drivePower < 0) {
                    m_drivePush -= Constants.Kp.drive * 0.5;
                }
                else {
                    m_drivePush += Constants.Kp.drive * 0.5;
                }
            }
        }
        else {
            m_driveIsFinished = false;
            m_drivePush = 0;
        }

        // Combining drivePower and turnPower
        double leftPower = turnPower + drivePower;
        double rightPower = -turnPower + drivePower;

        // Making sure the robot will turn in place instead of driving in a circle by subtracting how much larger one side is
        // greater than m_power from either side. This essentially means that if the robot needs to turn a large distance, it
        // won't let one side spin at its maximum while the other side barely moves. It'll add the "overflow" to the other
        // side.
        if(rightPower - m_power > 0) {
            leftPower -= rightPower - m_power;
        }
        else if(leftPower - m_power > 0) {
            rightPower -= leftPower - m_power;
        }

        // // Regulating turn speed with m_power. The extra range (+/- 0.1) allows the robot to turn a bit faster.
        // if(leftPower < -m_power - 0.1) {
        //     turnPower = -m_power;
        // }
        // else if(leftPower > m_power + 0.1) {
        //     turnPower = m_power;
        // }
        
        // if(rightPower < -m_power - 0.1) {
        //     turnPower = -m_power;
        // }
        // else if(rightPower > m_power + 0.1) {
        //     turnPower = m_power;
        // }

        SmartDashboard.putString("Status", "DRIVING: " + (m_counts - m_propulsionSys.getAverageEncoderCounts()) / Constants.Encoder.countsPerInch);

        // Setting motor powers
        m_propulsionSys.tankDriveControl(leftPower, rightPower);
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        // Sets motor powers to zero when command is finished.
        m_propulsionSys.stop();
        SmartDashboard.putString("Status", "DRIVE FINISHED");
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return m_turnIsFinished;
    }

    @Override
    public boolean runsWhenDisabled() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DISABLED
        return false;

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DISABLED
    }
}
