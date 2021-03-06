package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name = "Supernova Autonomous Template", group = "Template")
public class SupernovaAuto extends LinearOpMode {
    private Supernova bot = new Supernova();

    /*
     * Code to run ONCE when the driver hits INIT
     */
    @Override
    public void runOpMode() {
        bot.init(hardwareMap, telemetry);

        waitForStart();
    }
}
