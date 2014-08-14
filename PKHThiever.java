package thiever;


import org.parabot.environment.scripts.Category;
import org.parabot.environment.scripts.Script;
import org.parabot.environment.scripts.ScriptManifest;
import org.parabot.environment.scripts.framework.Strategy;
import thiever.strategies.Teleport;
import thiever.strategies.Thief;
import thiever.strategies.randoms.*;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: Piet Jetse
 * Date: 15-7-2014
 * Time: 14:37
 */

@ScriptManifest(
        author = "Fryslan"
        , category = Category.THIEVING
        , description = "Steals From Stalls"
        , name = "Fryslan Stall Thiever"
        , version = 0.1
        , servers = {"PKHonor"})

    public class PKHThiever extends Script{

    ArrayList<Strategy> strategies = new ArrayList<>();

    @Override
    public boolean onExecute() {

        strategies.add(new BobsIsland());
        strategies.add(new InteractingRandoms());
        strategies.add(new DropRewards());
        strategies.add(new Genie());
        strategies.add(new Jail());

        strategies.add(new Teleport());
        strategies.add(new Thief());

        provide(strategies);
        return true;
    }
}