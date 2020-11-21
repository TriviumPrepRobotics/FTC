package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import org.firstinspires.ftc.robotcore.external.Func;
import com.qualcomm.robotcore.robot.Robot;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp(name = "OpModeBoys_TheCorrectOne", group = "")
public class LegendaryChickens extends LinearOpMode {

    private DcMotor FrontRight;
    private DcMotor FrontLeft;
    private DcMotor BackLeft;
    private DcMotor BackRight;
    private Double Power = 1.75;

    public void StrafeLeft() {
        for (int i = 4; i > 0; i--){
            FrontLeft.setPower(gamepad1.left_trigger/Power/i);
            FrontRight.setPower(-gamepad1.left_trigger/Power/i);
            BackLeft.setPower(-gamepad1.left_trigger/Power/i);
            BackRight.setPower(gamepad1.left_trigger/Power/i);
        }
    }

    @Override
    public void runOpMode() {
        FrontRight = hardwareMap.dcMotor.get("Front Right");
        FrontLeft = hardwareMap.dcMotor.get("Front Left");
        BackLeft = hardwareMap.dcMotor.get("Back Left");
        BackRight = hardwareMap.dcMotor.get("Back Right");

        FrontLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        BackLeft.setDirection(DcMotorSimple.Direction.REVERSE);

        waitForStart();
        if (opModeIsActive()) {
            String Mode = "Normal";

            while (opModeIsActive()) {
                String Current = "Stopped";
                /* Strafing Stuffs */
                /* Strafe Right (Right Trigger) */
                if (Current == "Stopped") {
                    Current = "Strafe";
                    FrontLeft.setPower(-gamepad1.right_trigger/Power);
                    FrontRight.setPower(gamepad1.right_trigger/Power);
                    BackLeft.setPower(gamepad1.right_trigger/Power);
                    BackRight.setPower(-gamepad1.right_trigger/Power);
                    Current = "Stopped";
                };
                /* Strafe Left (Left Trigger)  */
                if (Current == "Stopped") {
                    Current = "Strafe";
                    FrontLeft.setPower(gamepad1.left_trigger/Power);
                    FrontRight.setPower(-gamepad1.left_trigger/Power);
                    BackLeft.setPower(-gamepad1.left_trigger/Power);
                    BackRight.setPower(gamepad1.left_trigger/Power);
                    Current = "Stopped";
                };
                /* Basic Movement (Tank Style) */
                if (Current == "Stopped") {
                    Current = "Basic Drive";
                    if (gamepad1.right_bumper){
                        FrontLeft.setPower(gamepad1.left_stick_y);
                        FrontRight.setPower(gamepad1.right_stick_y);
                        BackLeft.setPower(gamepad1.left_stick_y);
                        BackRight.setPower(gamepad1.right_stick_y);
                    } else {
                        FrontLeft.setPower(gamepad1.left_stick_y / Power);
                        FrontRight.setPower(gamepad1.right_stick_y / Power);
                        BackLeft.setPower(gamepad1.left_stick_y / Power);
                        BackRight.setPower(gamepad1.right_stick_y / Power);
                    }
                    Current = "Stopped";
                }

                telemetry.addData("FrontLeft Power", FrontLeft.getPower());
                telemetry.addData("FrontRight Power", FrontRight.getPower());
                telemetry.addData("BackLeft Power", BackLeft.getPower());
                telemetry.addData("BackRight Power", BackRight.getPower());
                telemetry.update();

            }
        }
    }
}
