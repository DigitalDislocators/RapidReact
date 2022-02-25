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

import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS

// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS

public class LightsSys extends SubsystemBase {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    Solenoid r;
    Solenoid g;
    Solenoid b;

    String color;

    Timer timer;
    
    /**
     * Constructs a new HookSys.
     * 
     * HookSys contains the hook deployment motors and the winch motor.
     * 
     * This subsystem contains methods for setting the motor powers and stopping them.
     */
    public LightsSys() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS

        r = new Solenoid(PneumaticsModuleType.CTREPCM, 5);
        g = new Solenoid(PneumaticsModuleType.CTREPCM, 6);
        b = new Solenoid(PneumaticsModuleType.CTREPCM, 7);

        timer = new Timer();
        timer.start();
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run

        // if(timer.hasElapsed(0.3)) {
        //     timer.reset();
        //     if(color.equals("magenta")) {
        //         red();
        //     }
        //     else if(color.equals("red")) {
        //         yellow();
        //     }
        //     else if(color.equals("yellow")) {
        //         green();
        //     }
        //     else if(color.equals("green")) {
        //         cyan();
        //     }
        //     else if(color.equals("cyan")) {
        //         blue();
        //     }
        //     else if(color.equals("blue")) {
        //         magenta();
        //     }
        // }
    }

    @Override
    public void simulationPeriodic() {
        // This method will be called once per scheduler run when in simulation

    }

    public void magenta() {
        color = "magenta";
        r.set(true);
        g.set(false);
        b.set(true);
    }

    public void red() {
        color = "red";
        r.set(true);
        g.set(false);
        b.set(false);
    }

    public void yellow() {
        color = "yellow";
        r.set(true);
        g.set(true);
        b.set(false);  
    }

    public void green() {
        color = "green";
        r.set(false);
        g.set(true);
        b.set(false);  
    }

    public void cyan() {
        color = "cyan";
        r.set(false);
        g.set(true);
        b.set(true);  
    }

    public void blue() {
        color = "blue";
        r.set(false);
        g.set(false);
        b.set(true);  
    }

    public void white() {
        color = "white";
        r.set(true);
        g.set(true);
        b.set(true);  
    }

    public void off() {
        color = "off";
        r.set(false);
        g.set(false);
        b.set(false);  
    }


    // Put methods for controlling this subsystem
    // here. Call these from Commands.

}
