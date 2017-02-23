package com.nsa.y1.trafficlights;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by c1633899 on 16/02/2017.
 */
public class LightPost extends Light {

    private Light greenLight;
    private Light amberLight;
    private Light redLight;
    private Light leftArrow;
    private Light rightArrow;
    private Light upArrow;
    private long seconds = 0;
    private boolean increment = true;

    public LightPost() {
        this.greenLight = new Light(Shape.CIRCLE, Colour.GREEN);
        this.amberLight = new Light(Shape.CIRCLE, Colour.AMBER);
        this.redLight = new Light(Shape.CIRCLE, Colour.RED);
    }

    public LightPost(Shape shape) {
        this.greenLight = new Light(Shape.CIRCLE, Colour.GREEN);
        this.amberLight = new Light(Shape.CIRCLE, Colour.AMBER);
        this.redLight = new Light(Shape.CIRCLE, Colour.RED);

        if (shape == Shape.LEFT_ARROW) this.leftArrow = new Light(Shape.LEFT_ARROW, Colour.GREEN);
        if (shape == Shape.RIGHT_ARROW) this.rightArrow = new Light(Shape.RIGHT_ARROW, Colour.GREEN);
        if (shape == Shape.UP_ARROW) this.upArrow = new Light(Shape.UP_ARROW, Colour.GREEN);
    }

    Timer timer = new Timer();
    TimerTask task = new TimerTask() {
        @Override
        public void run() {
            cycleThroughLights();
            System.out.println(seconds);
        }
    };
    public void start(){
        timer.scheduleAtFixedRate(task, 1000, 1000);
    }

    public void stop() { timer.cancel(); timer.purge(); seconds = 0;}

    public void cycleThroughLights() {
        if (increment) seconds++;
        if (!increment) seconds--;
        if (seconds == 0) increment = true;
        if (seconds >= 0 && seconds <= 21) {
            greenLight.turnOn();
            if(rightArrow != null) rightArrow.turnOn();
            else if(leftArrow != null) leftArrow.turnOn();
            else if(upArrow != null) upArrow.turnOn();
        }
        else if (seconds >= 22 && seconds <= 26) {
            amberLight.turnOn();
            if (seconds == 24){
                greenLight.turnOff();
                redLight.turnOff();
                if(rightArrow != null) rightArrow.turnOff();
                else if(leftArrow != null) leftArrow.turnOff();
                else if(upArrow != null) upArrow.turnOff();
            }
        }
        else if (seconds >= 27 && seconds <= 45) {
            amberLight.turnOff();
            redLight.turnOn();
        } else {
            increment = false;
        }
    }

    public void turnLightsOff(){
        greenLight.turnOff();
        amberLight.turnOff();
        redLight.turnOff();
        upArrow.turnOff();
        rightArrow.turnOff();
        leftArrow.turnOff();
    }

    @Override
    public String toString() {
        return "LightPost{" +
                "\ngreenLight=" + greenLight +
                "\namberLight=" + amberLight +
                "\nredLight=" + redLight +
                "\nleftArrow=" + leftArrow +
                "| rightArrow=" + rightArrow +
                "| upArrow=" + upArrow +
                '}';
    }

    public static void main(String[] args) {
        LightPost l = new LightPost();
        l.start();
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

    public long getSeconds() {
        return seconds;
    }

    public void setSeconds(long seconds) {
        this.seconds = seconds;
    }
}
