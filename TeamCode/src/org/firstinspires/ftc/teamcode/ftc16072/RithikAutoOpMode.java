package org.firstinspires.ftc.teamcode.ftc16072;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import org.firstinspires.ftc.teamcode.ftc16072.Robot;
import virtual_robot.util.AngleUtils;

@Autonomous(name = "RithikAutoOpMode", group = "ftc16072")
public class RithikAutoOpMode  extends OpMode {

    private double[] distances;
    DcMotor motor1, motor2, motor3, motor4;

    @Override
    public void init() {}

    public void runOpMode(){
        motor1 = hardwareMap.dcMotor.get("back_left_motor");
        motor2 = hardwareMap.dcMotor.get("front_left_motor");
        motor3 = hardwareMap.dcMotor.get("front_right_motor");
        motor4 = hardwareMap.dcMotor.get("back_right_motor");
    }



    @Override
    public void loop() {
        telemetry.addData("distance fwd", distances[0]);
    }
}

