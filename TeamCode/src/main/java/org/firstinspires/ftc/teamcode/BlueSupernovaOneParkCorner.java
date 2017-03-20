package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@Autonomous(name = "Blue Supernova One Park Corner", group = "Supernova")
public class BlueSupernovaOneParkCorner extends LinearOpMode {
    private double WALL_TO_CENTER_VORTEX = 0.80;
    private double TURN_TOWARD_HOOP = 0.20;
    private double BUMP_BALL = 0.40;
    private double TURN_AWAY_FROM_HOOP = 0.21;
    private double FORWARD_TOWARD_CORNER_VORTEX = 0.70;
    private double TURN_TOWARD_CORNER_VORTEX = 0.25;
    private double DRIVE_ONTO_CORNER_VORTEX = 0.9;

    private Supernova bot = new Supernova();

    /*
     * Code to run ONCE when the driver hits INIT
     */
    @Override
    public void runOpMode() {
        bot.init(hardwareMap, telemetry);

        waitForStart();

        bot.move(-WALL_TO_CENTER_VORTEX, -WALL_TO_CENTER_VORTEX);
        bot.move(-TURN_TOWARD_HOOP, TURN_TOWARD_HOOP);
        bot.move(BUMP_BALL, BUMP_BALL);
        bot.move(-TURN_AWAY_FROM_HOOP, TURN_AWAY_FROM_HOOP);
        bot.move(-FORWARD_TOWARD_CORNER_VORTEX, -FORWARD_TOWARD_CORNER_VORTEX);
        bot.move(TURN_TOWARD_CORNER_VORTEX, -TURN_TOWARD_CORNER_VORTEX);
        bot.move(-DRIVE_ONTO_CORNER_VORTEX, -DRIVE_ONTO_CORNER_VORTEX);
    }
}
