package thiever.strategies.randoms;

import org.parabot.environment.api.utils.Time;
import org.parabot.environment.scripts.framework.Strategy;
import org.rev317.min.api.methods.Npcs;
import org.rev317.min.api.methods.SceneObjects;
import org.rev317.min.api.wrappers.Npc;
import org.rev317.min.api.wrappers.SceneObject;
import org.rev317.min.api.wrappers.Tile;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: Piet Jetse
 * Date: 15-7-2014
 * Time: 15:05
 */
public class BobsIsland implements Strategy {

    private final SceneObject[] portal = SceneObjects.getNearest(8987);

    ArrayList<Tile> done = new ArrayList<>();

    @Override
    public boolean activate() {
        Npc[] bob = new Npc[0];
        try {
            bob = Npcs.getNearest(1091);

        } catch (Exception e) {
            return false;
        }
        return bob.length > 0 && bob[0].distanceTo() < 5;

    }

    @Override
    public void execute() {

        for( SceneObject p : portal){
            if( p.distanceTo() < 30) {
                System.out.println("interacting with portal");
                p.interact(0);
               // p.interact(1);
                Time.sleep( 3000);
            }
        }

    }
}
