package com.example.pushyapp.Models.GameElements;

import com.example.pushyapp.Enums.Direction;

import junit.framework.TestCase;

import org.junit.Test;

/**
 * @Author Dirk Dresselhaus
 */
public class PlayerTest extends TestCase {

    @Test
    public void testTryUsingKey() {
        Player player = new Player(1,1);
        player.collectKey();

        assertEquals(true, player.tryUsingKey());
        assertEquals(false, player.tryUsingKey());
    }

    @Test
    public void testMove() {
        Player player = new Player(1,1);
        player.move(Direction.Left);

        assertEquals(0,player.getX());
    }
}