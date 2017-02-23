package com.nsa.y1.trafficlights;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by c1633899 on 16/02/2017.
 */
public class LightPostTest {

    @Test //Testing for regular light post
    public void TestingLights() throws Exception {
        LightPost one = new LightPost();
        one.setSeconds(1); // Turn on green light
//        one.setSeconds(2); // Turn on amber light
//        one.setSeconds(3); // Turn on red light
        one.cycleThroughLights();
        assertEquals(one.getGreenLight().isOn(), true);
        assertEquals(one.getAmberLight().isOn(), false);
        assertEquals(one.getRedLight().isOn(), false);
    }

    @Test //Testing for light post constructor with arrows
    public void LightPostArrow(){
        LightPost rightLight = new LightPost(Shape.RIGHT_ARROW);
        rightLight.getRightArrow().turnOn();
        assertEquals(rightLight.getRightArrow().isOn(), true);
        assertEquals(rightLight.getLeftArrow(), null);
        assertEquals(rightLight.getUpArrow(), null);
        System.out.println(rightLight);
    }

    @Test
    public void CyclingThroughLights(){
        LightPost cycle = new LightPost();
        cycle.setSeconds(1);
        if (cycle.getSeconds() >= 0 && cycle.getSeconds() <= 21){
            assertEquals(cycle.getGreenLight().isOn(), true);
        }
        cycle.setSeconds(22);
        if (cycle.getSeconds() >= 22 && cycle.getSeconds() <= 23){
            assertEquals(cycle.getAmberLight().isOn(), true);
            assertEquals(cycle.getGreenLight().isOn(), true);
        }
        cycle.setSeconds(24);
        if (cycle.getSeconds() >= 24){
            assertEquals(cycle.getAmberLight().isOn(), true);
            assertEquals(cycle.getGreenLight().isOn(), false);
            assertEquals(cycle.getRedLight().isOn(), false);
        }
        cycle.setSeconds(25);
        if (cycle.getSeconds() >= 25 && cycle.getSeconds() <= 26){
            assertEquals(cycle.getAmberLight().isOn(), true);
            assertEquals(cycle.getRedLight().isOn(), true);
        }
        cycle.setSeconds(30);
        if (cycle.getSeconds() >= 27 && cycle.getSeconds() <= 45){
            assertEquals(cycle.getRedLight().isOn(), true);
        }
    }

}