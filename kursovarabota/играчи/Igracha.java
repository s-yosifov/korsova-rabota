package kursovarabota.играчи;

import kursovarabota.Scener;
import kursovarabota.SystoqnieNaIgrachite;
import kursovarabota.fieldsEngines.Investiciq;
import kursovarabota.fieldsEngines.Trap;
import kursovarabota.poletata.TrapVyzmojnosti;
import kursovarabota.играчи.GamePlayeer;

import java.util.ArrayList;

public class Igracha extends GamePlayeer {
    ArrayList<Investiciq> invests = new ArrayList<Investiciq>();

    public Igracha() {
        super();
    }

    @Override
    public Trap chooseTrap() {
        System.out.println("Избери си трап за поставяне: ");
        int choise;
        for(int i = 0; i < TrapVyzmojnosti.values().length; i++) {
            System.out.println((i+1) + ". " + TrapVyzmojnosti.values()[i]);
        }
        do {
            choise = Scener.scan.nextInt();
        }while (choise < 0 || choise > TrapVyzmojnosti.values().length);

        if (choise == 0) {
            return null;
        }
        return new Trap(TrapVyzmojnosti.values()[choise - 1], this);
    }

    @Override
    public void chooseInvest() {
        super.chooseInvest();
        SystoqnieNaIgrachite invEngine = new SystoqnieNaIgrachite();
        invEngine.tryInvestment(this);
    }
}
