package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@Autonomous(name = "Sweeper", group = "Supernova")
public class Sweeper extends LinearOpMode {


    private Supernova bot = new Supernova();

    /*
     * Code to run ONCE when the driver hits INIT
     */
    @Override
    public void runOpMode() {
        bot.init(hardwareMap, telemetry);

        waitForStart();

        bot.sweepAuto(true);
        sleep(2000);
        bot.sweepAuto(false);

    }
}