package com.nsa.y1.trafficlights;

/**
 * Created by c1633899 on 20/02/2017.
 */
public class Phase {

    LightPost lightPostOne = new LightPost(Shape.LEFT_ARROW);
    LightPost lightPostTwo = new LightPost(Shape.RIGHT_ARROW);
    LightPost lightPostThree = new LightPost();
    LightPost lightPostFour = new LightPost();
    LightPost lightPostFive = new LightPost();
    LightPost lightPostSix = new LightPost();

    public Phase(int num) {
        if (num == 1) {
            PhaseOne();
        } else if (num == 2){
            PhaseTwo();
        } else if (num == 3){
            PhaseThree();
        } else {
            System.out.println("Invalid number: Enter 1, 2 or 3.");
        }
    }

    public void PhaseOne(){
        lightPostOne.start();
        lightPostThree.start();

        if (lightPostOne.getGreenLight().isOn() && lightPostThree.getGreenLight().isOn()) {
            lightPostTwo.getRedLight().turnOn();
            lightPostFour.getRedLight().turnOn();
            lightPostFive.getRedLight().turnOn();
            lightPostSix.getRedLight().turnOn();
        }

        if (lightPostOne.getRedLight().isOn() && lightPostThree.getRedLight().isOn()) {
            lightPostTwo.turnLightsOff();
            lightPostFour.turnLightsOff();
            lightPostFive.turnLightsOff();
            lightPostSix.turnLightsOff();
            lightPostOne.stop();
            lightPostThree.stop();
            PhaseTwo();
        }
    }

     public void PhaseTwo(){
         lightPostOne.setSeconds(21);
         lightPostTwo.setSeconds(21);
         lightPostFour.setSeconds(21);

         lightPostOne.start();
         lightPostTwo.start();
         lightPostFour.start();

         if (lightPostOne.getGreenLight().isOn() && lightPostTwo.getGreenLight().isOn() && lightPostFour.getGreenLight().isOn()){
             lightPostThree.getRedLight().turnOn();
             lightPostFive.getRedLight().turnOn();
             lightPostSix.getRedLight().turnOn();
         }

         if (lightPostOne.getRedLight().isOn() && lightPostTwo.getRedLight().isOn() && lightPostFour.getRedLight().isOn()){
             lightPostThree.turnLightsOff();
             lightPostFive.turnLightsOff();
             lightPostSix.turnLightsOff();
             lightPostOne.stop();
             lightPostTwo.stop();
             lightPostFour.stop();
             PhaseThree();
         }
     }

     public void PhaseThree(){
        lightPostFour.setSeconds(21);
     }

    public static void main(String[] args) {

    }
}
