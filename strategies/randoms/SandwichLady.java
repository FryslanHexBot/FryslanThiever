package thiever.strategies.randoms;

import org.parabot.environment.api.utils.Time;
import org.parabot.environment.scripts.framework.Strategy;
import org.rev317.min.api.methods.Inventory;
import org.rev317.min.api.wrappers.Item;
import org.rev317.min.api.wrappers.Npc;

/**
 * Created with IntelliJ IDEA.
 * User: Piet Jetse
 * Date: 15-7-2014
 * Time: 14:44
 */

public class SandwichLady implements Strategy {

    static Npc sandwichLady;

    @Override
    public boolean activate() {

     /*   Npc[] sandwichLady = Npcs.getNearest(3117);
        if (sandwichLady != null) {
            for (Npc i : sandwichLady) {
                if (i != null && Players.getMyPlayer().getInteractingCharacter().equals(i)) {
                    SandwichLady.sandwichLady = i;
                    return true;
                }
            }
        }*/
        return false;
    }

    @Override
    public void execute() {

        sandwichLady.interact(1);
        Time.sleep(2000);
        Item[] sandwich = Inventory.getItems(6962);
        for (int x = 0; x < sandwich.length; x++) {
            sandwich[x].interact(1);
            Time.sleep(2500);
        }

    }
}
