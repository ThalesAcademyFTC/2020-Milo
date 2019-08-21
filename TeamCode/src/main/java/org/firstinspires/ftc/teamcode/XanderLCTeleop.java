package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

/**
 * Created by dcrenshaw on 4/7/19.
 * Clasp is a basic, bare-bones teleop designed to run on top of Anvil.
 */
@TeleOp(name="Xander", group="PushBot")
//@Disabled
public class XanderLCTeleop extends OpMode {

    private XanderLCForge robot;
@Override
    public void init() {
        robot = new XanderLCForge(hardwareMap, XanderLCForge.Drivetrain.TEST, telemetry);
    }
@Override
    public void loop() {
        if (gamepad1.atRest()){
            robot.robotRest();
        }else if (gamepad1.left_stick_y > 0){
            robot.robotFoward(gamepad1.left_stick_y);
        }else if (gamepad1.left_stick_y < 0){
            robot.robotFoward(gamepad1.left_stick_y);
        }else if (gamepad1.right_stick_x < 0){
            robot.robotLeft(gamepad1.left_stick_x);
        }else if (gamepad1.right_stick_x > 0){
            robot.robotLeft(gamepad1.left_stick_x);
        }
    }
}




