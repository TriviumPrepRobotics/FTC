package org.firstinspires.ftc.teamcode;

    import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
    import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
    import com.qualcomm.robotcore.hardware.DcMotor;
    import com.qualcomm.robotcore.eventloop.opmode.Disabled;

@Autonomous(name = "Daniel Program3", group = "ProgramLesson3")
//@Disabled
public class SkeletonEncoderOpMode extends LinearOpMode{

    DcMotor Motor;

    @Override
    public void runOpMode() throws InterruptedException {
        Motor = hardwareMap.dcMotor.get("Motor");

        waitForStart();

        Motor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        double circumference =  3.14 * 3; //pi times wheel diameter
        double rotationsneeded = 18 / circumference; //length(in) divided by circumference
        int encoderdrivingtarget = (int)(rotationsneeded * 538); //rotations needed times motor ticks per revolution

        //encoderdrivingtarget = 1028

        Motor.setTargetPosition(encoderdrivingtarget);

        Motor.setPower(1);

        Motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        while (Motor.isBusy()) {
            //do nothing here
        }

        Motor.setPower(0);
    }



}
