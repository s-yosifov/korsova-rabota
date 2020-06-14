package kursovarabota.fieldsEngines;


import kursovarabota.poletata.PoletaVyzmojnosti;

public class Pole {
    PoletaVyzmojnosti type;
    Trap trap;


    public Pole( PoletaVyzmojnosti type) {
        super();
        this.type = type;
    }

    public char getFieldLetter() {
        return this.type.toString().charAt(0);
    }

    public Trap getTrap() {
        return trap;
    }

    public void setTrap(Trap trap) {
        this.trap = trap;
    }
}
