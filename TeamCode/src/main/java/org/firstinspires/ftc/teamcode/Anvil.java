package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;

import java.util.ArrayList;

/**
 * Created by dcrenshaw on 3/3/18.
 * Modern hardware augmentation for FIRST Tech Challenge.
 */

public class Anvil {
    //Define servo and motor variables
    public DcMotor motor1, motor2, motor3, motor4, motor5;
    public DcMotor clawMotor;

    //Reference to mapped servo/motor controller
    private HardwareMap hwMap;

    public Telemetry telemetry;

    public DcMotor[] forward, right, left, special, unique;

    public boolean hs = true;

    public enum Drivetrain {
        HOLONOMIC,
        TANK,
        WEST_COAST,
        MECHANUM,
        OMNIDRIVE,
        SWERVE
    }

    public Anvil(HardwareMap ahwMap, Drivetrain type, Telemetry telem) {
        hwMap = ahwMap;

        telemetry = telem;

        //Each of these cases are for different drive trains, the setup for each drive train is within.
        switch (type) {
            /*Example drive train:
            case TRAIN_NAME: //Make sure TRAIN_NAME is in the types enum!
                //Map all motors to proper variables.
                motor1 = hwMap.dcMotor.get("motor1");
                motor2 = hwMap.dcMotor.get("motor2");
                //Set motor directions. These should all be set so that power 1 for all
                //motors == robot moves forwards.
                motor1.setDirection(DcMotor.Direction.REVERSE);
                motor2.setDirection(DcMotor.Direction.FORWARD);
                //Set motor purposes for maneuvers. Motors in 'right' are the motors which must
                //move in reverse for the robot to turn right, and the same applies for left.
                //'forward' should contain all motors.
                forward = new DcMotor[]{motor1, motor2};
                right = new DcMotor[]{motor1};
                left = new DcMotor[]{motor2};
                //There is also a "special" motor array which is used for any additional
                //nonsense you want to do with the robot. Right now, it's just used for
                //holonomic and mechanum special movements.
                break;
             */

            case OMNIDRIVE:
                //Weird drive train, only two wheels move for the robot to go forward. Will need to
                // consider this when programming the robot to move.
                motor1 = hwMap.dcMotor.get("motor1");
                motor2 = hwMap.dcMotor.get("motor1");
                motor3 = hwMap.dcMotor.get("motor3");
                motor4 = hwMap.dcMotor.get("motor4");
                clawMotor = hwMap.dcMotor.get("clawMotor");
                motor1.setDirection(DcMotor.Direction.FORWARD);
                motor2.setDirection(DcMotor.Direction.REVERSE);
                motor3.setDirection(DcMotor.Direction.FORWARD);
                motor3.setDirection(DcMotor.Direction.REVERSE);
                forward = new DcMotor[]{motor1, motor2, motor3, motor4};
                right = new DcMotor[]{motor1, motor3};
                left = new DcMotor[]{motor2, motor4};
                break;


            case HOLONOMIC:
                //Assign motors
                clawMotor = hwMap.dcMotor.get("clawMotor");
                motor1 = hwMap.dcMotor.get("motor1");
                motor2 = hwMap.dcMotor.get("motor2");
                motor3 = hwMap.dcMotor.get("motor3");
                motor4 = hwMap.dcMotor.get("motor4");
                //Set motor directions
                motor1.setDirection(DcMotor.Direction.FORWARD);
                motor2.setDirection(DcMotor.Direction.REVERSE);
                motor3.setDirection(DcMotor.Direction.FORWARD);
                motor4.setDirection(DcMotor.Direction.REVERSE);
                //Set motor purposes
                forward = new DcMotor[]{motor1, motor2, motor3, motor4};
                right = new DcMotor[]{motor2, motor4};
                left = new DcMotor[]{motor1, motor3};
                special = new DcMotor[]{motor1, motor4};
                unique = new DcMotor[]{motor2, motor3};
                hs = false;
                break;
            case TANK:
                motor1 = hwMap.dcMotor.get("motor1");
                motor2 = hwMap.dcMotor.get("motor2");
                motor1.setDirection(DcMotor.Direction.REVERSE);
                motor2.setDirection(DcMotor.Direction.FORWARD);
                forward = new DcMotor[]{motor1, motor2};
                right = new DcMotor[]{motor1};
                left = new DcMotor[]{motor2};
                break;
            case WEST_COAST:
                motor1 = hwMap.dcMotor.get("motor1");
                motor2 = hwMap.dcMotor.get("motor2");
                motor3 = hwMap.dcMotor.get("motor3");
                motor4 = hwMap.dcMotor.get("motor4");
                motor1.setDirection(DcMotor.Direction.REVERSE);
                motor2.setDirection(DcMotor.Direction.FORWARD);
                motor3.setDirection(DcMotor.Direction.REVERSE);
                motor4.setDirection(DcMotor.Direction.REVERSE);
                forward = new DcMotor[]{motor1, motor2, motor3, motor4};
                right = new DcMotor[]{motor1, motor4};
                left = new DcMotor[]{motor2, motor3};
                break;
            case MECHANUM:
                //Map all motors to proper variables.
                motor1 = hwMap.dcMotor.get("motor1");
                motor2 = hwMap.dcMotor.get("motor2");
                motor3 = hwMap.dcMotor.get("motor3");
                motor4 = hwMap.dcMotor.get("motor4");
                motor1.setDirection(DcMotor.Direction.REVERSE);
                motor2.setDirection(DcMotor.Direction.FORWARD);
                motor3.setDirection(DcMotor.Direction.FORWARD);
                motor4.setDirection(DcMotor.Direction.REVERSE);
                forward = new DcMotor[]{motor1, motor2, motor3, motor4};
                left = new DcMotor[]{motor3, motor2}; //previously motor 1, motor 3
                right = new DcMotor[]{motor1, motor4}; //previously motor 2, motor 4
                special = new DcMotor[]{motor2, motor4};//previously motor 1, motor 4
                unique = new DcMotor[]{motor1, motor3}; // previously motor 3, motor 2
                hs = false;
                break;
            case SWERVE:
                motor1 = hwMap.dcMotor.get("motor1");
                motor2 = hwMap.dcMotor.get("motor2");
                motor3 = hwMap.dcMotor.get("motor3");
                motor4 = hwMap.dcMotor.get("motor4");
                motor5 = hwMap.dcMotor.get("motor5");
                motor1.setDirection(DcMotor.Direction.FORWARD);
                motor2.setDirection(DcMotor.Direction.FORWARD);
                motor3.setDirection(DcMotor.Direction.FORWARD);
                motor4.setDirection(DcMotor.Direction.FORWARD);
                motor5.setDirection(DcMotor.Direction.FORWARD);
                forward = new DcMotor[]{motor1, motor2, motor3, motor4};
                right = new DcMotor [] {motor5};
                left = new DcMotor[] {motor5};
                break;
            default:
                telemetry.addLine("Invalid type " + type + " passed to Anvil's init function. Nothing has been set up.");
                break;
        }
        for (DcMotor x : forward) {x.setPower(0); x.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);}
    }
    public void initCustom(HardwareMap ahwMap, Telemetry telem, DcMotor[] rightI, DcMotor[] leftI, DcMotor[] forwardI, DcMotor.Direction[] orderedDirections) {
        //Allows initialization of custom drive trains not in list programatically.
        telemetry = telem;
        hwMap = ahwMap;
        right = rightI;
        left = leftI;
        forward = forwardI;
        for (int x = 0; x < forward.length; x++) {
            forward[x].setDirection(orderedDirections[x]);
        }
    }
    //Movement, turning, and resting methods for the all current drive trains
    public void moveForward(double pace) {for (DcMotor x:forward) x.setPower(pace);}
    public void turnRight(double pace) {
        if (hs) {
            for (DcMotor x:right) x.setPower(-pace / 2);
            for (DcMotor x:left) x.setPower(pace / 2);
        }
        else {
            for (DcMotor x:right) x.setPower(-pace);
            for (DcMotor x:left) x.setPower(pace);
        }
    }
    public void turnLeft(double pace) {
        if (hs) {
            for (DcMotor x:left) x.setPower(-pace / 2);
            for (DcMotor x:right) x.setPower(pace / 2);
        }
        else {
            for (DcMotor x:left) x.setPower(-pace);
            for (DcMotor x:right) x.setPower(pace);
        }
    }
    public void moveBackward(double pace) {
        for (DcMotor x:forward)
            x.setPower(-pace);
    }
    public void rest() {
        for (DcMotor x:forward) {
            x.setPower(0);
        }
    }

    //Experimental function to turn while moving forward. Increases Maneuverability of robot.
    //ctx = controller x
    public void diff(double ctx, double pace) {
        for (DcMotor x:left) x.setPower(pace - (ctx * 2));
        for (DcMotor x:right) x.setPower(pace + (ctx * 2));
    }

    //Holonomic specific movements
    public void holoMoveRight(double pace) {
        for (DcMotor x: unique) x.setPower(pace);
        for (DcMotor x:special) x.setPower(-pace);
    }
    public void holoMoveLeft(double pace) {
        for (DcMotor x: unique) x.setPower(-pace);
        for (DcMotor x:special) x.setPower(pace);
    }

    private void sleep(long milliseconds) {
        //Ripped right from the FTC OpMode specifications
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}