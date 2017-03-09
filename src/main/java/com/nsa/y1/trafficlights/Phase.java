package com.nsa.y1.trafficlights;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by c1633899 on 20/02/2017.
 */
public class Phase{

    static Timer timer = new Timer();
    private int phaseNum;
    private Flow flowOne;
    private Flow flowTwo;
    private Flow flowThree;
    private int seconds;
    private int timerSeconds = 0;

    public Phase(int phaseNum, Flow flowOne, int seconds) {
        this.phaseNum = phaseNum;
        this.flowOne = flowOne;
        this.seconds = seconds;
    }

    public Phase(int phaseNum, Flow flowOne, Flow flowTwo, int seconds) {
        this.phaseNum = phaseNum;
        this.flowOne = flowOne;
        this.flowTwo = flowTwo;
        this.seconds = seconds;
    }

    public Phase(int phaseNum, Flow flowOne, Flow flowTwo, Flow flowThree, int seconds) {
        this.phaseNum = phaseNum;
        this.flowOne = flowOne;
        this.flowTwo = flowTwo;
        this.flowThree = flowThree;
        this.seconds = seconds;
    }

    private void lightFlow(int val){
        if (val >= 0 && val < Math.floor(seconds / 2.2)) {
            flowOne.getLightPost().start();
            if (flowTwo != null) flowTwo.getLightPost().start();
            if (flowThree != null)flowThree.getLightPost().start();
        } else if (val >= Math.floor(seconds / 2.2) && val < Math.floor(seconds / 1.6)){
            flowOne.getLightPost().getReadyToGo();
            if (flowTwo != null)  flowTwo.getLightPost().getReadyToGo();
            if (flowThree != null) flowThree.getLightPost().getReadyToGo();
        } else if (val >= Math.floor(seconds / 1.6) && val <= seconds){
            flowOne.getLightPost().stop();
            if (flowTwo != null) flowTwo.getLightPost().stop();
            if (flowThree != null) flowThree.getLightPost().stop();
        }

//        http://stackoverflow.com/questions/8753959/round-a-floating-point-number-to-the-next-integer-value-in-java
        if (val == 0) System.out.println(Phase.this.toString());
        if (val == Math.floor(seconds / 2.2) ) System.out.println(Phase.this.toString());
        if (val == Math.floor(seconds / 1.6)) System.out.println(Phase.this.toString());
    }

//    http://stackoverflow.com/questions/23095690/how-to-use-java-util-timer
    public void start() {
        TimerTask task;

        task = new TimerTask() {
            @Override
            public void run() {
                if (timerSeconds < seconds) {
                    lightFlow(timerSeconds);
                    timerSeconds++;
                } else {
                    cancel();
                }
            }
        };
        timer.schedule(task, 0, 1000);
    }

    public void halt(){
        int num = seconds * 1000;
        try{
            Thread.sleep(num);
        } catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }

    public void setTimerSeconds(int timerSeconds) {
        this.timerSeconds = timerSeconds;
    }

    @Override
    public String toString() {
        if (flowTwo == null) {
            return "phaseNum: " + phaseNum +
                    "  |  Seconds to run: " + seconds +
                    "\nflowOne: " + flowOne + "\n";
        }
        else if (flowThree == null){
            return "phaseNum: " + phaseNum +
                    "  |  Seconds to run: " + seconds +
                    "\nflowOne: " + flowOne +
                    "\n\nflowTwo: " + flowTwo + "\n";
        } else{
            return "phaseNum: " + phaseNum +
                    "  |  Seconds to run: " + seconds +
                    "\nflowOne: " + flowOne +
                    "\n\nflowTwo: " + flowTwo +
                    "\n\nflowThree: " + flowThree + "\n";
        }
    }

}
