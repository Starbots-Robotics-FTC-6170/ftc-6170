package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@Autonomous(name = "RedSupernovaCornerOnly", group = "Supernova")
public class RedSupernovaCornerOnly extends LinearOpMode {
    private double AWAY_FROM_WALL = 0.8;
    private double TURN_CORNER = 0.60;
    private double PARK_VORTEX = 0.80;

    private Supernova bot = new Supernova();

    //*Code to run ONCE when the driver hits INIT

    @Override
    public void runOpMode() {
        bot.init(hardwareMap, telemetry);

        waitForStart();

        bot.move(-AWAY_FROM_WALL, -AWAY_FROM_WALL);
        bot.move(-TURN_CORNER, TURN_CORNER);
        bot.move(-PARK_VORTEX, -PARK_VORTEX);
        bot.sweepAuto(true);
        sleep(2000);
        bot.sweepAuto(false);
    }

}