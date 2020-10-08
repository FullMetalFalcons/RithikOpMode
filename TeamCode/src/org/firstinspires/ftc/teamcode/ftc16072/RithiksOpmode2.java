package org.firstinspires.ftc.teamcode.ftc16072;


import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;






@TeleOp(name = "Rithik'sOpmode2", group = "ftc16072")
public class RithiksOpmode2 extends OpMode {
    private MecanumDrive mecanumDrive = new MecanumDrive();
    private double[] distances;

    // Code to run ONCE when the driver hits INIT
    @Override
    public void init() {
        mecanumDrive.init(hardwareMap);
    }

    // Always return the right side of the angle (i.e. always positive)
    private double GetTurnedAngle(double currentHeading, double startHeading)
    {
        double RightAngle = 0;
        if (currentHeading < startHeading) {
            RightAngle = 360 - (startHeading - currentHeading);
        } else {
            RightAngle = currentHeading - startHeading;
        }
        return RightAngle;
    }

    // Code to run REPEATEDLY after the driver hits PLAY but before they hit STOP
    @Override
    public void loop() {


        double forward = 0;
        double strafe = 0;
        double rotate = 0;

        distances = mecanumDrive.getDistanceCm();
        telemetry.addData("distance fwd", distances[0]);
        telemetry.addData("distance right", distances[1]);
        //telemetry.addData("Turn Degree", GetTurnedAngle());

        //dpad movement control
        if (gamepad1.dpad_down) {
            forward = -1;
        }
        if (gamepad1.dpad_up) {
            forward = 1;
        }
        if (gamepad1.dpad_right) {
            strafe = 1;
        }
        if (gamepad1.dpad_left) {
            strafe = -1;
        }




        //Rotation with X and B
        boolean leftrotate = gamepad1.x;
        boolean rightrotate = gamepad1.b;
        double currentrotate = mecanumDrive.getHeading(AngleUnit.DEGREES);
        double rotate90 = currentrotate +90;

        if (leftrotate && rightrotate) {

        } else {
            if (leftrotate) {
                rotate = -1;
              
            } else {
                if (rightrotate) {
                    rotate = 1;
                }
            }
        }
        mecanumDrive.driveMecanum(forward, strafe, rotate);



    }
}