package thiever.strategies.randoms;

import org.parabot.environment.api.utils.Time;
import org.parabot.environment.scripts.framework.Strategy;
import org.rev317.min.api.methods.Npcs;
import org.rev317.min.api.wrappers.Npc;

/**
 * Created with IntelliJ IDEA.
 * User: Piet Jetse
 * Date: 14-8-2014
 * Time: 23:09
 */
public class InteractingRandoms implements Strategy {

    private Npc antiRandom;
    private final int[] RANDOMS = {410, 1091, 3117, 3022, 3351, 409};

    @Override
    public boolean activate() {
        try {
            for (Npc n : Npcs.getNearest(RANDOMS)) {
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
            antiRandom.interact(0);
            Time.sleep(1500);
            System.out.println("Sandwich lady/Old man random has been completed");
        }
    }
}
