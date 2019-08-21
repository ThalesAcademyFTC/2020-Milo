package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

/**
 * Created by dcrenshaw on 4/7/19.
 * Clasp is a basic, bare-bones teleop designed to run on top of Anvil.
 */

public class evanTeleop extends OpMode {

    private evanForge robot;
    public void init() {
        robot = new evanForge(hardwareMap, evanForge.Drivetrain.EVAN, telemetry);
    }
    public void loop() {
        if (gamepad1.left_stick_y > 0) {
            robot.forward(-1);
        } else if (gamepad1.left_stick_x > 0) {
            robot.right(-1);
        } else if (gamepad1.left_stick_x < 0){
            robot.right(1);
        } else if (gamepad1.left_stick_y < 0){
            robot.forward (1);
        } else {
            robot.stop();
        }

    }
}
