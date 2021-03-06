// RobotBuilder Version: 4.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared glocargoy (i.e. public static).  Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public class Constants {

   /**
    * The Constants.Encoder class provides constants important for the interpretation of encoder counts.
    */
   public class Encoder {
      // Dividing 8" wheel circumference by encoder counts per revolution of TalonSRX
      /**
       * The amount of encoder counts per inch of movement of an 8-inch wheel.
       */
      public static final double countsPerInch = 163; //4096 / (8 * Math.PI);

      /**
       * The amount of encoder counts per foot of movement of an 8-inch wheel.
       */
      public static final double countsPerFoot = 4096 / (8 * Math.PI) * 12;

      /**
       * The amount of encoder counts per meter of movement of an 8-inch wheel.
       */
      public static final double countsPerMeter = 4096 / (0.2032 * Math.PI);

      /**
       * The amount of encoder counts per degree of rotation of the turret.
       */
      public static final double countsPerDegree = 23368 / 360;

      /**
       * The amount of degrees the turret can rotate in one direction before inverting.
       */
      public static final int turretWindow = 180;

      /**
       * The number of encoder counts when the climber is all the way up.
       */
      public static final int climberUp = 31500;

      /**
       * The number of encoder counts when the climber is down.
       */
      public static final int climberDown = 50000;

   }

   /**
    * The Constants.PID class provides PID values for various PID controllers.
    */
   public class PID {
      /**
       * kP for turning in place.
       */
      public static final double turnP = 0.05;

      /**
       * kP for aiming with the drivebase.
       */
      public static final double aimP = 0.015;

      /**
       * kP for turning while driving.
       */
      public static final double turnWhileDrivingP = 0.01;

      /**
       * kP for driving.
       */
      public static final double driveP = 0.001;

      /**
       * kP for aiming the turret.
       */
      public static final double turretP = 0.037;

      /**
       * kI for aiming the turret.
       */
      public static final double turretI = 0.008;

      /**
       * kD for aiming the turret.
       */
      public static final double turretD = 0.0012;

      /**
       * kP for setting shooter velocity.
       */
      public static final double shooterP = 0.4;

      /**
       * kD for setting shooter velocity.
       */
      public static final double shooterD = 0.0025;

      public static final double shooterFF = 0.00125;

   }

   /**
    * The Constants.Joystick class provides constants important for interpreting joystick inputs.
    */
   public class Joystick {
      /**
       * The ratio for how fine robot turning will be.
       */
      public static final double fineTurnRatio = 0.4;
   }

   /**
    * The Constants.Sensor class provides constants important for interpreting sensor inputs.
    */
   public class Sensor {
      /**
       * The threshhold of the indexer sensor for stopping the intake.
       */
      public static final double indexerProxThresh = 100;
   }

   /**
    * The Constants.Power class provides motor powers for motors in various subsystems.
    */
   public class Power {
      // Indexer powers
      /**
       * The power of the intake when intaking.
       */
      public static final double intake = 0.55;

      /**
       * The power of both indexer motors when running in reverse.
       */
      public static final double indexerReverse = -0.8;

      /**
       * The ratio between the powers of the intake and feed motors.
       * If feed motor is 1.0 in manual control, intake motor will be this value.
       */
      public static final double intakeToFeedRatio = 0.45; // 0.35 is same speed

      /**
       * The power of the feed motor when feeding the shooter.
       */
      public static final double feedFeed = 0.8;

      // Shooter powers
      /**
       * The power for the shooter when dumping in the low goal.
       */
      public static final double lowGoal = 0.32;

      /**
       * The power for the shooter when shooting from the launchpad.
       */
      public static final double launchpad = 0.7;

      /**
       * The maximum spin-up time for the shooter in seconds.
       */
      public static final double maxSpinUpTime = 1.0;

      /**
       * The maximum RPM of the shooter motor.
       */
      public static final double shooterMaxRPM = 5800; //5800

      /**
       * The maximum power of the turret.
       */
      public static final double maxTurretPower = 0.65;

      /**
       * The speed of the turret manual speed control.
       */
      public static final double turretRotControl = 2.5;

      /**
       * The increment or decrement of shooter error control buttons
       */
      public static final double shooterErrorControlInterval = 0.75;
   }

   /**
    * The Constants.Lights class provides constants important for the operation of the lights.
    */
   public class Lights {
      /**
       * The time in seconds between each color change in party mode.
       */
      public static final double partySpeed = 0.2;

      /**
       * The time in seconds between each color change in police mode.
       */
      public static final double policeSpeed = 0.15;
   }

   /**
    * The Constants.Rumble class provides constants for controller rumble
    */
   public class Rumble {
      /**
       * Enables or disables controller rumble
       */
      public static final boolean isEnabled = true;

      /**
       * The amount of time the controller will buzz
       */
      public static final double buzzTime = 0.25;
   }
}

