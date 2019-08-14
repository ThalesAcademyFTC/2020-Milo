package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

/**
 * Created by dcrenshaw on 4/7/19.
 * Clasp is a basic, bare-bones teleop designed to run on top of Anvil.
 */

public class XanderLCTeleop extends OpMode {

    private XanderLCForge robot;
    public void init() {
        robot = new XanderLCForge(hardwareMap, XanderLCForge.Drivetrain.TEST, telemetry);
    }
    public void loop() {

    }
}






