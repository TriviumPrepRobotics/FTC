package org.firstinspires.ftc.teamcode;

        import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
        import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
        import com.qualcomm.robotcore.hardware.DcMotor;


@Autonomous(name = "Example Autonomous", group = "Example")
public class SkeletonOpMode extends LinearOpMode {

    DcMotor FrontLeft;
    DcMotor FrontRight;
    DcMotor BackLeft;
    DcMotor BackRight;

    @Override
    public void runOpMode() throws InterruptedException {
        FrontLeft = hardwareMap.dcMotor.get("Front Left");
        FrontRight = hardwareMap.dcMotor.get("Front Right");
        BackLeft = hardwareMap.dcMotor.get("Back Left");
        BackRight = hardwareMap.dcMotor.get("Back Right");

        waitForStart();

        FrontLeft.setPower(1);
        FrontRight.setPower(1);
        BackLeft.setPower(1);
        BackRight.setPower(1);

        sleep(5000);

        FrontLeft.setPower(0);
        FrontRight.setPower(0);
        BackLeft.setPower(0);
        BackRight.setPower(0);
    }
}
