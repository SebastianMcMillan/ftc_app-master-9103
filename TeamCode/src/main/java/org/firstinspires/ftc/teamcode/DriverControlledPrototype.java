package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;

/**
 * Created by Sebastian on 10/30/2017.
 */

@TeleOp(name = "Gamepad Test", group = "Linear OpMode")

public class DriverControlledPrototype extends LinearOpMode {

    //Declare OpMode Members
    private ElapsedTime runtime = new ElapsedTime();

    /*
    Don't Configure Yet. Wait until we have our first robot.
    DcMotor flMotor;
    DcMotor frMotor;
    DcMotor blMotor;
    DcMotor brMotor;
    */

    //Remove Once we get our first robot
    DcMotor leftMotor;
    DcMotor rightMotor;

    /*
    public void gamepadControls_Gamepad1() {

        while (gamepad1.left_stick_y > 0 || gamepad1.left_stick_y < 0)  {

            if (gamepad1.left_stick_x > 0) {
                leftMotor.setPower(-gamepad1.left_stick_y);
                rightMotor.setPower(-gamepad1.left_stick_x);
            }

            if (gamepad1.left_stick_x < 0) {
                leftMotor.setPower(-gamepad1.left_stick_x);
                rightMotor.setPower(-gamepad1.left_stick_y);
            }

            //if (gamepad1.left_stick_x == 0) {
                leftMotor.setPower(-gamepad1.left_stick_y);
                rightMotor.setPower(-gamepad1.left_stick_y);
            //}
        }
        while (gamepad1.left_stick_y == 0) {
            leftMotor.setPower(0.0);
            rightMotor.setPower(0.0);
        }
    }
    */

    @Override
    public void runOpMode() throws InterruptedException {
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        leftMotor = hardwareMap.dcMotor.get("leftMotor");
        rightMotor = hardwareMap.dcMotor.get("rightMotor");
        leftMotor.setDirection(DcMotorSimple.Direction.REVERSE);

        waitForStart();
        runtime.reset();
        while (true) {
            //gamepadControls_Gamepad1();
            while (gamepad1.left_stick_y > 0 || gamepad1.left_stick_y < 0)  {
                leftMotor.setPower(0.0);
                rightMotor.setPower(0.0);
            }
            sleep(2000);

            //Run until end of match (when driver presses stop)
            while (opModeIsActive()) {
                telemetry.addData("Status", "Running");
                telemetry.update();
                idle();
            }
        }

    }
}
