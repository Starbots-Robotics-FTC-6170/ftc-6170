package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name = "Supernova Tank", group = "Supernova")
public class SupernovaTank extends OpMode {
    private Supernova bot = new Supernova();

    /*
     * Code to run ONCE when the driver hits INIT
     */
    @Override
    public void init() {
        bot.init(hardwareMap);
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
        bot.move(-gamepad1.left_stick_y, -gamepad1.right_stick_y);

        if (gamepad2.a)
            bot.scissor(5.0);

        bot.sweep(gamepad2.right_trigger - gamepad2.left_trigger);
    }

    /*
     * Code to run ONCE after the driver hits STOP
     */
    @Override
    public void stop() {
    }
}
