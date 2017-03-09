package com.nsa.y1.trafficlights;

/**
 * Created by c1633899 on 02/03/2017.
 */
public class Flow {

    private String name;
    private LightPost lightPost;


    public Flow(String name, LightPost lightPost) {
        this.name = name;
        this.lightPost = lightPost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LightPost getLightPost() {
        return lightPost;
    }

    public void setLightPost(LightPost lightPost) {
        this.lightPost = lightPost;
    }

    @Override
    public String toString() {
        return "name: '" + name + '\'' +
                ", lightPost: " + lightPost;
    }
}
