package thiever;


import org.parabot.environment.scripts.Category;
import org.parabot.environment.scripts.Script;
import org.parabot.environment.scripts.ScriptManifest;
import org.parabot.environment.scripts.framework.Strategy;
import org.rev317.min.api.events.MessageEvent;
import org.rev317.min.api.events.listeners.MessageListener;
import org.rev317.min.api.methods.Skill;
import thiever.strategies.TeleportToStals;
import thiever.strategies.Thief;
import thiever.strategies.randoms.BobsIsland;
import thiever.strategies.randoms.Jail;
import thiever.strategies.randoms.OldMan;
import thiever.strategies.randoms.SandwichLady;

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

    public class PKHThiever extends Script  implements MessageListener{

    ArrayList<Strategy> strategies = new ArrayList<>();
    private static final int startXP = Skill.THIEVING.getExperience();
    public static int gainedXP, gainedCash;

    @Override
    public boolean onExecute() {

        strategies.add(new BobsIsland());
        strategies.add(new OldMan());
        strategies.add(new SandwichLady());
        strategies.add(new Jail());

        strategies.add(new TeleportToStals());
        strategies.add(new Thief());

        provide(strategies);
        return true;
    }

    @Override
    public void messageReceived(MessageEvent message) {
        System.out.println(message.getMessage());
        if(message.getMessage().contains("You steal from the")){
            gainedCash += Integer.parseInt(message.getMessage().split(" ")[7].replace(",",""));
            gainedXP = Skill.THIEVING.getExperience() - startXP;
            System.out.println("We Gained : "+gainedXP +"XP and "+gainedCash+"GP");
        }
    }
}