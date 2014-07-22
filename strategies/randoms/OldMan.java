package thiever.strategies.randoms;

import org.parabot.environment.api.utils.Time;
import org.parabot.environment.scripts.framework.Strategy;
import org.rev317.min.api.methods.Npcs;
import org.rev317.min.api.methods.Players;
import org.rev317.min.api.wrappers.Npc;

/**
 * Created with IntelliJ IDEA.
 * User: Piet Jetse
 * Date: 15-7-2014
 * Time: 15:04
 */
public class OldMan implements Strategy {

    static Npc oldMan;

    @Override
    public boolean activate() {

        try {
            Npc[] oldMan = Npcs.getNearest(410);
            if (oldMan != null) {
                for (Npc i : oldMan) {
                    if (i != null && Players.getMyPlayer().getInteractingCharacter().equals(i)) {
                        OldMan.oldMan = i;
                        return true;
                    }
                }
            }
            return false;
        } catch (Exception e) {
           return false;
        }
    }

    @Override
    public void execute() {

        oldMan.interact(1);
        Time.sleep(2000);
    }
}