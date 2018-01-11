package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name = "Supernova Tank", group = "Supernova")
public class SupernovaTank extends OpMode {
    private Supernova bot = new Supernova();
    private double lasttime = 0;
    private float claw = 0;
    private double lift = 0;

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
    }

    /*
     * Code to run REPEATEDLY after the driver hits PLAY but before they hit STOP
     */
    @Override
    public void loop() {
        double deltatime = time-lasttime;

        bot.drive(-gamepad1.left_stick_y, -gamepad1.right_stick_y);
        bot.grab(gamepad2.right_trigger);
        bot.lift(-gamepad2.right_stick_y);

        lasttime = time;
    }

    /*
     * Code to run ONCE after the driver hits STOP
     */
    @Override
    public void stop() {
    }
}

