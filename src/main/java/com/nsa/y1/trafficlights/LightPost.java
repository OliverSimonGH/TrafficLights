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
        this.redLight = new Light(Shape.CIRCLE, Colour.RED);
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
        if (leftArrow != null) leftArrow.turnOff();
        else if (rightArrow != null)  rightArrow.turnOff();
        else if (upArrow != null)  upArrow.turnOff();
    }

    public void goGreen(){
        greenLight.turnOn();
        amberLight.turnOff();
        redLight.turnOff();
        if (leftArrow != null) leftArrow.turnOn();
        else if (rightArrow != null)  rightArrow.turnOn();
        else if (upArrow != null)  upArrow.turnOn();
    }

    public void goAmber(){
        greenLight.turnOff();
        amberLight.turnOn();
        redLight.turnOff();
        if (leftArrow != null) leftArrow.turnOff();
        else if (leftArrow != null)  rightArrow.turnOff();
        else if (upArrow != null)  upArrow.turnOff();
    }

    public void goStop(){
        redLight.turnOn();
    }

    @Override
    public String toString() {
        if (upArrow != null){
            return name +
                    "\ngreenLight=" + greenLight +
                    "\namberLight=" + amberLight +
                    "\nredLight=" + redLight +
                    "\nupArrow=" + upArrow +
                    '}';
        } else if (rightArrow != null){
            return name +
                    "\ngreenLight=" + greenLight +
                    "\namberLight=" + amberLight +
                    "\nredLight=" + redLight +
                    "\nrightArrow=" + rightArrow +
                    '}';
        } else if (leftArrow != null){
            return name +
                    "\ngreenLight=" + greenLight +
                    "\namberLight=" + amberLight +
                    "\nredLight=" + redLight +
                    "\nleftArrow=" + leftArrow +
                    '}';
        } else {
            return name +
                    "\ngreenLight=" + greenLight +
                    "\namberLight=" + amberLight +
                    "\nredLight=" + redLight;
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
