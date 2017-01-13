package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Supernova {
    private final long ENCODER_TO_METER = 1000;
    private final double EASE_DRIVE = 2000;

    private DcMotor leftDriveM;
    private DcMotor rightDriveM;
    private DcMotor scissorsM;
    private DcMotor scoopM;
    private DcMotor sweepM;
    private DcMotor shootM;

    private Telemetry telemetry;

    public void init(HardwareMap hardwareMap, Telemetry t) {
        leftDriveM = hardwareMap.dcMotor.get("Left");
        rightDriveM = hardwareMap.dcMotor.get("Right");
        scissorsM = hardwareMap.dcMotor.get ("Scissor");
        scoopM = hardwareMap.dcMotor.get("Scoop");
        sweepM = hardwareMap.dcMotor.get("Sweep");
        shootM = hardwareMap.dcMotor.get("Shoot");

        telemetry = t;
    }

    public void drive(double left, double right) {
        // set motor power based on desired movement
        leftDriveM.setPower(left);
        rightDriveM.setPower(right);

        // log data
        telemetry.addData("drive:left", left);
        telemetry.addData("drive:right", right);
    }

    public double ease(int current, int start) {
        if (current > start)
            return 1.0;

        double ratio = 1.0 - current/start;

        return (1.0 - ratio)*(1.0 + ratio);
    }

    public void move(double left, double right) {
        // set motor power based on distance traveled

        // log data
        telemetry.addData("move:left", left);
        telemetry.addData("move:right", right);
    }

    public void scissor(double power) {
        // code to move lift to position

        // log data
        telemetry.addData("scissor:power", power);
    }

    public void sweep(double power) {
        // code to move sweeper

        // log data
        telemetry.addData("sweep:power", power);
    }

    public void scoop(double power)  {
        // code to power scoop

        // log data
        telemetry.addData("scoop:power", power);
    }

    public void shoot() {
        // code to shoot one ball

        // log data
        telemetry.addData("shoot", "go!");
    }
}
