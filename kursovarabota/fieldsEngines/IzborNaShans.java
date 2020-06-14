package kursovarabota.fieldsEngines;

import kursovarabota.KutiqtaSIgrata.Zarove;
import kursovarabota.poletata.ShansVyzmojnosti;

public class IzborNaShans {
    public Shans getChance() {
        Zarove zarove = new Zarove();
        int diceNumber = zarove.Roll(10);

        if (diceNumber % 2 == 0) {
            //generate positive
            int chance = zarove.Roll(100);
            return new Shans(getChanceByDice(chance, true));

        } else {
            //generate negative
            int chance = zarove.Roll(100);
            return new Shans(getChanceByDice(chance, false));
        }
    }

    private ShansVyzmojnosti getChanceByDice(int dice, boolean positive) {
        if (positive) {
            if (dice >= 1 && dice <= 39) {
                return ShansVyzmojnosti.GolemiteNadejdi;
            } else if (dice >= 40 && dice <= 65) {
                return ShansVyzmojnosti.Lolita;
            } else if (dice >= 65 && dice <= 79) {
                return ShansVyzmojnosti.Gordost_I_Predrazsydyci;
            } else if (dice >=80 && dice <= 94) {
                return ShansVyzmojnosti.PovelitelqNaMuhite;
            } else {
                return ShansVyzmojnosti.Hobit;
            }
        } else {
            if (dice >=1 && dice<=39) {
                return ShansVyzmojnosti.nosht_1001;
            } else if (dice >= 40 && dice <= 65) {
                return ShansVyzmojnosti.BalNaFei;
            } else if (dice >= 65 && dice <= 79) {
                return ShansVyzmojnosti.VoinaIMir;
            } else if (dice >= 80 && dice <= 94) {
                return ShansVyzmojnosti.Prestaplenie_I_Narushenie;
            } else {
                return ShansVyzmojnosti.GrozdoveNaGneva;
            }
        }
    }

    public Shans getPositiveChance() {
        Zarove zarove = new Zarove();
        int chance = zarove.Roll(100);
        return new Shans(getChanceByDice(chance, true));
    }

    public Shans getNegativeChance() {
        Zarove zarove = new Zarove();
        int chance = zarove.Roll(100);
        return new Shans(getChanceByDice(chance, false));
    }
}
