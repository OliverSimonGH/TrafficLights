package com.nsa.y1.trafficlights;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by c1633899 on 20/02/2017.
 */
public class Phase{

    LightPost lightPostOne = new LightPost("LightPostOne", Shape.LEFT_ARROW);
    LightPost lightPostTwo = new LightPost("LightPostTwo",Shape.RIGHT_ARROW);
    LightPost lightPostThree = new LightPost("LightPostThree");
    LightPost lightPostFour = new LightPost("LightPostFour");
    LightPost lightPostFive = new LightPost("LightPostFive");
    LightPost lightPostSix = new LightPost("LightPostSix");

    public void phaseOne(){

    }

    public void phaseTwo(){

    }

    public void phaseThree(){

    }

    private void printTrafficLights(){
        System.out.println(lightPostOne);
        System.out.println(lightPostTwo);
        System.out.println(lightPostThree);
        System.out.println(lightPostFour);
        System.out.println(lightPostFive);
        System.out.println(lightPostSix);
    }
}
