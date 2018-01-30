package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name = "SupernovaBlueOnePark", group = "Template")
public class SupernovaBlueOnePark extends LinearOpMode {
    private Supernova bot = new Supernova();

    /*
     * Code to run ONCE when the driver hits INIT
     */
    @Override
    public void runOpMode() {
        bot.init(hardwareMap, telemetry);

        waitForStart();

        bot.move(1.1,1.1);
        bot.move(-0.3,0.3);
        bot.move(0.1,0.1);
        bot.grab(0);
    }
}
