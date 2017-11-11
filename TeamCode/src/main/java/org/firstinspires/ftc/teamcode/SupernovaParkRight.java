package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name = "Supernova Park Right", group = "Autonomous")
public class SupernovaParkRight extends LinearOpMode {
    private Supernova bot = new Supernova();

    /*
     * Code to run ONCE when the driver hits INIT
     */
    @Override
    public void runOpMode() {
        bot.init(hardwareMap, telemetry);

        waitForStart();
        
        bot.drive(1,1);
        sleep(500);
        bot.drive(1,-1);
        sleep(2000);
        bot.drive(1,1);
        sleep(150);
    }
}
