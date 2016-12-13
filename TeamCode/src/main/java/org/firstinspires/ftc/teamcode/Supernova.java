package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Supernova {
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

    public void move(double left, double right) {
        leftDriveM.setPower(left);
        rightDriveM.setPower(right);
    }

    public void scissor(double position) {
        // code to move lift to position
    }

    public void sweep(double power) {
        // code to move sweeper
    }

    public void shoot() {
        // code to shoot one ball
    }
}
