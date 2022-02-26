package com.example.pushyapp.Models.GameElements;

import com.example.pushyapp.Enums.Direction;

import junit.framework.TestCase;

/**
 * @Author Dirk Dresselhaus
 */
public class PlayerTest extends TestCase {

    public void testTryUsingKey() {
        Player player = new Player(1,1);
        player.collectKey();

        assertEquals(true, player.tryUsingKey());
        assertEquals(false, player.tryUsingKey());
    }

    public void testMove() {
        Player player = new Player(1,1);
        player.move(Direction.Left);

        assertEquals(0,player.getX());
    }
}