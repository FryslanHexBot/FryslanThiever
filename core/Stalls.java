package thiever.core;

import org.rev317.min.api.methods.Skill;

/**
 * Created with IntelliJ IDEA.
 * User: Piet Jetse
 * Date: 15-7-2014
 * Time: 15:51
 */
public enum Stalls {
    BAKERY_STALL(0, 20, 500, 600, 2561),
    SILK_STALL(20, 35, 1200, 1200, 2560),
    FUR_STALL(35, 50, 2000, 2000, 2563),
    SILVER_STALL(50, 65, 4500, 2500, 2565),
    SPICE_STALL(65, 75, 7000, 3500, 2564),
    GEM_STALL(75, Integer.MAX_VALUE, 15000, 5000, 2562);

    private int slvl;
    private int elvl;
    private int xp;
    private int cash;
    private int id;

    private Stalls(int slvl, int elvl, int xp, int cash, int id) {
        this.slvl = slvl;
        this.elvl = elvl;
        this.xp = xp;
        this.cash = cash;
        this.id = id;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static int getBestStallID() {
        for (Stalls stalls : Stalls.values()) {
            if (Skill.THIEVING.getLevel() >= stalls.slvl && Skill.THIEVING.getLevel() < stalls.elvl) {
                return stalls.id;
            }
        }
        return -1;
    }

    public static int getNextBestStall() {
        for (int i = 0; i < Stalls.values().length; i++) {
            if (Skill.THIEVING.getLevel() >= Stalls.values()[i].slvl && Skill.THIEVING.getLevel() < Stalls.values()[i].elvl) {
                if (i > 0) {
                    return Stalls.values()[i - 1].id;
                } else {
                    return Stalls.values()[i].id;
                }
            }
        }
        return -1;
    }
}
