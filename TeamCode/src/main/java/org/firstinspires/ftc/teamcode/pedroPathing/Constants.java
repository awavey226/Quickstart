package org.firstinspires.ftc.teamcode.pedroPathing;

import com.pedropathing.follower.Follower;
import com.pedropathing.follower.FollowerConstants;
import com.pedropathing.ftc.FollowerBuilder;
import com.pedropathing.paths.PathConstraints;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Constants {
    public static FollowerConstants followerConstants = new FollowerConstants().mass(); //Add in mass here in KG

    //Copy over mecanum constants here from the pedropathing tuning page
    //Then change the motor names and adjust the motor directions


    //Copy over pinport constants here from pedropathing tuning page
    //Add in offsets in inches, use values from CAD

    public static PathConstraints pathConstraints = new PathConstraints(0.99, 100, 1, 1);

    public static Follower createFollower(HardwareMap hardwareMap) {
        return new FollowerBuilder(followerConstants, hardwareMap)
                .pathConstraints(pathConstraints)
                //Add in mecanum drive constants here
                .build();
    }
}
