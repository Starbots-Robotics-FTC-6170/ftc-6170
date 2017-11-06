package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Supernova {
    private final double METER_TO_ENCODER = 7000;
    private final double EASE_DRIVE = 0.1;
    private final double POWER_DRIVE = 0.5;
    private final double EPSILON = 0.03;

    private DcMotor leftDriveM;
    private DcMotor rightDriveM;

    private Telemetry telemetry;

    public void init(HardwareMap hardwareMap, Telemetry t) {
        leftDriveM = hardwareMap.dcMotor.get("Left");
        rightDriveM = hardwareMap.dcMotor.get("Right");

        telemetry = t;

        // log data
        telemetry.addData("status", "inited");
        telemetry.update();
    }

    public void drive(double left, double right) {
        // log data
        telemetry.addData("drive:left", left);
        telemetry.addData("drive:right", right);
        telemetry.update();

        // set motor power based on desired movement
        leftDriveM.setPower(-left*POWER_DRIVE);
        rightDriveM.setPower(right*POWER_DRIVE);
    }

    public double ease(double current, double start) {
        if (current > start)
            return 1.0;

        double ratio = 1.0 - current/start;

        return (1.0 - ratio)*(1.0 + ratio);
    }

    public void move(double left, double right) {
        // log data
        telemetry.addData("move:left", left);
        telemetry.addData("move:right", right);
        telemetry.update();

        // set motor power based on distance traveled
        int startLeft = -leftDriveM.getCurrentPosition();
        int startRight = rightDriveM.getCurrentPosition();

        // set initial power
        double leftPower = POWER_DRIVE;
        double rightPower = POWER_DRIVE;

        // loop until motors are no longer powered
        while (leftPower != 0.0 || rightPower != 0.0) {
            // get relative position of motors
            double leftPos = (-leftDriveM.getCurrentPosition() - startLeft)/METER_TO_ENCODER;
            double rightPos = (rightDriveM.getCurrentPosition() - startRight)/METER_TO_ENCODER;

            // get remaining distance for motors
            double leftRemaining = Math.abs(left - leftPos);
            double rightRemaining = Math.abs(right - rightPos);

            // stop motors when they are close enough to target
            if (leftRemaining < EPSILON)
                leftPower = 0.0;
            if (rightRemaining < EPSILON)
                rightPower = 0.0;

            // set power based on easing
            leftDriveM.setPower(-ease(leftRemaining, EASE_DRIVE)*Math.copySign(leftPower, left));
            rightDriveM.setPower(ease(rightRemaining, EASE_DRIVE)*Math.copySign(rightPower, right));
        }
    }
}
