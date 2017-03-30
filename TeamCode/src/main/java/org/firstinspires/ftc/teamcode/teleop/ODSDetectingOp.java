package org.firstinspires.ftc.teamcode.teleop;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DeviceInterfaceModule;
import com.qualcomm.robotcore.hardware.OpticalDistanceSensor;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.subsystems.Drivetrain;

@TeleOp(name="ODSDetectingOp", group="TeleOp")

public class ODSDetectingOp extends LinearOpMode {

    Drivetrain drivetrain;
    OpticalDistanceSensor opticalDistanceSensor;
    DeviceInterfaceModule deviceInterfaceModule;

    @Override
    public void runOpMode() throws InterruptedException {
        drivetrain = new Drivetrain(hardwareMap.dcMotor.get("drive_front_left"), hardwareMap.dcMotor.get("drive_front_right"), hardwareMap.dcMotor.get("drive_back_left"), hardwareMap.dcMotor.get("drive_back_right"));
        deviceInterfaceModule = hardwareMap.deviceInterfaceModule.get("dim");

        opticalDistanceSensor = hardwareMap.opticalDistanceSensor.get("ods");
        opticalDistanceSensor.enableLed(true);

        telemetry.addData("Status", "Initialized");
        telemetry.update();

        waitForStart();

        while (opModeIsActive()) {
            //go over to the wall and read the wall's value, then use this value to do the wall following opmode
            telemetry.addData("Light Detected: ", opticalDistanceSensor.getLightDetected());
            telemetry.update();
        }
    }
}
