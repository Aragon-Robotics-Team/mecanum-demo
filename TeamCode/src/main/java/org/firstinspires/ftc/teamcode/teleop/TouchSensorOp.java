package org.firstinspires.ftc.teamcode.teleop;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.TouchSensor;

import org.firstinspires.ftc.teamcode.subsystems.Drivetrain;

public class TouchSensorOp extends OpMode {
    private Drivetrain drivetrain;
    private TouchSensor touchSensor;

    public void init() {
        drivetrain = new Drivetrain(hardwareMap.dcMotor.get("drive_front_left"),hardwareMap.dcMotor.get("drive_front_right"), hardwareMap.dcMotor.get("drive_back_left"),hardwareMap.dcMotor.get("drive_back_right"));
        touchSensor = hardwareMap.touchSensor.get("sensor_touch");
    }

    public void loop() {
        //mechanum drive algorithm
        drivetrain.mechanumDrive(-Math.pow(gamepad1.left_stick_x, 7), -Math.pow(gamepad1.left_stick_y, 7), Math.pow(gamepad1.right_stick_x, 7));

        if(touchSensor.isPressed()) {
            telemetry.addData("Touch", "Is Pressed");
        } else {
            telemetry.addData("Touch", "Is Not Pressed");
        }
        telemetry.update();

        telemetry.addData("G1_left_stick:", (gamepad1.left_stick_x*100)+ " " + gamepad1.left_stick_y*100);
        telemetry.addData("G1_right_stick:", (gamepad1.right_stick_x*100)+ " " + gamepad1.right_stick_y*100);
        telemetry.addData("intake", gamepad1.right_trigger);
        telemetry.addData("right_trigger:", gamepad1.right_bumper);
        telemetry.update();
    }

}
