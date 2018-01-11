package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Supernova {
    private final double METER_TO_ENCODER = 7000;
    private final double EASE_DRIVE = 0.1;
    private final double POWER_DRIVE = 1.0;
    private final double CLAW_OPEN = 0.0;
    private final double CLAW_CLOSE = 0.4;
    private final double EPSILON = 0.03;
    private final double POWER_LIFT = 1.0;

    private DcMotor leftDrive;
    private DcMotor rightDrive;
    private DcMotor lift;
    private Servo leftArm;
    private Servo rightArm;

    private Telemetry telemetry;

    public void init(HardwareMap hardwareMap, Telemetry t) {
        leftDrive = hardwareMap.dcMotor.get("Left");
        rightDrive = hardwareMap.dcMotor.get("Right");
        leftArm = hardwareMap.servo.get("LeftArm");
        rightArm = hardwareMap.servo.get("RightArm");
        lift = hardwareMap.dcMotor.get ("LiftClaw");

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
        leftDrive.setPower(-left*POWER_DRIVE);
        rightDrive.setPower(right*POWER_DRIVE);
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
        int startLeft = -leftDrive.getCurrentPosition();
        int startRight = rightDrive.getCurrentPosition();

        // set initial power
        double leftPower = POWER_DRIVE;
        double rightPower = POWER_DRIVE;

        // loop until motors are no longer powered
        while (leftPower != 0.0 || rightPower != 0.0) {
            // get relative position of motors
            double leftPos = (-leftDrive.getCurrentPosition() - startLeft) / METER_TO_ENCODER;
            double rightPos = (rightDrive.getCurrentPosition() - startRight)/METER_TO_ENCODER;

            // get remaining distance for motors
            double leftRemaining = Math.abs(left - leftPos);
            double rightRemaining = Math.abs(right - rightPos);

            // stop motors when they are close enough to target
            if (leftRemaining < EPSILON)
                leftPower = 0.0;
            if (rightRemaining < EPSILON)
                rightPower = 0.0;

            // set power based on easing
            leftDrive.setPower(-ease(leftRemaining, EASE_DRIVE)*Math.copySign(leftPower, left));
            rightDrive.setPower(ease(rightRemaining, EASE_DRIVE)*Math.copySign(rightPower, right));
        }
    }

    public void grab(double percent) {
        telemetry.addData("grab:percentage", percent);
        telemetry.update();
        if (percent > 0.5) {
            leftArm.setPosition(0.5);
            rightArm.setPosition(0.0);
        }
        else {
            leftArm.setPosition(0.4);
            rightArm.setPosition(0.8);
        }
    }

    public void lift(double liftclaw) {

    }
}
