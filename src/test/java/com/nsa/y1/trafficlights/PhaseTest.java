package com.nsa.y1.trafficlights;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by c1633899 on 09/03/2017.
 */
public class PhaseTest {

    @Test
    public void ThreadTimerStartLightInPhase() throws Exception {
        Flow flowOne = new Flow("South East Direction, North LightPost", new LightPost("LightPostOne", Shape.LEFT_ARROW));
        Flow flowTwo = new Flow("North West Direction", new LightPost("LightPostTwo"));
        Phase phaseOne = new Phase(1, flowOne, flowTwo, 20);
        phaseOne.setTimerSeconds(2);
        phaseOne.start();
        Thread.sleep(25);
        assertEquals(phaseOne.toString(), "phaseNum: 1  |  Seconds to run: 20\n" +
                "flowOne: name: 'South East Direction, North LightPost', lightPost: LightPostOne\n" +
                "Shape: CIRCLE, Colour: RED, On: false\n" +
                "Shape: CIRCLE, Colour: AMBER, On: false\n" +
                "Shape: CIRCLE, Colour: GREEN, On: true\n" +
                "Shape: LEFT_ARROW, Colour: GREEN, On: true\n" +
                "\n" +
                "flowTwo: name: 'North West Direction', lightPost: LightPostTwo\n" +
                "Shape: CIRCLE, Colour: RED, On: false\n" +
                "Shape: CIRCLE, Colour: AMBER, On: false\n" +
                "Shape: CIRCLE, Colour: GREEN, On: true\n");
    }

    @Test
    public void ThreadTimerReadyToGoLightInPhase() throws Exception {
        Flow flowOne = new Flow("South East Direction, North LightPost", new LightPost("LightPostOne", Shape.LEFT_ARROW));
        Flow flowTwo = new Flow("North West Direction", new LightPost("LightPostTwo"));
        Phase phaseOne = new Phase(1, flowOne, flowTwo, 20);
        phaseOne.setTimerSeconds(10);
        phaseOne.start();
        Thread.sleep(25);
        assertEquals(phaseOne.toString(), "phaseNum: 1  |  Seconds to run: 20\n" +
                "flowOne: name: 'South East Direction, North LightPost', lightPost: LightPostOne\n" +
                "Shape: CIRCLE, Colour: RED, On: false\n" +
                "Shape: CIRCLE, Colour: AMBER, On: true\n" +
                "Shape: CIRCLE, Colour: GREEN, On: false\n" +
                "Shape: LEFT_ARROW, Colour: GREEN, On: false\n" +
                "\n" +
                "flowTwo: name: 'North West Direction', lightPost: LightPostTwo\n" +
                "Shape: CIRCLE, Colour: RED, On: false\n" +
                "Shape: CIRCLE, Colour: AMBER, On: true\n" +
                "Shape: CIRCLE, Colour: GREEN, On: false\n");
    }

    @Test
    public void ThreadTimerStopLightInPhase() throws Exception {
        Flow flowOne = new Flow("South East Direction, North LightPost", new LightPost("LightPostOne", Shape.LEFT_ARROW));
        Flow flowTwo = new Flow("North West Direction", new LightPost("LightPostTwo"));
        Phase phaseOne = new Phase(1, flowOne, flowTwo, 20);
        phaseOne.setTimerSeconds(16);
        phaseOne.start();
        Thread.sleep(25);
        assertEquals(phaseOne.toString(), "phaseNum: 1  |  Seconds to run: 20\n" +
                "flowOne: name: 'South East Direction, North LightPost', lightPost: LightPostOne\n" +
                "Shape: CIRCLE, Colour: RED, On: true\n" +
                "Shape: CIRCLE, Colour: AMBER, On: false\n" +
                "Shape: CIRCLE, Colour: GREEN, On: false\n" +
                "Shape: LEFT_ARROW, Colour: GREEN, On: false\n" +
                "\n" +
                "flowTwo: name: 'North West Direction', lightPost: LightPostTwo\n" +
                "Shape: CIRCLE, Colour: RED, On: true\n" +
                "Shape: CIRCLE, Colour: AMBER, On: false\n" +
                "Shape: CIRCLE, Colour: GREEN, On: false\n");
    }

    @Test
    public void PhaseToStringWithOneTrafficLight() throws Exception {
        Flow flowOne = new Flow("South East Direction, North LightPost", new LightPost("LightPostOne", Shape.LEFT_ARROW));
        Phase phaseOne = new Phase(1, flowOne, 20);
        assertEquals(phaseOne.toString(), "phaseNum: 1  |  Seconds to run: 20\n" +
                "flowOne: name: 'South East Direction, North LightPost', lightPost: LightPostOne\n" +
                "Shape: CIRCLE, Colour: RED, On: false\n" +
                "Shape: CIRCLE, Colour: AMBER, On: false\n" +
                "Shape: CIRCLE, Colour: GREEN, On: false\n" +
                "Shape: LEFT_ARROW, Colour: GREEN, On: false\n");
    }

    @Test
    public void PhaseToStringWithTwoTrafficLight() throws Exception {
        Flow flowOne = new Flow("South East Direction, North LightPost", new LightPost("LightPostOne", Shape.LEFT_ARROW));
        Flow flowTwo = new Flow("North West Direction", new LightPost("LightPostTwo"));
        Phase phaseOne = new Phase(1, flowOne, flowTwo, 20);
        assertEquals(phaseOne.toString(), "phaseNum: 1  |  Seconds to run: 20\n" +
                "flowOne: name: 'South East Direction, North LightPost', lightPost: LightPostOne\n" +
                "Shape: CIRCLE, Colour: RED, On: false\n" +
                "Shape: CIRCLE, Colour: AMBER, On: false\n" +
                "Shape: CIRCLE, Colour: GREEN, On: false\n" +
                "Shape: LEFT_ARROW, Colour: GREEN, On: false\n"  +
                "\n" +
                "flowTwo: name: 'North West Direction', lightPost: LightPostTwo\n" +
                "Shape: CIRCLE, Colour: RED, On: false\n" +
                "Shape: CIRCLE, Colour: AMBER, On: false\n" +
                "Shape: CIRCLE, Colour: GREEN, On: false\n");
    }

    @Test
    public void PhaseToStringWithThreeTrafficLight() throws Exception {
        Flow flowOne = new Flow("South East Direction, North LightPost", new LightPost("LightPostOne", Shape.LEFT_ARROW));
        Flow flowTwo = new Flow("North West Direction", new LightPost("LightPostTwo"));
        Flow flowThree = new Flow("South Direction, South LightPost", new LightPost("LightPostThree", Shape.RIGHT_ARROW));

        Phase phaseOne = new Phase(1, flowOne, flowTwo, flowThree, 20);
        assertEquals(phaseOne.toString(), "phaseNum: 1  |  Seconds to run: 20\n" +
                "flowOne: name: 'South East Direction, North LightPost', lightPost: LightPostOne\n" +
                "Shape: CIRCLE, Colour: RED, On: false\n" +
                "Shape: CIRCLE, Colour: AMBER, On: false\n" +
                "Shape: CIRCLE, Colour: GREEN, On: false\n" +
                "Shape: LEFT_ARROW, Colour: GREEN, On: false\n"  +
                "\n" +
                "flowTwo: name: 'North West Direction', lightPost: LightPostTwo\n" +
                "Shape: CIRCLE, Colour: RED, On: false\n" +
                "Shape: CIRCLE, Colour: AMBER, On: false\n" +
                "Shape: CIRCLE, Colour: GREEN, On: false\n" +
                "\n" +
                "flowThree: name: 'South Direction, South LightPost', lightPost: LightPostThree\n" +
                "Shape: CIRCLE, Colour: RED, On: false\n" +
                "Shape: CIRCLE, Colour: AMBER, On: false\n" +
                "Shape: CIRCLE, Colour: GREEN, On: false\n" +
                "Shape: RIGHT_ARROW, Colour: GREEN, On: false\n");
    }
}