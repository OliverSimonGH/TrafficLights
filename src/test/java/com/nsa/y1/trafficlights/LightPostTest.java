package com.nsa.y1.trafficlights;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by c1633899 on 16/02/2017.
 */
public class LightPostTest {

    @Test //Testing for regular light post
    public void defaultTrafficLightConstructor() throws Exception {
        LightPost one = new LightPost("LightPostOne");
        one.getGreenLight().turnOn(); // Turn on green light
        assertEquals(one.getGreenLight().isOn(), true);
        assertEquals(one.getAmberLight().isOn(), false);
        assertEquals(one.getRedLight().isOn(), false);
    }

    @Test //Testing for light post constructor with arrows
    public void ArrowTrafficLightConstructor(){
        LightPost rightLight = new LightPost("LightPostOne", Shape.RIGHT_ARROW);
        rightLight.getRightArrow().turnOn();
        assertEquals(rightLight.getRightArrow().isOn(), true);
        assertEquals(rightLight.getLeftArrow(), null);
        assertEquals(rightLight.getUpArrow(), null);
    }

    @Test
    public void TurnAllLightsOffNoArrows(){
        LightPost l = new LightPost("LightPostOne");
        l.turnLightsOff();
        assertEquals(l.getGreenLight().isOn(), false);
        assertEquals(l.getAmberLight().isOn(), false);
        assertEquals(l.getRedLight().isOn(), false);
    }

    @Test
    public void TrafficLightTurnGreenNoArrows(){
        LightPost l = new LightPost("LightPostOne");
        l.start();
        assertEquals(l.getGreenLight().isOn(), true);
        assertEquals(l.getAmberLight().isOn(), false);
        assertEquals(l.getRedLight().isOn(), false);
    }

    @Test
    public void TrafficLightTurnAmberNoArrows(){
        LightPost l = new LightPost("LightPostOne");
        l.getReadyToGo();
        assertEquals(l.getGreenLight().isOn(), false);
        assertEquals(l.getAmberLight().isOn(), true);
        assertEquals(l.getRedLight().isOn(), false);
    }

    @Test
    public void TrafficLightTurnRedNoArrows(){
        LightPost l = new LightPost("LightPostOne");
        l.stop();
        assertEquals(l.getGreenLight().isOn(), false);
        assertEquals(l.getAmberLight().isOn(), false);
        assertEquals(l.getRedLight().isOn(), true);
    }
    @Test
    public void TurnAllLightsOffWIthArrowLight(){
        LightPost l = new LightPost("LightPostOne", Shape.RIGHT_ARROW);
        l.turnLightsOff();
        assertEquals(l.getGreenLight().isOn(), false);
        assertEquals(l.getAmberLight().isOn(), false);
        assertEquals(l.getRedLight().isOn(), false);
        assertEquals(l.getRightArrow().isOn(), false);
        assertEquals(l.getLeftArrow(), null);
        assertEquals(l.getRightArrow().isOn(), false);
    }

    @Test
    public void TrafficLightTurnGreenWithArrowLight(){
        LightPost l = new LightPost("LightPostOne", Shape.LEFT_ARROW);
        l.start();
        assertEquals(l.getGreenLight().isOn(), true);
        assertEquals(l.getAmberLight().isOn(), false);
        assertEquals(l.getRedLight().isOn(), false);
        assertEquals(l.getRightArrow(), null);
        assertEquals(l.getLeftArrow().isOn(), true);
        assertEquals(l.getRightArrow(), null);
    }

    @Test
    public void TrafficLightTurnAmberWithArrowLight(){
        LightPost l = new LightPost("LightPostOne");
        l.getReadyToGo();
        assertEquals(l.getGreenLight().isOn(), false);
        assertEquals(l.getAmberLight().isOn(), true);
        assertEquals(l.getRedLight().isOn(), false);
        assertEquals(l.getRightArrow(), null);
        assertEquals(l.getLeftArrow(), null);
        assertEquals(l.getRightArrow(), null);
    }

    @Test
    public void TrafficLightTurnRedWithArrowLight(){
        LightPost l = new LightPost("LightPostOne");
        l.stop();
        assertEquals(l.getGreenLight().isOn(), false);
        assertEquals(l.getAmberLight().isOn(), false);
        assertEquals(l.getRedLight().isOn(), true);
        assertEquals(l.getRightArrow(), null);
        assertEquals(l.getLeftArrow(), null);
        assertEquals(l.getRightArrow(), null);
    }

    @Test
    public void NormalTrafficLightToString(){
        LightPost l = new LightPost("LightPostOne");
        assertEquals(l.toString(), "LightPostOne\n" +
                "Shape: CIRCLE, Colour: RED, On: false\n" +
                "Shape: CIRCLE, Colour: AMBER, On: false\n" +
                "Shape: CIRCLE, Colour: GREEN, On: false");
    }

    @Test
    public void TrafficLightWithArrowsToString(){
        LightPost l = new LightPost("LightPostOne", Shape.RIGHT_ARROW);
        assertEquals(l.toString(), "LightPostOne\n" +
                "Shape: CIRCLE, Colour: RED, On: false\n" +
                "Shape: CIRCLE, Colour: AMBER, On: false\n" +
                "Shape: CIRCLE, Colour: GREEN, On: false\n" +
                "Shape: RIGHT_ARROW, Colour: GREEN, On: false");
    }
}
