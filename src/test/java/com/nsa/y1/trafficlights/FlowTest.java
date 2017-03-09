package com.nsa.y1.trafficlights;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by c1633899 on 09/03/2017.
 */
public class FlowTest {

    @Test
    public void FlowGetName() throws Exception {
        Flow flowOne = new Flow("South East Direction, North LightPost", new LightPost("LightPostOne", Shape.LEFT_ARROW));
        assertEquals(flowOne.getName(), "South East Direction, North LightPost");
    }

    @Test
    public void FlowGetLightPost() throws Exception {
        Flow flowOne = new Flow("South East Direction, North LightPost", new LightPost("LightPostOne", Shape.LEFT_ARROW));
        assertEquals(flowOne.getLightPost().toString(), "LightPostOne\n" +
                "Shape: CIRCLE, Colour: RED, On: false\n" +
                "Shape: CIRCLE, Colour: AMBER, On: false\n" +
                "Shape: CIRCLE, Colour: GREEN, On: false\n" +
                "Shape: LEFT_ARROW, Colour: GREEN, On: false");
    }

    @Test
    public void FlowSetName() throws Exception {
        Flow flowOne = new Flow("South East Direction, North LightPost", new LightPost("LightPostOne", Shape.LEFT_ARROW));
        flowOne.setName("Setting Name Test");
        assertEquals(flowOne.getName(), "Setting Name Test");
    }

    @Test
    public void FlowSetLightPost() throws Exception {
        Flow flowOne = new Flow("South East Direction, North LightPost", new LightPost("LightPostOne", Shape.LEFT_ARROW));
        flowOne.setLightPost(new LightPost("LightPostOne", Shape.UP_ARROW));
        assertEquals(flowOne.getLightPost().toString(), "LightPostOne\n" +
                "Shape: CIRCLE, Colour: RED, On: false\n" +
                "Shape: CIRCLE, Colour: AMBER, On: false\n" +
                "Shape: CIRCLE, Colour: GREEN, On: false\n" +
                "Shape: UP_ARROW, Colour: GREEN, On: false");
    }

    @Test
    public void FlowToString() throws Exception {
        Flow flowOne = new Flow("South East Direction, North LightPost", new LightPost("LightPostOne", Shape.LEFT_ARROW));
        assertEquals(flowOne.toString(), "name: 'South East Direction, North LightPost', lightPost: LightPostOne\n" +
                "Shape: CIRCLE, Colour: RED, On: false\n" +
                "Shape: CIRCLE, Colour: AMBER, On: false\n" +
                "Shape: CIRCLE, Colour: GREEN, On: false\n" +
                "Shape: LEFT_ARROW, Colour: GREEN, On: false");
    }
}