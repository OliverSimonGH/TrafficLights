package com.nsa.y1.trafficlights;

public class Application {

    public static void main(String[] args) {
        Flow flowOne = new Flow("South East Direction, North LightPost", new LightPost("LightPostOne", Shape.LEFT_ARROW));
        Flow flowTwo = new Flow("North West Direction", new LightPost("LightPostTwo"));
        Phase phaseOne = new Phase(1, flowOne, flowTwo, 20);
        phaseOne.start();
        phaseOne.halt();

        Flow flowThree = new Flow("South Direction, South LightPost", new LightPost("LightPostThree", Shape.RIGHT_ARROW));
        Flow flowFour = new Flow("North Direction, West LightPost", new LightPost("lightPostFour"));
        Phase phaseTwo = new Phase(2, flowOne, flowThree, flowFour, 20);
        phaseTwo.start();
        phaseTwo.halt();

        Flow flowFive = new Flow("North East Direction, East LightPost", new LightPost("LightPostFour", Shape.RIGHT_ARROW));
        Phase phaseThree = new Phase(3, flowFive, flowFour, 20);
        phaseThree.start();
    }
}
