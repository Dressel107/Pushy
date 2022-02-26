package com.example.pushyapp.Models.GameElements;

import junit.framework.TestCase;
/**
 * @Author Dirk Dresselhaus
 */
public class GateTest extends TestCase {
    public void testTryInteract() {

        Gate gate = new Gate(1,1);
        Key key = new Key(2,2);
        Player player = new Player(3,3);


        gate.tryInteract(key);
        assertEquals(true, gate.getIsOpen());
        assertEquals(true, gate.tryInteract(player));

    }
}