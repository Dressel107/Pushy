package com.example.pushyapp.Models.GameElements;

import junit.framework.TestCase;

import org.junit.Test;

/**
 * @Author Dirk Dresselhaus
 */
public class GoalTest extends TestCase {

    @Test
    public void testTryInteract() {
        Goal goal = new Goal(1,1);
        Player player = new Player(2,2);
        assertEquals(true, goal.tryInteract(player));
    }
}