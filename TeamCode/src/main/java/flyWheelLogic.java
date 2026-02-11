import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

public class flyWheelLogic {
    private Servo leverArm;
    private DcMotorEx flyWheelServo;

    private ElapsedTime stateTimer = new ElapsedTime();

    private enum FlywheelState {
        IDLE,
        SPIN_UP,
        LAUNCH,
        RESET_ARM
    }

    private FlywheelState flywheelState;
    // ----------
    private double LEVERARM_CLOSE_ANGLE = 0;
    private double LEVERARM_OPEN_ANGLE = 90;
    private double LEVERARM_OPEN_TIME = 0.5;

    private double LEVERARM_CLOSE_TIME = 0.5;

    // ____--------- flywheel constants ---------

    private int shotsRemaining = 0;

    private double flyWheelVelocity = 0;

    private double MIN_FLYWHEEL_RPM = 800;

    private double TARGET_FLYWHEEL_RPM = 1.0;

    private double FLYWHEEL_MAX_SPINUP_TIME = 2;

    private void init(HardwareMap hwMap) {
        leverArm = hwMap.get(Servo.class, "servo");
        flyWheelServo = hwMap.get(DcMotorEx.class, "fw_servo");

        flywheelState = FlywheelState.IDLE;

        flyWheelServo.setVelocity(0);
        leverArm.setPosition(LEVERARM_CLOSE_ANGLE);
    }

    public void update() {
        switch (flywheelState) {
            case IDLE:
                if (shotsRemaining > 0) {
                    leverArm.setPosition(LEVERARM_CLOSE_ANGLE);
                    DcMotorEx.setVelocity(TARGET_FLYWHEEL_RPM);
                }
        }
    }
}
