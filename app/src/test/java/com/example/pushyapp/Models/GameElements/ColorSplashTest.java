package com.example.pushyapp.Models.GameElements;

import com.example.pushyapp.Enums.Color;

import junit.framework.TestCase;
/**
 * @Author Dirk Dresselhaus
 */
public class ColorSplashTest extends TestCase {

    public void testTryInterarct() {
        ColorSplash splash = new ColorSplash(1,1, Color.Red);
        ColorSphere sphere = new ColorSphere(2,2, Color.Blue);

        splash.tryInteract(sphere);
        assertEquals(Color.Red, sphere.getColor());
    }
}