package thiever.strategies.randoms;

import org.parabot.environment.scripts.framework.Strategy;
import org.rev317.min.api.methods.Npcs;
import org.rev317.min.api.wrappers.Npc;

/**
 * Created with IntelliJ IDEA.
 * User: Piet Jetse
 * Date: 14-8-2014
 * Time: 23:17
 */
public class Genie implements Strategy {
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
            if (antiRandom.getDef().getId() == 3022 || antiRandom.getDef().getId() == 3351 || antiRandom.getDef().getId() == 409) {
                System.exit(0);
                System.out.println("A mod called a Genie random onto you.\n" +
                        "The client was closed to protect your account.");
            }
        }
    }
}
