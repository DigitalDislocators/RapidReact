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
      public static final double countsPerInch = 4096 / (8 * Math.PI);

      /**
       * The amount of encoder counts per foot of movement of an 8-inch wheel.
       */
      public static final double countsPerFoot = 4096 / (8 * Math.PI) * 12;
   }

   /**
    * The Constants.Kp class provides Kp values for various proportional controllers.
    */
   public class Kp {
      /**
       * Kp for turning in place.
       */
      public static final double turn = 0.05;

      /**
       * Kp for aiming.
       */
      public static final double aim = 0.03;

      /**
       * Kp for turning while driving.
       */
      public static final double turnWhileDriving = 0.005;

      /**
       * Kp for driving.
       */
      public static final double drive = 0.001;

      /**
       * Kp for driving to a point, where distance is measured in feet.
       */
      public static final double driveToPoint = 4.1;
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
      public static final double indexerProxThresh = 90;
   }

   /**
    * The Constants.Power class provides motor powers for motors in various subsystems.
    */
   public class Power {
      // Indexer powers
      /**
       * The power of the intake when intaking.
       */
      public static final double intake = 0.65;

      /**
       * The power of both indexer motors when running in reverse.
       */
      public static final double indexerReverse = -0.8;

      /**
       * The ratio between the powers of the intake and feed motors.
       */
      public static final double intakeToFeedRatio = 0.65;

      /**
       * The power of the feed motor when feeding the shooter.
       */
      public static final double feedFeed = 1.0;

      // Shooter powers
      /**
       * The power for the shooter when dumping in the low goal.
       */
      public static final double lowGoal = 0.32;

      /**
       * The power for the shooter when shooting from the launchpad.
       */
      public static final double launchpad = 0.79;

      /**
       * The spin-up time for the shooter in seconds.
       */
      public static final double spinUpTime = 0.5;
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
       * The time in seconds between each color flash in blink mode.
       */
      public static final double blinkSpeed = 0.2;
   }
}

