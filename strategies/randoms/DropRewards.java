package thiever.strategies.randoms;

import org.parabot.environment.api.utils.Time;
import org.parabot.environment.scripts.framework.SleepCondition;
import org.parabot.environment.scripts.framework.Strategy;
import org.rev317.min.api.methods.Inventory;

/**
 * Created with IntelliJ IDEA.
 * User: Piet Jetse
 * Date: 14-8-2014
 * Time: 23:13
 */
public class DropRewards implements Strategy {
    @Override
    public boolean activate() {
        return Inventory.getCount(6963) > 0;
    }

    @Override
    public void execute() {
        if(Inventory.getCount(6963) > 0){
            Inventory.getItems(6963)[0].drop();
            Time.sleep(new SleepCondition() {
                @Override
                public boolean isValid() {
                    return Inventory.getCount(6963) == 0;
                }
            }, 2500);
        }
    }
}
