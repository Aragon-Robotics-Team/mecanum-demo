// Tell Java whta this is
package org.firstinspires.ftc.teamcode.teleop;

// Import existing OpMode code from Qualcomm
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

// Import drive-train code from FTC
import org.firstinspires.ftc.teamcode.subsystems.Drivetrain;

/*
 *
 * CREATED BY CHLOE, 2/9/17
 */

// Name the OpMode and place it with other "Drive" modes
@com.qualcomm.robotcore.eventloop.opmode.TeleOp(name="Drive: MecanumDrive", group="Drive")
// Creates MecanumDrive with Opmode as a template 
public class MecanumDrive extends OpMode {
    
    // Initiate a drivetrain
    private Drivetrain drivetrain;
    // Initiate motorspeed variable to 1
    private final double MOTORSPEED = 1.0;
    
    // Add the 4 wheels to the drivetrain
    public void init() {
        drivetrain = new Drivetrain(hardwareMap.dcMotor.get("drive_front_left"),hardwareMap.dcMotor.get("drive_front_right"), hardwareMap.dcMotor.get("drive_back_left"),hardwareMap.dcMotor.get("drive_back_right"));
    }

    public void loop() {
        // Mechanum drive algorithm based on equation y = x^7, Left-stick x = left/right, Left-stick y = front/left, Right-stick x = turn left/right
        drivetrain.mechanumDrive(-Math.pow(gamepad1.left_stick_x, 7), -Math.pow(gamepad1.left_stick_y, 7), Math.pow(gamepad1.right_stick_x, 7));
        
        // Debugging
        telemetry.addData("G1_left_stick:", (gamepad1.left_stick_x*100)+ " " + gamepad1.left_stick_y*100);
        telemetry.addData("G1_right_stick:", (gamepad1.right_stick_x*100)+ " " + gamepad1.right_stick_y*100);
        telemetry.addData("intake", gamepad1.right_trigger);
        telemetry.addData("right_trigger:", gamepad1.right_bumper);
    }
}
