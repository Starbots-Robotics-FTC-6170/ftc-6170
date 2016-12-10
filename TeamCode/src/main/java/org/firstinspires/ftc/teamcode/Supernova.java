package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Supernova {
    DcMotor leftDrive;
    DcMotor rightDrive;

    public void init(HardwareMap hardwareMap) {
        leftDrive = hardwareMap.dcMotor.get("leftDrive");
        rightDrive = hardwareMap.dcMotor.get("rightDrive");
    }

    public void move(double left, double right) {
        leftDrive.setPower(left);
        rightDrive.setPower(right);
    }
}
