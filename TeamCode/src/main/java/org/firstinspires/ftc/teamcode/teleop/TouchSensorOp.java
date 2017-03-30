package org.firstinspires.ftc.teamcode.teleop;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DeviceInterfaceModule;
import com.qualcomm.robotcore.hardware.TouchSensor;

import org.firstinspires.ftc.teamcode.subsystems.Drivetrain;

public class TouchSensorOp extends OpMode {
    private TouchSensor touchSensor;
    DeviceInterfaceModule deviceInterfaceModule;

    public void init() {
        touchSensor = hardwareMap.touchSensor.get("touch");
        deviceInterfaceModule = hardwareMap.deviceInterfaceModule.get("dim");
    }

    public void loop() {
      //mechanum drive algorithm
        if(touchSensor.isPressed()) {
            telemetry.addData("Touch Sensor ", "Is Pressed");
        } else {
            telemetry.addData("Touch Sensor ", "Is Not Pressed");
        }
        telemetry.update();
    }

}
