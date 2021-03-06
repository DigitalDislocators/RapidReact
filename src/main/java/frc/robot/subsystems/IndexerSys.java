// RobotBuilder Version: 4.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

// ROBOTBUILDER TYPE: Subsystem.

package frc.robot.subsystems;


import frc.robot.Constants;
import frc.robot.RobotContainer;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.DriverStation.Alliance;
import edu.wpi.first.wpilibj.GenericHID.RumbleType;
import edu.wpi.first.wpilibj.I2C.Port;
import edu.wpi.first.wpilibj.shuffleboard.BuiltInWidgets;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
// import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.revrobotics.CANSparkMax;
import com.revrobotics.ColorSensorV3;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS


public class IndexerSys extends SubsystemBase {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    private CANSparkMax intakeMtr;
    private WPI_TalonSRX feedMtr;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    private ColorSensorV3 sensor;

    private LightsSys m_lightsSys;

    private boolean m_cargoIsGood;

    private NetworkTableEntry sb_cargoIsGood;
    private NetworkTableEntry sb_isFeeding;

    /**
     * Constructs a new IndexerSys.
     * 
     * IndexerSys contains the intake and indexer motors and the color/proximity sensor.
     * 
     * This subsystem contains methods for running the intake routine, setting the powers of the motors,
     * and stopping them.
     */
    public IndexerSys(LightsSys lightsSys) {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS

        intakeMtr = new CANSparkMax(8, MotorType.kBrushless);
        intakeMtr.setInverted(true);

        feedMtr = new WPI_TalonSRX(9);

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS

        sensor = new ColorSensorV3(Port.kOnboard);

        m_lightsSys = lightsSys;

        sb_cargoIsGood = Shuffleboard.getTab("DOOFENSHMIRTZ").add("Cargo Color", false)
            .withWidget(BuiltInWidgets.kBooleanBox)
            .withSize(4, 2)
            .withPosition(3, 5)
            .getEntry();
        sb_isFeeding = Shuffleboard.getTab("DOOFENSHMIRTZ").add("Feeding", false)
            .withWidget(BuiltInWidgets.kBooleanBox)
            .withSize(2, 2)
            .withPosition(14, 5)
            .getEntry();
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run
        if(sensor.getProximity() > Constants.Sensor.indexerProxThresh) {
            if(sensor.getRed() > 360 && sensor.getBlue() < 380) {
                // Cargo is red
                if(DriverStation.getAlliance() == Alliance.Blue) {
                    m_cargoIsGood = false;
                }
                else {
                    m_cargoIsGood = true;
                }
                if(!m_lightsSys.isMode()) {
                    m_lightsSys.red();
                }
            }
            else  {
                // Cargo is blue
                if(DriverStation.getAlliance() == Alliance.Red) {
                    m_cargoIsGood = false;
                }
                else {
                    m_cargoIsGood = true;
                }
                if(!m_lightsSys.isMode()) {
                    m_lightsSys.blue();
                }
            }
        }
        else {
            if(!m_lightsSys.isMode()) {
                m_lightsSys.green();
            }
            m_cargoIsGood = true;
        }

        sb_cargoIsGood.setBoolean(m_cargoIsGood);
        sb_isFeeding.setBoolean(feedMtr.get() > 0.25 && cargoIsIn());

        if(!m_cargoIsGood) {
            RobotContainer.getInstance().setRumble(RumbleType.kLeftRumble, 1.0);
        }
        else {
            RobotContainer.getInstance().setRumble(RumbleType.kLeftRumble, 0.0);
        }

        SmartDashboard.putString("Sensor RGB", sensor.getRed() + ", " + sensor.getGreen() + ", " + sensor.getBlue());
    }

    @Override
    public void simulationPeriodic() {
        // This method will be called once per scheduler run when in simulation

    }

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    
    /**
     * Runs the intake unless a second cargo has pushed the first one in front of the sensor.
     */
    public void intake() {
        if(sensor.getProximity() > Constants.Sensor.indexerProxThresh) {
            intakeMtr.set(0.0);
            feedMtr.set(0.0);
        }
        else {
            intakeMtr.set(Constants.Power.intake);
        }
    }

    public void feed() {
        feedMtr.set(Constants.Power.feedFeed);
        if(cargoIsIn()) {
            intakeMtr.set(0.0);
        }
        else {
            intakeMtr.set(Constants.Power.intakeToFeedRatio);
        }
    }

    public void autoFeed() {
        feedMtr.set(Constants.Power.feedFeed);
        intakeMtr.set(Constants.Power.intakeToFeedRatio);
    }

    public void lowGoalDump() {
        feedMtr.set(Constants.Power.feedFeed);
        intakeMtr.set(Constants.Power.intakeToFeedRatio);
    }

    public void prepareFeed() {
        if(!cargoIsIn()) {
            lowGoalDump();
        }
        else {
            stop();
        }
    }

    public void triggerControl(boolean run) {
        if(run) {
            intakeMtr.set(Constants.Power.intakeToFeedRatio);
            feedMtr.set(Constants.Power.feedFeed);
        }
        else {
            intakeMtr.set(0);
            feedMtr.set(0);
        }
    }

    /**
     * Sets the power of both motors of the indexer and the shooter.
     * 
     * @param power the desired power to set the indexer to
     * @param shooterSys ShooterSys to set the shooter power to run backwards
     */
    public void set(double power, ShooterSys shooterSys) {
        if(Math.abs(power) > 0.25) {
            if(power < 0) {
                shooterSys.set(power * 0.25);
            }
            else {
                shooterSys.set(0.0);
            }
            intakeMtr.set(power * Constants.Power.intakeToFeedRatio);
            feedMtr.set(power);
        }
        else {
            shooterSys.set(0.0);
            stop();
        }
    }

    /**
     * Sets the power of both motors of the indexer.
     * 
     * @param power the desired power to set the indexer to
     */
    public void set(double power) {
        if(Math.abs(power) > 0.25) {
            if(power < 0) {
                if(cargoIsIn()) {
                    intakeMtr.set(power * Constants.Power.intakeToFeedRatio);
                }
                else {
                    intakeMtr.set(power);
                }
            }
            else {
                intakeMtr.set(power);
            }
            feedMtr.set(power);
        }
        else {
            stop();
        }
    }

    /**
     * Stops both motors of the indexer.
     */
    public void stop() {
        intakeMtr.set(0.0);
        feedMtr.set(0.0);
    }

    /**
     * Checks whether the next cargo should be shot.
     * 
     * @return true if the color of the cargo in front of the sensor matches the alliance color.
     */
    public boolean cargoIsGood() {
        return m_cargoIsGood;
    }

    public boolean cargoIsIn() {
        if(sensor.getProximity() > Constants.Sensor.indexerProxThresh) {
            return true;
        }
        else {
            return false;
        }
    }

    public void operatorControl(double set, boolean runIntake, ShooterSys shooterSys) {
        if(runIntake) {
            intake();
        }
        else {
            set(set, shooterSys);
        }
    }
}