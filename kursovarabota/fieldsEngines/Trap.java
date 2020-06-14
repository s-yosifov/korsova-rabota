package kursovarabota.fieldsEngines;

import kursovarabota.играчи.GamePlayeer;
import kursovarabota.poletata.TrapVyzmojnosti;

public class Trap {
    TrapVyzmojnosti type;
    GamePlayeer createdByPlayer;

    public Trap(TrapVyzmojnosti type, GamePlayeer createdByPlayer) {
        super();
        this.type = type;
        this.createdByPlayer = createdByPlayer;
    }

    public TrapVyzmojnosti getType() {
        return type;
    }

    public GamePlayeer getCreatedByPlayer() {
        return createdByPlayer;
    }
    public static int getMinInvest(TrapVyzmojnosti type) {
        if (type == TrapVyzmojnosti.Revisiq) {
            return 100;
        } else if (type == TrapVyzmojnosti.Razvod) {
            return 200;
        } else if (type == TrapVyzmojnosti.PROPAGANDA) {
            return 100;
        } else if (type == TrapVyzmojnosti.Proglejdane) {
            return 50;
        } else {
            return 100;
        }
    }
}