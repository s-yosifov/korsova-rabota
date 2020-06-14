package kursovarabota.KutiqtaSIgrata;


import java.util.Random;

public class Zarove {
    public int Roll(int sides) {
        Random rand = new Random();
        return rand.nextInt(sides - 1) + 1;
    }
}