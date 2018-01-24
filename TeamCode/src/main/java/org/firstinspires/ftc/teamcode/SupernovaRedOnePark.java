package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name = "SupernovaRedOnePark", group = "Supernova")
public class SupernovaRedOnePark extends LinearOpMode{
    private Supernova bot = new Supernova();

    /*
     * Code to run ONCE when the driver hits INIT
     */
    @Override
    public void runOpMode() {
        bot.init(hardwareMap, telemetry);

        waitForStart();

        bot.move(1.1,1.1);
        bot.move(0.3,-0.3);
        bot.move(0.1,0.1);
        bot.grab(0);

        waitForStart();

        bot.move(1.1,1.1);
        bot.move(-0.3,0.3);
        bot.move(0.1,0.1);
        bot.grab(0);

        waitForStart();

        bot.move(.85,.85);
        bot.grab(0);
    }
}
