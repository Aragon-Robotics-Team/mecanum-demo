package org.firstinspires.ftc.teamcode.autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.OpticalDistanceSensor;
import com.qualcomm.robotcore.hardware.TouchSensor;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.subsystems.Drivetrain;

@Autonomous(name="WallFollowingOp", group="Autonomous")
public class WallFollowingOp extends LinearOpMode {

    Drivetrain drivetrain;
    OpticalDistanceSensor opticalDistanceSensor;
    //static double odsReadingRaw;
    //static double odsReadingLinear;
    private TouchSensor touchSensor;

    //PERFECT_VALUE equals to the value of white wall
    //we will know this value once we have read the value the light sensor gives us
    private static double PERFECT_VALUE = Double.parseDouble(null);

    @Override
    public void runOpMode() throws InterruptedException {
        drivetrain = new Drivetrain(hardwareMap.dcMotor.get("drive_front_left"),hardwareMap.dcMotor.get("drive_front_right"), hardwareMap.dcMotor.get("drive_back_left"),hardwareMap.dcMotor.get("drive_back_right"));
        opticalDistanceSensor = hardwareMap.opticalDistanceSensor.get("ods");
        touchSensor = hardwareMap.touchSensor.get("sensor_touch");

        telemetry.addData("Status", "Initialized");
        telemetry.update();

        waitForStart();

        while(opModeIsActive()) {

            while(opticalDistanceSensor.getLightDetected() == PERFECT_VALUE) {
                drivetrain.mechanumDrive(0, 1, 0);
            }

            while(opticalDistanceSensor.getLightDetected() != PERFECT_VALUE) {
                drivetrain.mechanumDrive(-1, 0, 0);
            }

            //if the touch sensor gets hit, back up by driving sideways to the right
            while(touchSensor.isPressed()) {
                drivetrain.mechanumDrive(1, 0, 0);
            }
        }
    }
}
