package kursovarabota.играчи;

import kursovarabota.fieldsEngines.Investiciq;
import kursovarabota.fieldsEngines.IzborNaShans;
import kursovarabota.fieldsEngines.Krajbata;
import kursovarabota.fieldsEngines.Trap;
import kursovarabota.poletata.KrajbaVyzmojnosti;

import java.util.ArrayList;
import java.util.List;

public abstract class GamePlayeer {
    int onField;
    double money;
    List<Investiciq> investments = new ArrayList<Investiciq>();
    List<Trap> activeTraps = new ArrayList<Trap>();
    Krajbata steal;

    public void setMoney(double money) {
        this.money = money;
    }

    public List<Trap> getActiveTraps() {
        return activeTraps;
    }

    public GamePlayeer() {
        super();
        this.onField = 0;
        this.money = 1000;
    }

    public int getOnField() {
        return onField;
    }

    public void setOnField(int onField) {
        this.onField = onField;
    }

    public void moveForward(int fieldsToMove) {
        onField = (onField + fieldsToMove) % 20;
    }

    public void addInvestment(Investiciq investment) {
        this.investments.add(investment);
    }

    public List<Investiciq> getInvestments() {
        return investments;
    }

    public void addActiveTrap(Trap trap) {
        activeTraps.add(trap);
    }

    public double getMoney() {
        return money;
    }

    public abstract Trap chooseTrap();

    public void chooseInvest() {
        if (steal != null && steal.getType() == KrajbaVyzmojnosti.Zalojnici) {
            money += 100;
        }
    }

    public void partyHard() {
        money -= 50;
    }

    public void chance() {
        IzborNaShans chanceGen = new IzborNaShans();
        money += chanceGen.getChance().getChanceBenifit();

        if (this.steal != null && this.steal.getType() == KrajbaVyzmojnosti.ZavladqvaneNaSveta) {
            money += 100;
        }
    }

    public void steal() {
        if (steal != null && steal.getType() == KrajbaVyzmojnosti.GolemiqBankovObir) {
            money += 100;
        }
    }

    public Krajbata getSteal() {
        return steal;
    }

    public void setSteal(Krajbata steal) {
        this.steal = steal;
    }

    public void addMoney(double quantity) {
        this.money += quantity;
    }

    @Override
    public String toString() {
        return "Поле: " + onField + ", пари: " + money;
    }
}
