package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.Range;

/**
 * This is NOT an opmode.
 *
 */
public class Drivetrain {

    // Declaration of motors for Holonomic Drive
    public DcMotor frontLeft;
    public DcMotor frontRight;
    public DcMotor backLeft;
    public DcMotor backRight;

    /* Constructor */
    public Drivetrain(DcMotor frontLeft, DcMotor frontRight, DcMotor backLeft, DcMotor backRight) {
        this.frontLeft = frontLeft;
        this.frontRight = frontRight;
        this.backLeft = backLeft;
        this.backRight = backRight;

        frontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        //set to motors to run using encoders for even speed
        frontLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        frontRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        //set wheel direction (reverse if on the right)
        frontLeft.setDirection(DcMotor.Direction.FORWARD);
        frontRight.setDirection(DcMotor.Direction.REVERSE);
        backLeft.setDirection(DcMotor.Direction.FORWARD);
        backRight.setDirection(DcMotor.Direction.REVERSE);
    }

    //finds the angle of each motor relative to the direction of movement
    public double relativeAngle (double motorAngle, double movementAngle, int motorPosition){
        //1440: number of ticks per rotation on the encoder
        //3.75: diameter of wheels
        //18.75: approximation of the diameter of the bot's path
        return
                motorAngle + movementAngle - (2*Math.PI * ((motorPosition/1440)*(Math.PI*3.75))/Math.PI*18.75);
    }

    public void mechanumDrive(double movX, double movY, double rotation) {

        //assign motor powers their inputs based on position on the robot
        double forwardLeftPower = Range.clip((-1*movX - movY), -1, 1) - rotation;
        double forwardRightPower = -1*(Range.clip((-1*movX + movY), -1, 1) - rotation);
        double backLeftPower = Range.clip((movX - movY), -1, 1) - rotation;
        double backRightPower = -1*(Range.clip((movX + movY), -1, 1) - rotation);

        frontLeft.setPower(forwardLeftPower);
        frontRight.setPower(forwardRightPower);
        backLeft.setPower(backLeftPower);
        backRight.setPower(backRightPower);
    }

    public void stop() {
        mechanumDrive(0, 0, 0);
    }
}