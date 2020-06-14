package kursovarabota.играчи;

import kursovarabota.fieldsEngines.Investiciq;
import kursovarabota.fieldsEngines.Trap;
import kursovarabota.poletata.InvesticiqVyzmojnosti;
import kursovarabota.poletata.TrapVyzmojnosti;
import kursovarabota.играчи.GamePlayeer;

import java.util.Random;


public class Bot extends GamePlayeer {
    public Bot() {
        super();
    }

    @Override
    public Trap chooseTrap() {
        // decide trap
        Random rand = new Random();
        if (rand.nextInt(10) >=7 || money < 50) {
            return null;
        }

        //choose trap
        int trapType;
        do {
            trapType = rand.nextInt(5);
        } while (Trap.getMinInvest(TrapVyzmojnosti.values()[trapType]) > money);
        money -= Trap.getMinInvest(TrapVyzmojnosti.values()[trapType]);
        return new Trap(TrapVyzmojnosti.values()[trapType], this);
    }

    @Override
    public void chooseInvest() {
        super.chooseInvest();
        if (money < 50) {
            return;
        }

        int investType;
        Random rand = new Random();
        Investiciq inv;
        do {
            investType = rand.nextInt(6);
            inv = new Investiciq(InvesticiqVyzmojnosti.values()[investType]);
        } while (inv.getMinInvestment() > money);

        investments.add(inv);
    }
}