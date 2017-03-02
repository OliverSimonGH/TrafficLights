package com.nsa.y1.trafficlights;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by c1633899 on 16/02/2017.
 */
public class LightPostTest {

    @Test //Testing for regular light post
    public void TestingLights() throws Exception {
        LightPost one = new LightPost("LightPostOne");
        one.getGreenLight().turnOn(); // Turn on green light
//        one.setSeconds(2); // Turn on amber light
//        one.setSeconds(3); // Turn on red light
        assertEquals(one.getGreenLight().isOn(), true);
        assertEquals(one.getAmberLight().isOn(), false);
        assertEquals(one.getRedLight().isOn(), false);
    }

    @Test //Testing for light post constructor with arrows
    public void LightPostArrow(){
        LightPost rightLight = new LightPost("LightPostOne", Shape.RIGHT_ARROW);
        rightLight.getRightArrow().turnOn();
        assertEquals(rightLight.getRightArrow().isOn(), true);
        assertEquals(rightLight.getLeftArrow(), null);
        assertEquals(rightLight.getUpArrow(), null);
    }

    @Test
    public void TurnAllLightsOff(){
        LightPost l = new LightPost("LightPostOne");
        l.turnLightsOff();
        assertEquals(l.getGreenLight().isOn(), false);
        assertEquals(l.getAmberLight().isOn(), false);
        assertEquals(l.getRedLight().isOn(), false);
    }

}