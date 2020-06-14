package kursovarabota.KutiqtaSIgrata;

import kursovarabota.KutiqtaSIgrata.IgrataSeIgrae;
import kursovarabota.KutiqtaSIgrata.Zarove;
import kursovarabota.fieldsEngines.StealRandom;
import kursovarabota.играчи.Bot;
import kursovarabota.играчи.GamePlayeer;
import kursovarabota.играчи.Igracha;

import java.io.IOException;


public class GolqmataIgra {
    IgrataSeIgrae gameboard = new IgrataSeIgrae();
    GamePlayeer[] players;
    int turn;
    Zarove zarove = new Zarove();


    public GolqmataIgra() {

        players = new GamePlayeer[2];

        players[0] = new Igracha();
        players[1] = new Bot();
    }

    public void Play() throws IOException {
        //Print board
        gameboard.printBoard();
        //Begin game
        while(true) {
            //Runtime.getRuntime().exec("cls");
            System.out.println("Играч " + (turn + 1) + " Хвърля зара ...");
            //roll the dice and move
            int move = zarove.Roll(2);

            //Check if start hit
            if (players[turn].getOnField() + move >= 20) {
                calculateStart();

                //Check if player lost
                if (players[turn].getMoney() <=0) {
                    System.out.println("Играч " + (turn + 1) + " Изгуби играта !!!");
                    break;
                }
            }


            players[turn].setOnField((players[turn].getOnField() + move) % 20);
            //choose action
            switch (gameboard.getField(players[turn].getOnField()).getFieldLetter()) {
                case 'T':
                    trap();
                    break;
                case 'I' :
                    invest();
                    break;
                case 'P' :
                    partyHard();
                    break;
                case 'C':
                    chance();
                    break;
                case 'S' :
                    steal();
                    break;
            }
            //print players info
            for (int i = 0; i < players.length; i++) {
                System.out.println(players[i].toString());
            }
            //change player turn
            if (turn < players.length - 1) {
                turn++;
            } else {
                turn = 0;
            }
        }
    }

    public IgrataSeIgrae getGameboard() {
        return gameboard;
    }

    public void setGameboard(IgrataSeIgrae gameboard) {
        this.gameboard = gameboard;
    }

    private void trap() {
        //Set Trap on board
        int currentfield = players[turn].getOnField();
        if (gameboard.getField(currentfield).getTrap() == null) {
            gameboard.getField(currentfield).setTrap(players[turn].chooseTrap());
        } else {
            players[turn].addActiveTrap(gameboard.getField(currentfield).getTrap());
        }
    }

    private void invest() {
        players[turn].chooseInvest();
    }

    private void partyHard() {
        players[turn].partyHard();
    }

    private void chance() {
        players[turn].chance();
    }

    private void steal() {
        StealRandom stealR = new   StealRandom();
        players[turn].setSteal(stealR.getRandomSteal());
        players[turn].steal();
    }

    private void calculateStart() {
        for (int i = 0; i < players.length; i++) {
            //activate investements
            for (int j = 0; j < players[i].getInvestments().size(); j++) {
                players[i].addMoney(players[i].getInvestments().get(j).getOutcome());
            }
        }
    }
}