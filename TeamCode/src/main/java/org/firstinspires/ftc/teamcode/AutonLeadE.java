package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.ServoController;
import com.qualcomm.robotcore.util.ElapsedTime;

/**
 * Created by dcho0 on 11/13/2017.
 */
@Autonomous(name = "LeadEAuton", group = "Linear OpMode")
public class AutonLeadE extends LinearOpMode {


    //Declare OpMode Members
    private ElapsedTime runtime = new ElapsedTime();

    //Declare Motor Controllers
    private DcMotorController redMage;
    private DcMotorController dalek;

    //Declare Motors
    private DcMotor backLeftMotor; //Port 1 On Controller dalek
    private DcMotor backRightMotor; //Port 2 On Controller dalek
    private DcMotor frontLeftMotor; //Port 1 On Controller redMage
    private DcMotor frontRightMotor; //Port 2 On Controller redMage

    //Declare Servo Motor Controllers
    private ServoController sonicScrewdriver;

    //Declare Servo Motors
    private Servo leftServo; //Port 1 on Controller sonicScrewdriver
    private Servo rightServo; //Port 2 on Controller sonicScrewdriver


    @Override
    public void runOpMode() throws InterruptedException {
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        //HW Map Motors on Controller redMage
        frontLeftMotor = hardwareMap.dcMotor.get("frontLeftMotor");
        frontRightMotor = hardwareMap.dcMotor.get("frontRightMotor");

        //HW Map Motors on Controller dalek
        backLeftMotor = hardwareMap.dcMotor.get("backLeftMotor");
        backRightMotor = hardwareMap.dcMotor.get("backRightMotor");

        //HW Map Servos on Controller sonicScrewdriver
        leftServo = hardwareMap.servo.get("leftServo");
        rightServo = hardwareMap.servo.get("rightServo");

        //Reverse Direction of The Left Motors
        frontLeftMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        backLeftMotor.setDirection(DcMotorSimple.Direction.REVERSE);

        leftServo.setPosition(0.0);
        rightServo.setPosition(1.0);

        sleep(5000);

        leftServo.setPosition(0.5);
        rightServo.setPosition(0.5);

        waitForStart();
        runtime.reset();

        if (opModeIsActive())
            frontLeftMotor.setPower(1.0);
            frontRightMotor.setPower(1.0);
            backRightMotor.setPower(1.0);
            backLeftMotor.setPower(1.0);
            sleep(1000);

            frontLeftMotor.setPower(0.0);
            frontRightMotor.setPower(0.0);
            backLeftMotor.setPower(0.0);
            backRightMotor.setPower(0.0);
            sleep(500);

            frontLeftMotor.setPower(-1.0);
            frontRightMotor.setPower(1.0);
            backLeftMotor.setPower(-1.0);
            backRightMotor.setPower(1.0);
            sleep(400);





    }
}