package com.example.pushyapp.Models.GameElements;

import junit.framework.TestCase;

import org.junit.Test;

/**
 * @Author Dirk Dresselhaus
 */
public class SwitchTest extends TestCase {

    @Test
    public void testTryInteract() {
        SwitchGate gate = new SwitchGate (2,2);
        Switch s = new Switch(1,1, gate);
        Player player = new Player(1,1);

        s.tryInteract(player);
        assertEquals(true,gate.isOpen());
        s.tryInteract(player);
        assertEquals(false,gate.isOpen());
    }
}