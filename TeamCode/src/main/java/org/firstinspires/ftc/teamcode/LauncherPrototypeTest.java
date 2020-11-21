package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Servo;
import org.firstinspires.ftc.robotcore.external.Func;
import com.qualcomm.robotcore.robot.Robot;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp(name = "Launcher Prototype Test", group = "")
public class LauncherPrototypeTest extends LinearOpMode {

    private DcMotor TestMotor;
    private Servo TestServo;

    @Override
    public void runOpMode() {
        TestMotor = hardwareMap.dcMotor.get("Test Motor");
        TestServo = hardwareMap.servo.get("Test Servo");

        waitForStart();
        if (opModeIsActive()) {
            Double Power = 1.75;
            String Mode = "NormalDrive";

            while (opModeIsActive()) {
                if(gamepad1.right_trigger > 0.5) {
                    TestMotor.setPower(1);
                } else {
                    TestMotor.setPower(0);
                }

                if(gamepad1.left_trigger > 0.5) {
                    TestServo.setPosition(0);
                } else {
                    TestServo.setPosition(.45);
                }
            }
        }
    }
}