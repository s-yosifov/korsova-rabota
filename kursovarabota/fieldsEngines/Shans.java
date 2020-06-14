package kursovarabota.fieldsEngines;

import kursovarabota.poletata.ShansVyzmojnosti;

public class Shans {
    ShansVyzmojnosti chanceType;
    public Shans(ShansVyzmojnosti chanceType){
        this.chanceType = chanceType;
    }

    public ShansVyzmojnosti getChanceType() {
        return this.chanceType;
    }

    public String getChanceText() {
        String positive = "Днес е радостен ден за вас.";
        String negative = "Ти изтегли късата клечка.";
        if (chanceType == ShansVyzmojnosti.nosht_1001) {
            return negative.concat("Вдигате толкова голям купон, че" +
                    "не знаете къде се намирате на" +
                    "следващата седмица. С мъка" +
                    "установявате, че телевизорът Ви е" +
                    "откраднат.");
        } else if (chanceType == ShansVyzmojnosti.BalNaFei) {
            return negative.concat( "Вие сте баща на три абитуриентки," +
                    "бъдете готови за стабилни" +
                    "разходи.");
        }else if (chanceType == ShansVyzmojnosti.VoinaIMir) {
            return negative.concat("Най-добрият Ви служител" +
                    "получава повиквателна за" +
                    "казармата. Губите обучен" +
                    "персонал.");
        }else if (chanceType == ShansVyzmojnosti.Prestaplenie_I_Narushenie) {
            return negative.concat("На връщане от супермаркета," +
                    "чудовище се опитва да ви изяде." +
                    "Справяте се с неприятеля," +
                    "използвайки карате, но се налага" +
                    "да пишете обяснения, които водят" +
                    "до пропускане на важна среща и" +
                    "загуба на бизнес партньор.");
        }else if (chanceType == ShansVyzmojnosti.GrozdoveNaGneva) {
            return negative.concat("Част от бизнесите Ви фалират," +
                    "заради задаваща се епидемия от" +
                    "потна треска.");
        }else if (chanceType == ShansVyzmojnosti.GolemiteNadejdi) {
            return positive.concat("Осиновявате група" +
                    "сирачета, за да си вдигнете" +
                    "социалното реноме." +
                    "Социалните мрежи са във" +
                    "възторг, получавате" +
                    "окуражителни дарения от" +
                    "обществото.");
        }else if (chanceType == ShansVyzmojnosti.Lolita) {
            return positive.concat("Хващате си младо гадже" +
                    "малка котка с големи" +
                    "възможности. Получавате" +
                    "вечното уважение на" +
                    "кварталните пичове, както" +
                    "и легендарен статус на" +
                    "вечен играч.");
        }else if (chanceType == ShansVyzmojnosti.Gordost_I_Predrazsydyci) {
            return positive.concat("Напускате университета и" +
                    "ставате милионер. Честито!");
        }else if (chanceType == ShansVyzmojnosti.PovelitelqNaMuhite) {
            return positive.concat("Тийнейджъри представят" +
                    "гениална идея за" +
                    "рационализиране на" +
                    "производствените" +
                    "мощности. Получавате" +
                    "стабилен бонус.");
        } else {
            return positive.concat("Наемате джудже за личен" +
                    "асистент, обществото е" +
                    "уверено че междувидовата" +
                    "сегрегация е в историята." +
                    "Уважението към вас е" +
                    "безгранично.");
        }
    }

    public double getChanceBenifit() {
        if (chanceType == ShansVyzmojnosti.nosht_1001) {
            return -50;
        } else if (chanceType == ShansVyzmojnosti.BalNaFei) {
            return -100;
        }else if (chanceType == ShansVyzmojnosti.VoinaIMir) {
            return -150;
        }else if (chanceType == ShansVyzmojnosti.Prestaplenie_I_Narushenie) {
            return -200;
        }else if (chanceType == ShansVyzmojnosti.GrozdoveNaGneva) {
            return -250;
        }else if (chanceType == ShansVyzmojnosti.GolemiteNadejdi) {
            return 50;
        }else if (chanceType == ShansVyzmojnosti.Lolita) {
            return 100;
        }else if (chanceType == ShansVyzmojnosti.Gordost_I_Predrazsydyci) {
            return 150;
        }else if (chanceType == ShansVyzmojnosti.PovelitelqNaMuhite) {
            return 200;
        } else {
            return 250;
        }
    }
}