package kursovarabota.KutiqtaSIgrata;
import kursovarabota.fieldsEngines.Pole;
import kursovarabota.poletata.PoletaVyzmojnosti;
import kursovarabota.играчи.Bot;
import kursovarabota.играчи.Igracha;

import java.util.Random;


public class IgrataSeIgrae {
    Pole[] boardFields = new Pole[20];
    Zarove zarove;
    Igracha player;
    Bot computer;

    public IgrataSeIgrae() {
        zarove = new Zarove();
        player = new Igracha();
        computer = new Bot();
        generateFields();
    }

    public Pole getField(int index) {
        return boardFields[index];
    }

    public void generateFields() {

        //Start
        boardFields[0] = new Pole(PoletaVyzmojnosti.START);
        //Traps
        Random rand = new Random();

        for (int i = 0; i < 7; i++) {
            int index = 0;
            while(boardFields[index] != null) {
                index = rand.nextInt(19) + 1;
            }

            boardFields[index] = new Pole(PoletaVyzmojnosti.TRAP);
        }

        for (int i = 0; i < 3; i++) {
            int index = 0;
            while(boardFields[index] != null) {
                index = rand.nextInt(19) + 1;
            }

            boardFields[index] = new Pole(PoletaVyzmojnosti.INVEST);
        }

        for (int i = 0; i < 3; i++) {
            int index = 0;
            while(boardFields[index] != null) {
                index = rand.nextInt(19) + 1;
            }

            boardFields[index] = new Pole(PoletaVyzmojnosti.PARTY_HARD);
        }

        for (int i = 0; i < 3; i++) {
            int index = 0;
            while(boardFields[index] != null) {
                index = rand.nextInt(19) + 1;
            }

            boardFields[index] = new Pole(PoletaVyzmojnosti.CHANCE);
        }

        for (int i = 0; i < 3; i++) {
            int index = 0;
            while(boardFields[index] != null) {
                index = rand.nextInt(19) + 1;
            }

            boardFields[index] = new Pole(PoletaVyzmojnosti.STEAL);
        }
    }
    public void printBoard() {
        //9 -15
        for (int i = 10; i < 18; i++) {
            System.out.print("|" + boardFields[i].getFieldLetter() + "| ");
        }
        System.out.println();
        //9 i 19
        System.out.print("|" + boardFields[9].getFieldLetter() + "| ");
        for(int i = 0; i < 6; i++) {
            System.out.print("    ");
        }
        System.out.print("|" + boardFields[18].getFieldLetter() + "| ");
        System.out.println();
        //8 i 20
        //9 i 19
        System.out.print("|" + boardFields[8].getFieldLetter() + "| ");
        for(int i = 0; i < 6; i++) {
            System.out.print("    ");
        }
        System.out.print("|" + boardFields[19].getFieldLetter() + "| ");
        System.out.println();
        //7 - 0
        for (int i = 7; i >= 0; i--) {
            System.out.print("|" + boardFields[i].getFieldLetter() + "| ");
        }

        System.out.println();
    }
}
