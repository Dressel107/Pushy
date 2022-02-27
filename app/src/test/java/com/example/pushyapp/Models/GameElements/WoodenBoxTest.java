package com.example.pushyapp.Models.GameElements;

import com.example.pushyapp.Enums.Direction;

import junit.framework.TestCase;

import org.junit.Test;

/**
 * @Author Dirk Dresselhaus
 */
public class WoodenBoxTest extends TestCase {

    @Test
    public void testMove() {
        WoodenBox woodenBox = new WoodenBox(1,1);
        woodenBox.move(Direction.Left);

        assertEquals(0, woodenBox.x);
    }
}