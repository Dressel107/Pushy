package com.example.pushyapp.Models.GameElements;

import junit.framework.TestCase;
import org.junit.Test;
import static org.junit.Assert.*;

import com.example.pushyapp.Enums.Color;
import com.example.pushyapp.Enums.Direction;

/**
 * @author Dirk Dresselhaus
 */
public class ColorSphereTest extends TestCase {

    @Test
    public void testReset() {
        ColorSphere cs = new ColorSphere(5,5, Color.Blue);
        cs.move(Direction.Left);
        cs.setColor(Color.Red);
        cs.reset();
        assertEquals(Color.Blue, cs.getColor());
        assertEquals(5,5);
    }

    @Test
    public void testMove() {
        ColorSphere cs = new ColorSphere(5,5, Color.Blue);
        cs.move(Direction.Left);
        assertEquals(4, cs.getX());
    }

    @Test
    public void testTryInteract() {
        ColorSphere colorSphere = new ColorSphere(5,5, Color.Blue);
        ColorSplash colorSplash = new ColorSplash(3,3 ,Color.Red);
        ColorArea colorArea = new ColorArea( 4,4, Color.Red);

        colorSphere.tryInteract(colorSplash);
        assertEquals(Color.Red, colorSphere.getColor());

        colorSphere.tryInteract(colorArea);
        assertEquals(false, colorSphere.isVisible());

    }
}