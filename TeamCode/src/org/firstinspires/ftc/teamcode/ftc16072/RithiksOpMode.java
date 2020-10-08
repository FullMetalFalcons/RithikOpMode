package org.firstinspires.ftc.teamcode.ftc16072;


import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;




@TeleOp(name = "Rithik's driving opmode", group = "ftc16072")
public class RithiksOpMode extends OpMode {
    private MecanumDrive mecanumDrive = new MecanumDrive();
    private double[] distances;

    // Code to run ONCE when the driver hits INIT
    @Override
    public void init() {
        mecanumDrive.init(hardwareMap);
    }

    // Code to run REPEATEDLY after the driver hits PLAY but before they hit STOP
    @Override
    public void loop() {
        //dpad movement control
        if (gamepad1.dpad_down) gamepad1.left_stick_y = 1000;
        if (gamepad1.dpad_up) gamepad1.left_stick_y = -1000;
        if (gamepad1.dpad_right) gamepad1.left_stick_x = 1000;
        if (gamepad1.dpad_left) gamepad1.left_stick_x = -1000;

        if (gamepad1.x) gamepad1.right_stick_x = -1;
        if (gamepad1.b) gamepad1.right_stick_x = -100;

        double forward = gamepad1.left_stick_y * -1; //The y direction on the gamepad is reversed idk why
        double strafe = gamepad1.left_stick_x;
        double rotate = gamepad1.right_stick_x;

        mecanumDrive.driveMecanum(forward, strafe, rotate);
        distances = mecanumDrive.getDistanceCm();
        telemetry.addData("distance fwd", distances[0]);
        telemetry.addData("distance right", distances[1]);


    }
}