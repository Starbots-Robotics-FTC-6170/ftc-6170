package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Supernova {
    private final long ENCODER_TO_METER = 1000;

    private DcMotor leftDriveM;
    private DcMotor rightDriveM;
    private DcMotor scissorsM;
    private DcMotor scoopM;
    private DcMotor sweepM;
    private DcMotor shootM;

    public void init(HardwareMap hardwareMap) {
        leftDriveM = hardwareMap.dcMotor.get("leftDrive");
        rightDriveM = hardwareMap.dcMotor.get("rightDrive");
        scissorsM = hardwareMap.dcMotor.get ("scissors");
        scoopM = hardwareMap.dcMotor.get("scoop");
        sweepM = hardwareMap.dcMotor.get("sweep");
        shootM = hardwareMap.dcMotor.get("shoot");
    }

    public void drive(double left, double right) {
        // set motor power based on desired movement
        leftDriveM.setPower(left);
        rightDriveM.setPower(right);
    }

    public double ease(int current, int start) {
        if (current > start)
            return 1.0;

        double ratio = 1.0 - current/start;

        return (1.0 - ratio)*(1.0 + ratio);
    }

    public void move(double left, double right) {
        // set motor power based on distance traveled
    }

    public void scissor(double power) {
        // code to move lift to position
    }

    public void sweep(double power) {
        // code to move sweeper
    }

    public void scoop (double power)  {
        // code to power scoop
    }

    public void shoot() {
        // code to shoot one ball
    }
}
