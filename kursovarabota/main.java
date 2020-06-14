package kursovarabota;


import kursovarabota.KutiqtaSIgrata.GolqmataIgra;

import java.io.IOException;

public class main {

    public static void main(String[] args) {
        GolqmataIgra engine = new GolqmataIgra();

        try {
            engine.Play();
        } catch (IOException e) {

            e.printStackTrace();
        }
    }

}
