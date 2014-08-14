package thiever.strategies.randoms;

import aio_pkhonor.core.Area;
import org.parabot.environment.api.utils.Time;
import org.parabot.environment.scripts.framework.SleepCondition;
import org.parabot.environment.scripts.framework.Strategy;
import org.rev317.min.api.methods.Npcs;
import org.rev317.min.api.methods.Players;
import org.rev317.min.api.methods.SceneObjects;
import org.rev317.min.api.wrappers.Npc;
import org.rev317.min.api.wrappers.SceneObject;
import org.rev317.min.api.wrappers.Tile;

/**
 * Created with IntelliJ IDEA.
 * User: Piet Jetse
 * Date: 14-8-2014
 * Time: 23:10
 */
public class BobsIsland implements Strategy {

    private Area bobsIsland = new Area(new Tile(2511, 4765), new Tile(2511, 4790), new Tile(2542, 4790), new Tile(2542, 4765));
    private Npc antiRandom;
    private int[] randoms = {410, 1091, 3117, 3022, 3351, 409};

    @Override
    public boolean activate() {
        try {
            for (Npc n : Npcs.getNearest(randoms)) {
                if (n.getLocation().distanceTo() < 2) {
                    antiRandom = n;
                    return true;
                }
            }

            return false;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void execute() {
        if (antiRandom != null) {
            if (antiRandom.getDef().getId() == 1091) {
                SceneObject[] portal = SceneObjects.getNearest(8987);
                for (SceneObject aPortal : portal) {
                    if (bobsIsland.contains(Players.getMyPlayer())) {
                        final SceneObject portal2 = aPortal;

                        aPortal.interact(0);

                        Time.sleep(new SleepCondition() {
                            @Override
                            public boolean isValid() {
                                return portal2.getLocation().distanceTo() < 2;
                            }

                        }, 7500);

                        Time.sleep(1000);
                    }
                }
                System.out.println("Bob's Island has been completed");
            }
        }
    }
}
