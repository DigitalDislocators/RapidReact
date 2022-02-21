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


import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj.interfaces.Gyro;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS


/**
 *
 */
public class PropulsionSys extends SubsystemBase {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
private WPI_TalonSRX leftBackMtr;
private WPI_TalonSRX rightBackMtr;
private WPI_TalonSRX rightFrontMtr;
private WPI_TalonSRX leftFrontMtr;

private MecanumDrive mecanumDrive;

private Gyro gyro;


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    
    /**
    *
    */
    public PropulsionSys() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
leftBackMtr = new WPI_TalonSRX(8);
 addChild("LeftBackMtr",leftBackMtr);
 leftBackMtr.setInverted(true);

rightBackMtr = new WPI_TalonSRX(2);
 addChild("RightBackMtr",rightBackMtr);
 rightBackMtr.setInverted(false);

rightFrontMtr = new WPI_TalonSRX(1);
 addChild("RightFrontMtr",rightFrontMtr);
 rightFrontMtr.setInverted(false);

leftFrontMtr = new WPI_TalonSRX(7);
 addChild("LeftFrontMtr",leftFrontMtr);
 leftFrontMtr.setInverted(true);

mecanumDrive = new MecanumDrive(leftFrontMtr, leftBackMtr, rightFrontMtr, rightBackMtr);
 addChild("MecanumDrive",mecanumDrive);
mecanumDrive.setExpiration(0.1);
mecanumDrive.setMaxOutput(1.0);
mecanumDrive.setSafetyEnabled(true);

gyro = new ADXRS450_Gyro();


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }

    public void mecanumDriveXNonlinear(double y, double x, double z) {
        mecanumDrive.driveCartesian(y, (x < 0 ? -Math.pow(x, 2) : Math.pow(x, 2)), z, gyro.getAngle());
        SmartDashboard.putNumber("leftFrontPow", leftFrontMtr.get());
        SmartDashboard.putNumber("rightFrontPow", rightFrontMtr.get());
        SmartDashboard.putNumber("leftBackPow", leftBackMtr.get());
        SmartDashboard.putNumber("rightBackPow", rightBackMtr.get());
    }

    public void mecanumDrive(double y, double x, double z) {
        mecanumDrive.driveCartesian(y, x, z, gyro.getAngle());
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run

    }

    @Override
    public void simulationPeriodic() {
        // This method will be called once per scheduler run when in simulation

    }

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

}

