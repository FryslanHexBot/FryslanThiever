package thiever.strategies.randoms;

import org.parabot.environment.api.utils.Time;
import org.parabot.environment.scripts.framework.SleepCondition;
import org.parabot.environment.scripts.framework.Strategy;
import org.rev317.min.api.methods.Inventory;
import org.rev317.min.api.methods.Npcs;
import org.rev317.min.api.methods.Players;
import org.rev317.min.api.methods.SceneObjects;
import org.rev317.min.api.wrappers.Npc;
import org.rev317.min.api.wrappers.SceneObject;

/**
 * Created with IntelliJ IDEA.
 * User: Piet Jetse
 * Date: 16-7-2014
 * Time: 16:07
 */
public class Jail implements Strategy{

    Npc[] jailer;

    @Override
    public boolean activate() {
        try {
            jailer = Npcs.getNearest(201);
            return jailer.length > 0 && jailer[0] != null;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public void execute() {
        try {
            SceneObject rock = SceneObjects.getClosest(2093,2092);
            if(Inventory.getCount(1266) > 0){
                if(!Inventory.isFull()){
                    if(rock != null){
                        if(Players.getMyPlayer().getAnimation() == -1){
                            rock.interact(0);
                            Time.sleep(new SleepCondition() {
                                @Override
                                public boolean isValid() {
                                    return Players.getMyPlayer().getAnimation() != -1;
                                }
                            },2000);
                        }
                    }
                }else{
                    jailer[0].interact(0);

                    Time.sleep(new SleepCondition() {
                        @Override
                        public boolean isValid() {
                            return !Inventory.isFull();
                        }
                    },5000);
                    Time.sleep(2500);
                }

            }else{
                jailer[0].interact(0);
                Time.sleep(new SleepCondition() {
                    @Override
                    public boolean isValid() {
                        return Inventory.getCount(1266) > 0;
                    }
                },5000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
