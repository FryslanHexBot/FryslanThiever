package thiever.strategies;

import org.parabot.environment.api.utils.Time;
import org.parabot.environment.scripts.framework.Strategy;
import org.rev317.min.api.methods.Calculations;
import org.rev317.min.api.methods.Game;
import org.rev317.min.api.methods.Menu;
import org.rev317.min.api.wrappers.Tile;

/**
 * Created with IntelliJ IDEA.
 * User: Piet Jetse
 * Date: 16-7-2014
 * Time: 16:33
 */
public class TeleportToStals implements Strategy {


    @Override
    public boolean activate() {
        return Calculations.distanceTo(new Tile(2661, 3306)) > 20;
    }

    @Override
    public void execute() {
        int openDialogID = Game.getOpenBackDialogId();
        int dialogID = 2492;

        if (openDialogID != dialogID) {
            Menu.sendAction(315, 16, 0, 1170, 1);
            Time.sleep(500);
        }

        if (openDialogID == dialogID) {
            Menu.sendAction(315, 36257792, 227, 2494, 1);
            Time.sleep(2500);
        }


    }
}
