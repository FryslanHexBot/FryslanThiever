package thiever.strategies;

import org.parabot.environment.api.utils.Time;
import org.parabot.environment.scripts.framework.SleepCondition;
import org.parabot.environment.scripts.framework.Strategy;
import org.rev317.min.api.methods.Players;
import org.rev317.min.api.methods.SceneObjects;
import org.rev317.min.api.wrappers.*;
import thiever.core.Stalls;

/**
 * Created with IntelliJ IDEA.
 * User: Piet Jetse
 * Date: 15-7-2014
 * Time: 15:17
 */
public class Thief implements Strategy {

    public static boolean switchStalls = true;
    public static SceneObject[] stall;

    @Override
    public boolean activate() {
        return true;
    }

    @Override
    public void execute() {

        org.rev317.min.api.wrappers.Character c = Players.getMyPlayer().getInteractingCharacter();
        if(c != null && c.getIndex() > 0){
            System.out.println("We are getting interacted by : Index : "+c.getIndex());
        }

        if(switchStalls){
            stall = SceneObjects.getNearest(Stalls.getBestStallID(), Stalls.getNextBestStall());
        }else {
            stall = SceneObjects.getNearest(Stalls.getBestStallID(), -1);
        }

        if (stall.length > 0 && stall[0] != null) {
            if (Players.getMyPlayer().getAnimation() == -1) {
                stall[0].interact(1);

                Time.sleep(new SleepCondition() {
                    @Override
                    public boolean isValid() {
                        return Players.getMyPlayer().getAnimation() != -1;
                    }
                } ,3000);

                Time.sleep(500);
            }
        }
        Time.sleep(100,200);
    }
}
