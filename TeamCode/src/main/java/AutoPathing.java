import com.pedropathing.follower.Follower;
import com.pedropathing.geometry.BezierLine;
import com.pedropathing.geometry.Pose;
import com.pedropathing.paths.PathChain;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.pedropathing.util.Timer;
@Autonomous //oops
public class AutoPathing extends OpMode {
    private Follower follower;
    private Timer pathTimer, opModetimer;

    public enum PathState {
        DRIVE_STARTPOS_SHOOT_POS,
        SHOOT_PRELOAD
    }

    PathState pathState;

    private final Pose startPose = new Pose(21.003500583430576, 123.3325554259043, Math.toRadians(143));
    private final Pose shootPose = new Pose(71.91598599766628, 73.26021003500581, Math.toRadians(143));

    private PathChain driveStartPosShootPos;

    public void buildPaths() {
        driveStartPosShootPos = follower.pathBuilder()
                .addPath(new BezierLine(startPose, shootPose))
                .setLinearHeadingInterpolation(startPose.getHeading(), shootPose.getHeading())
                .build();
        //public void statePathUpdate{
    }


    @Override
    public void init() {
    }

    @Override
    public void loop() {
    }
}


