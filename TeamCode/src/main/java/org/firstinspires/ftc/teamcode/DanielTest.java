package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous(name = "Daniel Test", group = "")
public class DanielTest extends LinearOpMode {
    DcMotor TestMotor;
    DcMotor TestMotor2;

    @Override
    public void runOpMode() throws InterruptedException {

        TestMotor = hardwareMap.dcMotor.get("Test Motor");
        TestMotor2 = hardwareMap.dcMotor.get("Test Motor2");

        waitForStart();

        TestMotor.setPower(1);
        TestMotor2.setPower(-1);

        sleep(120000);
    }



}
