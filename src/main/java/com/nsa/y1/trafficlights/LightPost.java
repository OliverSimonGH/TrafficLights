package com.nsa.y1.trafficlights;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by c1633899 on 16/02/2017.
 */
public class LightPost{

    private Light greenLight;
    private Light amberLight;
    private Light redLight;
    private Light leftArrow;
    private Light rightArrow;
    private Light upArrow;
    private String name;

    public LightPost(String name) {
        this.name = name;
        this.greenLight = new Light(Shape.CIRCLE, Colour.GREEN);
        this.amberLight = new Light(Shape.CIRCLE, Colour.AMBER);
        this.redLight = new Light(Shape.CIRCLE, Colour.RED); //Correct
    }

    public LightPost(String name, Shape shape) {
        this.name = name;
        this.greenLight = new Light(Shape.CIRCLE, Colour.GREEN);
        this.amberLight = new Light(Shape.CIRCLE, Colour.AMBER);
        this.redLight = new Light(Shape.CIRCLE, Colour.RED);

        if (shape == Shape.LEFT_ARROW) this.leftArrow = new Light(Shape.LEFT_ARROW, Colour.GREEN);
        if (shape == Shape.RIGHT_ARROW) this.rightArrow = new Light(Shape.RIGHT_ARROW, Colour.GREEN);
        if (shape == Shape.UP_ARROW) this.upArrow = new Light(Shape.UP_ARROW, Colour.GREEN);
    }

    public void turnLightsOff(){
        greenLight.turnOff();
        amberLight.turnOff();
        redLight.turnOff();
        turnArrowsOn(false);
    }

    public void start(){
        greenLight.turnOn();
        amberLight.turnOff();
        redLight.turnOff();
        turnArrowsOn(true);
    }

    public void getReadyToGo(){
        greenLight.turnOff();
        amberLight.turnOn();
        redLight.turnOff();
        turnArrowsOn(false);
    }

    public void stop(){
        amberLight.turnOff();
        redLight.turnOn();
    }

    private void turnArrowsOn(Boolean val) {
        if(val == false){
            if (leftArrow != null) leftArrow.turnOff();
            else if (rightArrow != null)  rightArrow.turnOff();
            else if (upArrow != null)  upArrow.turnOff();
        } else {
            if (leftArrow != null) leftArrow.turnOn();
            else if (rightArrow != null)  rightArrow.turnOn();
            else if (upArrow != null)  upArrow.turnOn();
        }
    }

    @Override
    public String toString() {
        if (upArrow != null){
            return name +
                    "\n" + redLight +
                    "\n" + amberLight +
                    "\n" + greenLight +
                    "\n" + upArrow;
        } else if (rightArrow != null){
            return name +
                    "\n" + redLight +
                    "\n" + amberLight +
                    "\n" + greenLight +
                    "\n" + rightArrow;
        } else if (leftArrow != null){
            return name +
                    "\n" + redLight +
                    "\n" + amberLight +
                    "\n" + greenLight +
                    "\n" + leftArrow;
        } else {
            return name +
                    "\n" + redLight +
                    "\n" + amberLight +
                    "\n" + greenLight;
        }
    }

    public Light getGreenLight() {
        return greenLight;
    }

    public Light getAmberLight() {
        return amberLight;
    }

    public Light getRedLight() {
        return redLight;
    }

    public Light getLeftArrow() {
        return leftArrow;
    }

    public Light getRightArrow() {
        return rightArrow;
    }

    public Light getUpArrow() {
        return upArrow;
    }


}
