package kursovarabota;

import kursovarabota.fieldsEngines.Investiciq;
import kursovarabota.poletata.InvesticiqVyzmojnosti;
import kursovarabota.играчи.Igracha;

import java.util.Arrays;
import java.util.Random;


public class SystoqnieNaIgrachite {
    public void tryInvestment(Igracha player) {
        //Generate type
        InvesticiqVyzmojnosti[] types = new InvesticiqVyzmojnosti[3];

        for (int i = 0; i < 3; i++) {
            InvesticiqVyzmojnosti genType;
            while ((genType = generateInvestType()) != null) {
                if (!Arrays.asList(types).contains(genType)) {
                    types[i] = genType;
                    break;
                }
            }
        }


        System.out.println("Инжестирайте разумно и изберете компания:");
        //make player choose types
        for (int i = 0; i < 3; i++) {
            Investiciq investToChoose = new Investiciq(types[i]);

            System.out.println("(" + (i+1) + ")" +
                    investToChoose.getType().toString() + " | " +
                    "Инвестиция : " + investToChoose.getMinInvestment() +
                    " Печалба : " + investToChoose.getCoefficient()
            );
        }
        //I don't want to invest
        System.out.println("(N)Не ми се инжестриа повече ");
        //input
        int choise =  Scener.scan.nextInt();
        if (choise > 0) {
            //Choose sum of investment
            double investSum;
            Investiciq inv = new Investiciq(types[choise - 1]);
            do {
                System.out.println("Въведете сума за инвестиция >= " + inv.getMinInvestment());
                investSum = Scener.scan.nextDouble();
            } while (investSum < inv.getMinInvestment());

            inv.setInvestSum(investSum);
            //Add Investment

            player.addInvestment(inv);
            player.addMoney(-investSum);
        }
    }

    private InvesticiqVyzmojnosti generateInvestType() {
        Random rand = new Random();

        int investnumber = rand.nextInt(InvesticiqVyzmojnosti.values().length);
        return InvesticiqVyzmojnosti.values()[investnumber];
    }
}
