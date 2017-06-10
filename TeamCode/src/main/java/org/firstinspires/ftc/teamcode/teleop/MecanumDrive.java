package org.firstinspires.ftc.teamcode.teleop;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.subsystems.Drivetrain;

/*
 *
 * CREATED BY CHLOE, 2/9/17
 */

@com.qualcomm.robotcore.eventloop.opmode.TeleOp(name="Drive: MecanumDrive", group="Drive")
public class MecanumDrive extends OpMode {

    private Drivetrain drivetrain;

    public void init() {
        drivetrain = new Drivetrain(hardwareMap.dcMotor.get("drive_front_left"),hardwareMap.dcMotor.get("drive_front_right"), hardwareMap.dcMotor.get("drive_back_left"),hardwareMap.dcMotor.get("drive_back_right"));
    }

    public void loop() {
        //mecanum drive algorithm
        drivetrain.mechanumDrive(-Math.pow(gamepad1.left_stick_x, 9), -Math.pow(gamepad1.left_stick_y, 9), Math.pow(gamepad1.right_stick_x, 9));

        telemetry.addData("G1_left_stick:", (gamepad1.left_stick_x*100)+ " " + gamepad1.left_stick_y*100);
        telemetry.addData("G1_right_stick:", (gamepad1.right_stick_x*100)+ " " + gamepad1.right_stick_y*100);
        telemetry.update();
    }
}