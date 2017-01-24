package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

@Autonomous(name = "Supernova Shoot One Park Corner", group = "Supernova")
public class SupernovaShootOneParkCorner extends OpMode {
    private double WALL_TO_CENTER_VORTEX = 0.80;
    private double TURN_TOWARD_HOOP = 0.20;
    private double MOVE_TO_HOOP = 0.20;
    private double BUMP_BALL = 0.10;
    private double TURN_AWAY_FROM_HOOP = 0.21;
    private double FORWARD_TOWARD_CORNER_VORTEX = 0.90;
    private double TURN_TOWARD_CORNER_VORTEX = 0.17;
    private double DRIVE_ONTO_CORNER_VORTEX = 0.68;

    private Supernova bot = new Supernova();

    /*
     * Code to run ONCE when the driver hits INIT
     */
    @Override
    public void init() {
        bot.init(hardwareMap, telemetry);
    }

    /*
     * Code to run REPEATEDLY after the driver hits INIT, but before they hit PLAY
     */
    @Override
    public void init_loop() {
    }

    /*
     * Code to run ONCE when the driver hits PLAY
     */
    @Override
    public void start() {
        bot.move(WALL_TO_CENTER_VORTEX, WALL_TO_CENTER_VORTEX);
        bot.move(TURN_TOWARD_HOOP, -TURN_TOWARD_HOOP);
        bot.move(BUMP_BALL, BUMP_BALL);
        bot.move(MOVE_TO_HOOP, MOVE_TO_HOOP);
        bot.move(TURN_AWAY_FROM_HOOP, -TURN_AWAY_FROM_HOOP);
        bot.move(FORWARD_TOWARD_CORNER_VORTEX, FORWARD_TOWARD_CORNER_VORTEX);
        bot.move(TURN_TOWARD_CORNER_VORTEX, -TURN_TOWARD_CORNER_VORTEX);
        bot.move(DRIVE_ONTO_CORNER_VORTEX, DRIVE_ONTO_CORNER_VORTEX);

    }

    /*
     * Code to run REPEATEDLY after the driver hits PLAY but before they hit STOP
     */
    @Override
    public void loop() {
    }

    /*
     * Code to run ONCE after the driver hits STOP
     */
    @Override
    public void stop() {
    }
}