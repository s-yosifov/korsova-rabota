package kursovarabota.fieldsEngines;

import kursovarabota.fieldsEngines.Krajbata;
import kursovarabota.poletata.KrajbaVyzmojnosti;

import java.util.Random;

public class StealRandom {
    public Krajbata getRandomSteal() {
        Random rand = new Random();

        int stype = rand.nextInt(3);

        if (stype == 0) {
            return new Krajbata(KrajbaVyzmojnosti.ZavladqvaneNaSveta);
        } else if (stype == 1) {
            return new Krajbata(KrajbaVyzmojnosti.Zalojnici);
        } else {
            return new Krajbata(KrajbaVyzmojnosti.GolemiqBankovObir);
        }
    }
}
