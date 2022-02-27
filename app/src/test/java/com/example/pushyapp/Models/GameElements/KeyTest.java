package com.example.pushyapp.Models.GameElements;

import junit.framework.TestCase;

import org.junit.Test;

/**
 * @Author Dirk Dresselhaus
 */
public class KeyTest extends TestCase {

    @Test
    public void testTryInteract() {
        Key key = new Key(1,1);
        Gate gate = new Gate (2,2);
        Player player = new Player(3,3);

        key.tryInteract(gate);
        assertEquals(true, gate.getIsOpen());

        key.tryInteract(player);
        assertEquals(1, player.getKeysCount());
    }

}