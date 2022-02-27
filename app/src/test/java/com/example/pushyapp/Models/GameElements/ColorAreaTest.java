package com.example.pushyapp.Models.GameElements;

import com.example.pushyapp.Enums.Color;

import junit.framework.TestCase;

import org.junit.jupiter.api.Test;

/**
 * @Author Dirk Dresselhaus
 */
public class ColorAreaTest extends TestCase {
    @Test
    public void testTryTake() {
        ColorSphere sphere1 = new ColorSphere(5,5, Color.Blue);
        ColorArea area1 = new ColorArea(4,4, Color.Blue);
        assertEquals(true,area1.tryTake(sphere1));
        assertEquals(false, sphere1.isVisible());

        ColorSphere sphere2 = new ColorSphere(5,5, Color.Blue);
        ColorArea area2 = new ColorArea(4,4, Color.Red);
        assertEquals(false, area2.tryTake(sphere2));
        assertEquals(true, sphere2.isVisible());
    }
}