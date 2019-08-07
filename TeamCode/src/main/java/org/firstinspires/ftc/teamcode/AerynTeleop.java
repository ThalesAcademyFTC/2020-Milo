package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

/**
 * Created by dcrenshaw on 4/7/19.
 * Clasp is a basic, bare-bones teleop designed to run on top of Anvil.
 */

public class AerynTeleop extends OpMode {

    private Anvil robot;
    public void init() { robot = new Anvil(hardwareMap, Anvil.Drivetrain.MECHANUM, telemetry); }
    public void loop() {

    }
}
