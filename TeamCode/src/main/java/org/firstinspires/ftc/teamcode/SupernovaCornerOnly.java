package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@Autonomous(name = "SupernovaCornerOnly", group = "Supernova")
public class SupernovaCornerOnly extends LinearOpMode {
    private final double AWAY_FROM_WALL = 0.8;
    private final double TURN_CORNER = 0.40;
    private final double PARK_VORTEX = 0.80;

    private Supernova bot = new Supernova();

    //*Code to run ONCE when the driver hits INIT

    @Override
    public void runOpMode() {
        bot.init(hardwareMap, telemetry); // Initialize the robot

        waitForStart(); // Waits between initialization and match start

        bot.move(-AWAY_FROM_WALL, -AWAY_FROM_WALL); // go backward
        bot.move(TURN_CORNER, -TURN_CORNER); // turn right
        bot.move(-PARK_VORTEX, -PARK_VORTEX); // go backward
        bot.sweepAuto(true); // turn on sweep
        sleep(2000); // wait 2 seconds
        bot.sweepAuto(false); // turn off sweep
    }
}
