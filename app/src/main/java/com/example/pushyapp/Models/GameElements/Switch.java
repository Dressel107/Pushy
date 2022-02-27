package com.example.pushyapp.Models.GameElements;

import com.example.pushyapp.R;

/**
 * Definiert den Aufbau eines Schalters.
 * @author Dirk Dresselhaus
 */
public class Switch extends GameElement implements Interactable {
    private static final int res = R.drawable.lever;
    private static final int res2 = R.drawable.lever_on;

    /**
     * Gibt an, ob der Schalter ein- oder ausgeschaltet ist.
     * @author Dirk Dresselhaus
     */
    private boolean isOn;

    /**
     * Gibt das SwitchGate an, auf welches der Schalter Auswirkungen haben soll.
     * @author Dirk Dresselhaus
     */
    private SwitchGate gate;

    public Switch(int x, int y, SwitchGate gate) {
        super(x, y, res);
        this.gate = gate;
        this.isOn = false;
    }

    /**
     * Öffnet, bzw. schließt das zu-ihm-gehörige Schaltertor.
     * @param element Das Element, mit dem interagiert werden soll.
     * @return Gibt true zurück, da dieses Element von allen anderen Objekten betretbar ist.
     * @author Dirk Dresselhaus
     */
    @Override
    public boolean tryInteract(GameElement element) {
        this.changeRes();
        if (gate.isOpen()) {
            gate.close();
        }
        else {
            gate.open();
        }

        return true;
    }

    /**
     * Setzt die Ressource je nachdem, ob der Schalter ein- oder ausgeschaltet ist.
     * @author Dirk Dresselhaus
     */
    private void changeRes(){
        if(isOn){
            isOn = false;
            this.setRes(res);
        }else{
            isOn = true;
            this.setRes(res2);
        }
    }

    /**
     * Setzt den Zustand des Elements zurück.
     * @author Dirk Dresselhaus
     */
    public void reset(){
        super.reset();
        this.isOn = false;
        this.setRes(res);
    }
}
