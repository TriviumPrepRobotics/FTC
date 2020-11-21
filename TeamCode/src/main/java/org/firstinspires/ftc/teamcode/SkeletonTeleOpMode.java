package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Servo;
import org.firstinspires.ftc.robotcore.external.Func;
import com.qualcomm.robotcore.robot.Robot;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp(name = "SkeletonTeleOpMode", group = "")
public class SkeletonTeleOpMode extends LinearOpMode {

    private DcMotor FrontLeft;
    private DcMotor FrontRight;
    private DcMotor BackLeft;
    private DcMotor BackRight;

    @Override
    public void runOpMode() {
        FrontLeft = hardwareMap.dcMotor.get("Front Left");
        FrontLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        FrontRight = hardwareMap.dcMotor.get("Front Right");
        BackLeft = hardwareMap.dcMotor.get("Back Left");
        BackLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        BackRight = hardwareMap.dcMotor.get("Back Right");

        waitForStart();
        if (opModeIsActive()) {
            Double Power = 1.0;
            Double Power2 = 1.6;
            String Mode = "NormalDrive";

            while (opModeIsActive()) {
                    // Basic Movement - Tank Style \\
                    FrontLeft.setPower(gamepad1.left_stick_y/Power);
                    BackLeft.setPower(gamepad1.left_stick_y/Power);
                    FrontRight.setPower(gamepad1.right_stick_y/Power);
                    BackRight.setPower(gamepad1.right_stick_y/Power);
                telemetry.addData("FrontLeft Power", FrontLeft.getPower());
                telemetry.update();
                telemetry.addData("FrontRight Power", FrontRight.getPower());
                telemetry.update();
                telemetry.addData("BackLeft Power", BackLeft.getPower());
                telemetry.update();
                telemetry.addData("BackRight Power", BackRight.getPower());
                telemetry.update();
            }
        }
    }
}