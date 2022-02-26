package com.example.pushyapp.Models.GameElements;

import junit.framework.TestCase;
/**
 * @Author Dirk Dresselhaus
 */
public class GoalTest extends TestCase {

    public void testTryInteract() {
        Goal goal = new Goal(1,1);
        Player player = new Player(2,2);
        assertEquals(true, goal.tryInteract(player));
    }
}